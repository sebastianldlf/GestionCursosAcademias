package com.example.practico2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Curso> cursos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear 10 cursos de ejemplo
        cursos = crearCursosEjemplo();

        // Configurar botones
        Button btnMostrarCursos = findViewById(R.id.btnMostrarCursos);
        Button btnResumenNumerico = findViewById(R.id.btnResumenNumerico);
        ListView listView = findViewById(R.id.listView);

        // Mostrar todos los cursos
        btnMostrarCursos.setOnClickListener(v -> {
            List<String> infoCursos = new ArrayList<>();
            for (Curso curso : cursos) {
                infoCursos.add(curso.mostrarInformacion() + "\n");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoCursos);
            listView.setAdapter(adapter);
        });

        // Mostrar resumen numérico
        btnResumenNumerico.setOnClickListener(v -> mostrarResumenNumerico());
    }

    private List<Curso> crearCursosEjemplo() {
        List<Curso> cursos = new ArrayList<>();

        // 3 Cursos Presenciales
        cursos.add(new CursoPresencial("Matemáticas", 40, 500, "básico", "Prof. López", 3, 50, 100));
        cursos.add(new CursoPresencial("Física", 60, 700, "avanzado", "Dr. Gómez", 4, 75, 150));
        cursos.add(new CursoPresencial("Química", 50, 600, "intermedio", "Dra. Martínez", 2, 60, 120));

        // 4 Cursos en Línea
        cursos.add(new CursoEnLinea("Programación", 30, 400, "intermedio", "Ing. Pérez", "Zoom", true, 200));
        cursos.add(new CursoEnLinea("Diseño Web", 25, 350, "básico", "Lic. Rodríguez", "Teams", false, 180));
        cursos.add(new CursoEnLinea("Bases de Datos", 40, 450, "intermedio", "Ing. Sánchez", "Google Meet", true, 220));
        cursos.add(new CursoEnLinea("IA", 60, 800, "avanzado", "Dr. Chen", "Zoom", true, 300));

        // 3 Cursos Intensivos
        cursos.add(new CursoIntensivo("Marketing Digital", 80, 900, "avanzado", "Lic. Fernández", 10, true, 250));
        cursos.add(new CursoIntensivo("Finanzas", 70, 850, "intermedio", "Econ. Ramírez", 8, false, 230));
        cursos.add(new CursoIntensivo("Redes", 60, 750, "avanzado", "Ing. Torres", 12, true, 270));

        return cursos;
    }

    private void mostrarResumenNumerico() {
        Map<String, Integer> resumen = new HashMap<>();
        resumen.put("Presencial", 0);
        resumen.put("En Línea", 0);
        resumen.put("Intensivo", 0);

        for (Curso curso : cursos) {
            String tipo = curso instanceof CursoPresencial ? "Presencial" :
                    curso instanceof CursoEnLinea ? "En Línea" : "Intensivo";
            resumen.put(tipo, resumen.get(tipo) + curso.getNumber());
        }

        StringBuilder mensaje = new StringBuilder("RESUMEN DEL ATRIBUTO 'number'\n\n");
        for (Map.Entry<String, Integer> entry : resumen.entrySet()) {
            mensaje.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        new AlertDialog.Builder(this)
                .setTitle("Resumen Numérico")
                .setMessage(mensaje.toString())
                .setPositiveButton("OK", null)
                .show();
    }
}