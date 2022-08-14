package co.edu.unisabana.CRUD.Service;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import co.edu.unisabana.CRUD.controller.TeamController;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TeamService {
    //Lista
    private List<TeamDTO> team;
    private TeamController controller;

    public TeamService() {
        team = new ArrayList<>();
        team.add(new TeamDTO(1, 16, "postobon", "Colombia", "Millonarios"));
        team.add(new TeamDTO(2, 23, "postobon", "Colombia", "Atletico Nacional"));

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
        Integer a = numJugadores();
        Integer b = pais();
        Integer c = name();
        if (a + b + c == 3) {
            team.add(equipo);
        }
        return equipo;
    }

    // este metodo restringe el numero de jugadores por equipo
    private Integer numJugadores() {
        for (TeamDTO i : team) {
            if (i.getNumJugadores() > 25) {
                controller.ok();
                return 1;
            }
        }
        controller.BadRequest();
        System.out.println("La liga Postobon no permite mas de 25 jugadores tendra que recindir el contrato de alguno" +
                "si quiere continuar con la creacion de su equipo");
        return 0;
    }


    // este metodo hace que al crear el equipo este solo pueda ser creado en Colombia
    private Integer pais() {
        String pais = "";
        for (TeamDTO i : team) {
            if (i.getPais() != "colombia".toUpperCase()) {
                controller.ok();
                return 1;
            }
        }
        controller.BadRequest();
        System.out.println("El equipo a crear solo puede ser de Colombia");
        return 0;
    }

    // este metodo hace que al crear un equipo no se puedan repetir los nombres entre equipos
    private Integer name() {
        String nombre = "";
        for (TeamDTO i : team) {
            if (i.getNombre() == nombre) {
                controller.ok();
                return 1;
            }
        }
        controller.BadRequest();
        System.out.println("Lo lamentamos ese nombre de equipo ya existe ingrese otro nombre para poder crear a su equipo");
        return 0;
    }
    /* Este metodo encuenctra el ultimo id y pone al nuevo equipo creado con el siguiente id disponible
    private Integer getMaximo() {
        int size = team.size();
        if (size >0 ){
            return team.get(size -1).getId()+1;
        }else{
            return 1;
        }
    }*/

    //Eliminar
    public boolean borrar(int id) {
        for (TeamDTO c : team) {
            if (c.getId() == id) {
                return team.remove(c);
            }
        }
        return false;
    }

    //Actualizar
    public TeamDTO actualizar(int id, TeamDTO equipo) {
        Integer a = numJugadores();
        Integer b = pais();
        Integer c = name();
        if (a + b + c == 3) {
            guardar(equipo);
            borrar(id);
        }

        return equipo;
    }

}