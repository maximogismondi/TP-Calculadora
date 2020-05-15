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

    //METODO PRINCIPAL
    public void addInstrucciones(Instruccion instruccion) {
        this.instrucciones.add(instruccion);
    }

    //GETTERS
        public String getNombre() {
            return nombre;
        }

        public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    //SETTERS
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
}
