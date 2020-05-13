package com.company;
import com.company.*;

import java.util.ArrayList;

public class Rutina {
    private String nombre;
    private ArrayList<Instruccion> instrucciones;

    public Rutina(String nombre, Instruccion instruccion) {
        this.nombre=nombre;
        this.instrucciones=new ArrayList<>();
        instrucciones.add(instruccion);
    }


    public void addInstrucciones(Instruccion instruccion) {
        this.instrucciones.add(instruccion);
    }

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

}
