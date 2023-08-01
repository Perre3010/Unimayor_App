package Clases;

public class Horarios {
    private String nom_materia;
    private String horario;

    public Horarios(String nom_materia, String horario) {
        this.nom_materia = nom_materia;
        this.horario = horario;
    }

    public Horarios() {
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
