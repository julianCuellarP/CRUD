package co.edu.unisabana.CRUD.controller;

import co.edu.unisabana.CRUD.DELETE.TeamDelete;
import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.POST.TeamPost;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/equipos")
public class TeamController {

    private final TeamPost servicio;
    ArrayList teams;

    public TeamController(TeamPost servicio) {
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

    @GetMapping("/delete")
    public void delete() {
        TeamDelete eliminar = new TeamDelete();

    }


}
