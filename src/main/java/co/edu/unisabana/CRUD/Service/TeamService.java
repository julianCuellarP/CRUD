package co.edu.unisabana.CRUD.Service;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    //Lista
    private List<TeamDTO> team;

    public TeamService() {
        team = new ArrayList<>();
        team.add(new TeamDTO(1, 16, "postobon", "Colombia", "Millonarios"));
    }

    public List<TeamDTO> list() {
        return team;
    }

    //Buscar
    public TeamDTO busca(int id) {
        for (TeamDTO team : team) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    // Crear
    public TeamDTO guardar(TeamDTO equipo) {
        team.add(equipo);
        return equipo;
    }

    // Actualizar
    public TeamDTO actualizar(Integer id, TeamDTO equipo) {
        int index = 0;
        for (TeamDTO l : team) {
            if (l.getId() == id) {
                equipo.setId(id);
                team.set(index, equipo);
            }
        }
        return equipo;
    }

    //Eliminar
    public boolean borrar(int id) {
        for (TeamDTO c : team) {
            if (c.getId() == id) {
                return team.remove(c);
            }
        }
        return false;
    }
}
