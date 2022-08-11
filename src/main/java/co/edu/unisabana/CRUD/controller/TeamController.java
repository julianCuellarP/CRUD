package co.edu.unisabana.CRUD.controller;

import co.edu.unisabana.CRUD.DELETE.TeamDelete;
import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.POST.TeamPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {

    ArrayList teams;

    @GetMapping("/search")
    public List<TeamDTO> busqueda(@RequestParam String q) {

    }

    @GetMapping("/delete")
    public void delete() {
        TeamDelete eliminar = new TeamDelete();

    }

    @GetMapping("/post")
    public void post() {
        TeamPost subir = new TeamPost();

    }

}
