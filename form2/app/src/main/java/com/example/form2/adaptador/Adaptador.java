package com.example.form2.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.form2.R;
import com.example.form2.item_detalles;
import com.example.form2.usuario.Tarea;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>  {
    private ArrayList<Tarea> datos = new ArrayList<>();
    private Context context;
    private String[] estado;

    public Adaptador(Context context, ArrayList<Tarea> datos) {
        this.datos = datos;
        this.context = context;
        this.estado = context.getResources().getStringArray(R.array.estado);
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        Tarea tarea = datos.get(position);
        holder.txt_nombre.setText(tarea.getNombre());
        holder.txt_estado.setText(tarea.getEstado());
        Picasso.get().load(tarea.getImg()).into(holder.img_tarea);
        holder.txt_titulo.setText(tarea.getCategoria());

        // Cambiar el color del card en función del estado
        switch (tarea.getEstado().toLowerCase()) {
            case "activo":
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorActivo));
                break;
            case "pendiente":
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPendiente));
                break;
            case "cerrado":
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCerrado));
                break;
            default:
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorDefault));
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, item_detalles.class);
                intent.putExtra("nombre", tarea.getNombre());
                intent.putExtra("categoria", tarea.getCategoria());
                intent.putExtra("estado", tarea.getEstado());
                intent.putExtra("imagen", tarea.getImg());
                intent.putExtra("descripcion", tarea.getDescripcion());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {


        TextView txt_titulo, txt_descripcion, txt_nombre, txt_estado;
        ImageView img_tarea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_titulo = itemView.findViewById(R.id.txt_titulo);
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_estado = itemView.findViewById(R.id.txt_estado);
            img_tarea = itemView.findViewById(R.id.img_tarea);

        }
        public void bind(Tarea dato) {
            txt_nombre.setText(dato.getNombre());
            txt_estado.setText(dato.getEstado());
            Picasso.get().load(dato.getImg()).into(img_tarea);
        }

    }
}
