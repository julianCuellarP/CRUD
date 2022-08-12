package co.edu.unisabana.CRUD.controller;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.Service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
public class TeamController {

    private final TeamService servicio;

    public TeamController(TeamService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public Iterable<TeamDTO> list() {
        return servicio.list();
    }

    @GetMapping("/{id}")
    public TeamDTO buscar(@PathVariable("id") int id) {
        return servicio.busca(id);
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


}
