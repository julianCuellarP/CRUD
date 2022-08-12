package co.edu.unisabana.CRUD.Service;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import java.util.ArrayList;
import java.util.List;


public class TeamService {
    private List<TeamDTO> team;

    public void TeamPost() {
        team = new ArrayList<>();
        team.add(new TeamDTO(16, "postobon", "Colombia", "Millonarios"));
    }

    public List<TeamDTO> list() {
        return team;
    }

    // Crear
    public TeamDTO guardar(TeamDTO equipo) {
        team.add(equipo);
        return equipo;
    }

    // Actualizar
    public TeamDTO actualizar(String nombre, TeamDTO equipo) {
        for (TeamDTO l : team) {
            if (l.getNombre() == nombre) {
                equipo.setNombre(nombre);
                team.set(0, equipo);
            }
        }
        return equipo;
    }
}
