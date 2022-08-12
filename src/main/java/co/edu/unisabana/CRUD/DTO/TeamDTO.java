package co.edu.unisabana.CRUD.DTO;


public class TeamDTO {
    Integer id;
    Integer numJugadores;
    String liga;
    String pais;
    String nombre;


    public TeamDTO(Integer id, Integer numJugadores, String liga, String pais, String nombre) {
        this.id = id;
        this.numJugadores = numJugadores;
        this.liga = liga;
        this.pais = pais;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(Integer numJugadores) {
        this.numJugadores = numJugadores;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
