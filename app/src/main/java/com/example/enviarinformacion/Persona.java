package com.example.enviarinformacion;

public class Persona {
    Integer id;
    String nombre;

    public Persona(Integer id, String nombre) {
        this.id = id;
        nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }
}
