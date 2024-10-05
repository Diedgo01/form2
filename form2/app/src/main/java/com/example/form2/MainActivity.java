package com.example.form2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.form2.adaptador.Adaptador;
import com.example.form2.usuario.Tarea;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Tarea> tareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.m_rcv);
        cargarDatos();
        Adaptador adaptador = new Adaptador(this, tareas);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void cargarDatos() {
        String[] nombres = getResources().getStringArray(R.array.nombre_de_tarea);
        String[] materia = getResources().getStringArray(R.array.materia);
        String[] estado = getResources().getStringArray(R.array.estado);

        String[] imagenes = {
             "https://cdn-icons-png.flaticon.com/512/1356/1356627.png",
                "https://cdn.icon-icons.com/icons2/1603/PNG/512/note-task-comment-message-edit-write_108613.png",
                "https://cdn-icons-png.flaticon.com/512/1356/1356627.png",
                "https://cdn.icon-icons.com/icons2/2899/PNG/512/task_icon_182994.png",
                "https://cdn-icons-png.flaticon.com/512/1356/1356627.png",
                "https://cdn.icon-icons.com/icons2/1603/PNG/512/note-task-comment-message-edit-write_108613.png",
                "https://www.flaticon.es/icono-gratis/tarea_762686",
                "https://cdn.icon-icons.com/icons2/2899/PNG/512/task_icon_182994.png",
                "https://cdn-icons-png.flaticon.com/512/1356/1356627.png",
                "https://cdn.icon-icons.com/icons2/1603/PNG/512/note-task-comment-message-edit-write_108613.png"
        };

        String[] descripciones = {
                "Implementación de adaptadores con eventos onClick.",
                "Resolución de ecuaciones con dos variables.",
                "Estudio de la sociedad y cultura en la primera parte.",
                "Exploración filosófica de la inteligencia artificial.",
                "Taller práctico de actividades.",
                "Cuestionario sobre conceptos de física.",
                "Estudio de la ley de Ohm.",
                "Análisis de ondas y calor.",
                "Creación de diagramas de clases.",
                "Taller de creación de diagramas."
        };


        for (int i = 0; i < nombres.length; i++) {
            tareas.add(new Tarea(nombres[i], descripciones[i], estado[i], imagenes[i], materia[i]));
        }
    }
}
