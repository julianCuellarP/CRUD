package co.edu.unisabana.CRUD.controller;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/equipos")
public class TeamController {

    private final TeamService servicio;
    private List<TeamDTO> equipo;

    public TeamController(TeamService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public Iterable<TeamDTO> list() {
        equipo = servicio.list();
        return equipo;
    }

    @GetMapping("/{id}")
    public TeamDTO buscar(@PathVariable("id") int id) {
        return servicio.busca(id);
    }

    @GetMapping("/buscarNom")
    public List<TeamDTO> datos(@RequestParam String q) {
        List<TeamDTO> resultados = new ArrayList<>();
        equipo.forEach(dato -> {
            if (dato.getNombre().contains(q)) {
                ok();
                resultados.add(dato);
            }else {
                NotFound();
            }
        });
        return resultados;
    }

    @GetMapping("/buscarLiga")
    public List<TeamDTO> datosL(@RequestParam String q) {
        List<TeamDTO> resultados = new ArrayList<>();
        equipo.forEach(dato -> {
            if (dato.getLiga().contains(q)) {
                ok();
                resultados.add(dato);
            }else{
                NotFound();
            }
        });
        return resultados;
    }

    @GetMapping("/buscarPais")
    public List<TeamDTO> datosP(@RequestParam String q) {
        List<TeamDTO> resultados = new ArrayList<>();
        equipo.forEach(dato -> {
            if (dato.getPais().contains(q)) {
                ok();
                resultados.add(dato);
            }else{
                NotFound();
            }
        });
        return resultados;
    }

    @PostMapping
    public TeamDTO crear(@RequestBody TeamDTO equipo) {
        return servicio.guardar(equipo);
    }


    @PutMapping("/{id}")
    public TeamDTO actualizar(@PathVariable("id") int id, @RequestBody TeamDTO equipo) {
        return servicio.actualizar(id, equipo);
    }

    @DeleteMapping("/{id}")
    public boolean borrar(@PathVariable("id") int id) {
        return servicio.borrar(id);
    }

    public String ok(){
        return "The request was successfully completed.CODE 200";
    }
    public String NotFound (){
        return"The requested resource was not found.CODE 404";
    }
    public String BadRequest(){
        return"The request was invalid.CODE 400";
    }



}