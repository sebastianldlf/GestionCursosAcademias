package com.example.practico2;

public class CursoEnLinea extends Curso {
    private String plataforma;
    private boolean accesoGrabaciones;

    public CursoEnLinea(String nombreCurso, int duracionHoras, double costoBase,
                        String nivel, String instructor, String plataforma,
                        boolean accesoGrabaciones, int number) {
        super(nombreCurso, duracionHoras, costoBase, nivel, instructor, number);
        this.plataforma = plataforma;
        this.accesoGrabaciones = accesoGrabaciones;
    }

    @Override
    public double calcularCostoTotal() {
        return costoBase - (accesoGrabaciones ? 50 : 0);
    }

    @Override
    public String mostrarInformacion() {
        return String.format(
                "EN LÍNEA\nNombre: %s\nDuración: %d hrs\nCosto: $%.2f\nNivel: %s\nInstructor: %s\nPlataforma: %s\nGrabaciones: %s\nNUMBER: %d\nCOSTO TOTAL: $%.2f",
                nombreCurso, duracionHoras, costoBase, nivel, instructor,
                plataforma, accesoGrabaciones ? "Sí" : "No", number, calcularCostoTotal()
        );
    }
}