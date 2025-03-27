package com.example.practico2;

public class CursoPresencial extends Curso {
    private int numeroAulas;
    private double costoMateriales;

    public CursoPresencial(String nombreCurso, int duracionHoras, double costoBase,
                           String nivel, String instructor, int numeroAulas,
                           double costoMateriales, int number) {
        super(nombreCurso, duracionHoras, costoBase, nivel, instructor, number);
        this.numeroAulas = numeroAulas;
        this.costoMateriales = costoMateriales;
    }

    @Override
    public double calcularCostoTotal() {
        return costoBase + (numeroAulas * costoMateriales);
    }

    @Override
    public String mostrarInformacion() {
        return String.format(
                "PRESENCIAL\nNombre: %s\nDuración: %d hrs\nCosto: $%.2f\nNivel: %s\nInstructor: %s\nAulas: %d\nCosto Materiales: $%.2f\nNUMBER: %d\nCOSTO TOTAL: $%.2f",
                nombreCurso, duracionHoras, costoBase, nivel, instructor,
                numeroAulas, costoMateriales, number, calcularCostoTotal()
        );
    }
}