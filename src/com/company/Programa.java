package com.company;

import java.util.ArrayList;

public class Programa {
    private ArrayList<Rutina> rutinas;

    public Programa(){
        this.rutinas = new ArrayList<>();
    }

    //METODO PRINCIPAL
        public void agregarInstruccion(String rutina, Instruccion nueva_instruccion){
            boolean rutina_existente = false;
            for(Rutina aux : rutinas){
                if((aux.getNombre()).equals(rutina)){
                    aux.addInstrucciones(nueva_instruccion);
                    rutina_existente = true;
                }
            }
            if(!rutina_existente){
                rutinas.add(new Rutina(rutina, nueva_instruccion));
            }
        }

    //GETTER
        public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

    //SETTER
        public void setRutinas(ArrayList<Rutina> rutinas) {
        this.rutinas = rutinas;
    }
}
