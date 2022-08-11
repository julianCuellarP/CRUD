package co.edu.unisabana.CRUD.DTO;



public class TeamDTO {
    Integer Numjugadores;
    String  liga;
    String pais;
    String nombre;

    public TeamDTO(Integer numjugadores, String liga, String pais, String nombre) {
        Numjugadores = numjugadores;
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

    public Integer getNumjugadores() {
        return Numjugadores;
    }

    public void setNumjugadores(Integer numjugadores) {
        Numjugadores = numjugadores;
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
}
