package co.edu.unisabana.CRUD.Service;

import co.edu.unisabana.CRUD.DTO.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TeamService {
    //Lista
    private ArrayList<TeamDTO> team;

    public TeamService() {
        team = new ArrayList<>();
        team.add(new TeamDTO(1, 16, "postobon", "Colombia", "Millonarios"));
        team.add(new TeamDTO(1, 23, "postobon", "Colombia", "Atletico Nacional"));

    }

    public ArrayList<TeamDTO> list() {
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
        numJugadores();
        pais();
        name();
        getMaximo();
        team.add(equipo);
        return equipo;
    }

    // este metodo restringe el numero de jugadores por equipo
    private String numJugadores(){
        for(TeamDTO i: team){
            if (i.getNumJugadores() > 25 ){
                return "El numero de Jugadores es correcto puede crear su equipo";
            }
        }
        return "La liga Postobon no permite mas de 25 jugadores tendra que recindir el contrato de alguno"+
                "si quiere continuar con la creacion de su equipo";
    }


    // este metodo hace que al crear el equipo este solo pueda ser creado en Colombia
    private String pais(){
        String pais = "";
        for(TeamDTO i: team){
            if (i.getPais() != "colombia".toUpperCase()){
                return "El equipo se puede crear sin problema";
            }
        }
        return "El equipo a crear solo puede ser de Colombia";
    }

    // este metodo hace que al crear un equipo no se puedan repetir los nombres entre equipos
    private String name() {
        String nombre = "";
        for(TeamDTO i : team){
            if (i.getNombre() == nombre){
                return "El equipo ha sido creado existosamente";
            }
        }
        return "Lo lamentamos ese nombre de equipo ya existe ingrese otro nombre para poder crear a su equipo";
    }
    // Este metodo encuenctra el ultimo id y pone al nuevo equipo creado con el siguiente id disponible
    private Integer getMaximo() {
        int size = team.size();
        if (size >0 ){
            return team.get(size -1).getId()+1;
        }else{
            return 1;
        }
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

    //Actualizar
    public TeamDTO actualizar(int id, TeamDTO equipo){
        getMaximo();
        name();
        numJugadores();
        guardar(equipo);
        borrar(id);
        return equipo;
    }

}
