package com.company;

public class Variable {
    private String nombre;
    private int valor;

    public Variable(String nombre){
        this.nombre=nombre;
        this.valor=0;
    }

    public Variable(String nombre, int valor){
        this.nombre=nombre;
        this.valor=valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
