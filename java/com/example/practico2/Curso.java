package com.example.practico2;

public abstract class Curso {
    protected String nombreCurso;
    protected int duracionHoras;
    protected double costoBase;
    protected String nivel;
    protected String instructor;
    protected int number;

    public Curso(String nombreCurso, int duracionHoras, double costoBase,
                 String nivel, String instructor, int number) {
        this.nombreCurso = nombreCurso;
        this.duracionHoras = duracionHoras;
        this.costoBase = costoBase;
        this.nivel = nivel;
        this.instructor = instructor;
        this.number = number;
    }

    public abstract double calcularCostoTotal();
    public abstract String mostrarInformacion();


    public int getNumber() {
        return number;
    }
}