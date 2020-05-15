package com.company;

import java.util.ArrayList;

public class Calculadora {

    private Programa programa;
    private ArrayList<Integer> pila;
    private ArrayList<Variable> memoria;

    public Calculadora() {
        this.programa = new Programa();
        this.pila = new ArrayList<>();
        this.memoria = new ArrayList<>();
    }

    //GETTERS
        public ArrayList<Integer> getPila() {
            return pila;
        }

        public ArrayList<Variable> getMemoria() {
            return memoria;
        }

        public Programa getPrograma() {
            return programa;
        }

    //SETTERS
        public void setMemoria(ArrayList<Variable> memoria) {
            this.memoria = memoria;
        }

        public void setPila(ArrayList<Integer> pila) {
            this.pila = pila;
        }

        public void setPrograma(Programa programa) {
            this.programa = programa;
        }

    //OPERACIONES BASICAS
        public void add() {
            if (pila.size() == 0) pila.add(0);
            else if (pila.size() >1) {
                pila.add(pila.get(0) + pila.get(1));
                pila.remove(0);
                pila.remove(0);
            }
        }

        public void mul() {
            if (pila.size() == 0) pila.add(0);
            else if (pila.size() >1) {
                pila.add(pila.get(0) * pila.get(1));
                pila.remove(0);
                pila.remove(0);
            }
        }

        public void sub() {
            if (pila.size() == 0) pila.add(0);
            else if (pila.size() >1) {
                pila.add(pila.get(0) - pila.get(1));
                pila.remove(0);
                pila.remove(0);
            }
        }

        public void push(Integer num) {
            pila.add(num);
        }

    //OPERACIONS CON VARIABLES
        public void write(Variable num) {
            num.setValor(pila.get(0));
            pila.remove(0);
        }

        public void read(Variable num) {
            if(pila!=null) {
                pila.add(num.getValor());
            }
        }

        public Variable buscarVariablePorSuNombre(String nombreVariable){
            if(memoria!=null){
                for (Variable aux : this.memoria){
                    if( (aux.getNombre()).equals(nombreVariable) ){
                        return  aux;
                    }
                }
            }
            else {
              this.memoria= new ArrayList<>();
            }

            Variable nuevaVariable = new Variable(nombreVariable);
            memoria.add(nuevaVariable);
            return nuevaVariable;
        }

    //METODOS DE PROGRAMAS
        public void cargarPrograma(Programa programaACargar){ this.programa=programaACargar; }

        public void ejecutar(String nombreRutina){
            Variable variable;
            for (Rutina rutina_aux : programa.getRutinas()) {
                if ((rutina_aux.getNombre()).equals(nombreRutina)){
                    for (Instruccion instruccion_aux : rutina_aux.getInstrucciones()) {
                        switch (instruccion_aux.getOperacion()){
                            case "add":
                                add();
                            break;
                            case "mul":
                                mul();
                            break;
                            case "sub":
                                sub();
                            break;
                            case "push":
                                push(instruccion_aux.getValor());
                            break;
                            case "write":
                                variable = buscarVariablePorSuNombre(instruccion_aux.getNombreVariable());
                                write(variable);
                            break;
                            default:
                                variable = buscarVariablePorSuNombre(instruccion_aux.getNombreVariable());
                                read(variable);
                                break;
                        }
                    }
                }
            }
            pila.clear();
            memoria.clear();
        }

    public static void main(String[] args) {
        String PUSH="push";
        String WRITE="write";
        String READ="read";
        String ADD="add";
        String SUB="sub";
        String MUL="mul";

        Programa p = new Programa();

        p.agregarInstruccion("rutina1", new Instruccion(PUSH, 2));
        p.agregarInstruccion("rutina1", new Instruccion(ADD));
        p.agregarInstruccion("rutina1", new Instruccion(WRITE, "y"));
        p.agregarInstruccion("rutina1", new Instruccion(READ, "x"));
        p.agregarInstruccion("rutina2", new Instruccion(READ, "x"));
        p.agregarInstruccion("rutina2", new Instruccion(MUL));
        p.agregarInstruccion("rutina2", new Instruccion(WRITE, "x"));
        p.agregarInstruccion("rutina2", new Instruccion(PUSH, 2));
        p.agregarInstruccion("rutina3", new Instruccion(PUSH,20));
        p.agregarInstruccion("rutina3", new Instruccion(PUSH,40));
        p.agregarInstruccion("rutina3", new Instruccion(ADD));


        Calculadora calc = new Calculadora();
        calc.cargarPrograma(p);

        calc.ejecutar("rutina3");
    }
}