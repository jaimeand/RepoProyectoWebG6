package com.sprint4.mongorepository.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Proyectos {

    @Id
    private String id;
    @Field
    private String nombreProyecto;
    private String objetivoEspecifico;
    private String objetivoGeneral;
    private String presupuesto;
    private String fechaInicial;
    private String fechaFinal;
    private String director;
    private String estado;
    private String avance;

    public Proyectos(){

    }

    public Proyectos(String nombreProyecto, String objetivoEspecifico, String objetivoGeneral, String presupuesto, String fechaInicial, String fechaFinal, String director, String estado, String avance) {
        this.nombreProyecto = nombreProyecto;
        this.objetivoEspecifico = objetivoEspecifico;
        this.objetivoGeneral = objetivoGeneral;
        this.presupuesto = presupuesto;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.director = director;
        this.estado = estado;
        this.avance = avance;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    @Override
    public String toString() {
        return "Proyectos{" +
                "id='" + id + '\'' +
                ", nombreProyecto='" + nombreProyecto + '\'' +
                ", objetivoEspecifico='" + objetivoEspecifico + '\'' +
                ", objetivoGeneral='" + objetivoGeneral + '\'' +
                ", presupuesto='" + presupuesto + '\'' +
                ", fechaInicial='" + fechaInicial + '\'' +
                ", fechaFinal='" + fechaFinal + '\'' +
                ", director='" + director + '\'' +
                ", estado='" + estado + '\'' +
                ", avance='" + avance + '\'' +
                '}';
    }
}
