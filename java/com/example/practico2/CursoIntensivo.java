package com.example.practico2;

public class CursoIntensivo extends Curso {
    private int numeroDias;
    private boolean tareasAdicionales;

    public CursoIntensivo(String nombreCurso, int duracionHoras, double costoBase,
                          String nivel, String instructor, int numeroDias,
                          boolean tareasAdicionales, int number) {
        super(nombreCurso, duracionHoras, costoBase, nivel, instructor, number);
        this.numeroDias = numeroDias;
        this.tareasAdicionales = tareasAdicionales;
    }

    @Override
    public double calcularCostoTotal() {
        return costoBase + (numeroDias * 30) + (tareasAdicionales ? 20 : 0);
    }

    @Override
    public String mostrarInformacion() {
        return String.format(
                "INTENSIVO\nNombre: %s\nDuración: %d hrs\nCosto: $%.2f\nNivel: %s\nInstructor: %s\nDías: %d\nTareas Extra: %s\nNUMBER: %d\nCOSTO TOTAL: $%.2f",
                nombreCurso, duracionHoras, costoBase, nivel, instructor,
                numeroDias, tareasAdicionales ? "Sí" : "No", number, calcularCostoTotal()
        );
    }
}