package com.servicsofts.miscontactos;

public class Mascota {
    private String nombre;
    private String apellido;
    private String email;
    private int  foto;
    private int like;
    private int id;


    public Mascota(int foto, String nombre, String email, int like) {
        this.nombre = nombre;
        this.email = email;
        this.foto= foto;
        this.like = like;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
