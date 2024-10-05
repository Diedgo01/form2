package com.example.form2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class item_detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_detalles);

        // Retrieve the data from the intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String categoria = intent.getStringExtra("categoria");
        String estado = intent.getStringExtra("estado");
        String imagen = intent.getStringExtra("imagen");
        String descripcion = intent.getStringExtra("descripcion");

        // Find your views and set the data
        TextView txtNombre = findViewById(R.id.txt_nombre);
        TextView txtCategoria = findViewById(R.id.txt_categoria);
        TextView txtEstado = findViewById(R.id.txt_estado);
        TextView txtDescripcion = findViewById(R.id.txt_descripcion);
        ImageView imgTarea = findViewById(R.id.img_tarea);

        txtNombre.setText(nombre);
        txtCategoria.setText(categoria);
        txtEstado.setText(estado);
        txtDescripcion.setText(descripcion);
        Picasso.get().load(imagen).into(imgTarea);
    }
}
