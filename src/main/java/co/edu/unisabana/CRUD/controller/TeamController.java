package co.edu.unisabana.CRUD.controller;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.Service.TeamService;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/cliente")
public class TeamController {

    private final TeamService servicio;

    public TeamController(TeamService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public Iterable<TeamDTO> list() {
        return servicio.list();
    }

    @PostMapping
    public TeamDTO crear(@RequestBody TeamDTO equipo) {
        return servicio.guardar(equipo);
    }

    @PutMapping
    public TeamDTO update(@PathVariable("nombre") String nombre, @RequestBody TeamDTO equipo){
        return servicio.actualizar(nombre, equipo);
    }

    @DeleteMapping
    public void delete() {


    }


}
