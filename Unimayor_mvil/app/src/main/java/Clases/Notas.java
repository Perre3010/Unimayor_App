package Clases;

public class Notas {
    private String nom_materia;
    private double nota_examen1;
    private double nota_examen2;
    private double nota_examen3;
    private double nota_definitiva;
    private double nota_habilitacion;

    public Notas(String nom_materia, double nota_examen1, double nota_examen2, double nota_examen3, double nota_definitiva, double nota_habilitacion) {
        this.nom_materia = nom_materia;
        this.nota_examen1 = nota_examen1;
        this.nota_examen2 = nota_examen2;
        this.nota_examen3 = nota_examen3;
        this.nota_definitiva = nota_definitiva;
        this.nota_habilitacion = nota_habilitacion;
    }

    public Notas() {
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
    }

    public double getNota_examen1() {
        return nota_examen1;
    }

    public void setNota_examen1(double nota_examen1) {
        this.nota_examen1 = nota_examen1;
    }

    public double getNota_examen2() {
        return nota_examen2;
    }

    public void setNota_examen2(double nota_examen2) {
        this.nota_examen2 = nota_examen2;
    }

    public double getNota_examen3() {
        return nota_examen3;
    }

    public void setNota_examen3(double nota_examen3) {
        this.nota_examen3 = nota_examen3;
    }

    public double getNota_definitiva() {
        return nota_definitiva;
    }

    public void setNota_definitiva(double nota_definitiva) {
        this.nota_definitiva = nota_definitiva;
    }

    public double getNota_habilitacion() {
        return nota_habilitacion;
    }

    public void setNota_habilitacion(double nota_habilitacion) {
        this.nota_habilitacion = nota_habilitacion;
    }
}
