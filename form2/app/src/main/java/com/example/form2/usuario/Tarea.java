package com.example.form2.usuario;

public class Tarea {

    String nombre;
    String descripcion;
    String estado;
    String img;
    String categoria;


    public Tarea(String nombre, String descripcion, String estado, String img, String categoria ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.img = img;
        this.categoria = categoria;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}