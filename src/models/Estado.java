package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by fauno on 11/22/15.
 */


public class Estado {
    public static final Integer VAZIO = 0;
    public Integer dimensao;
    public ArrayList<Integer> numeros;
    public Estado estadoObjetivo;

    public Estado(Integer[] estado) {
        //this.numeros = new ArrayList<>();
       this.dimensao = 3;
       this.numeros = new ArrayList<Integer>(Arrays.asList(estado));
    }

    public Estado(Integer[] estado, Integer[] estadoObjetivo) {
        this.dimensao = 3;
        this.numeros = new ArrayList<Integer>(Arrays.asList(estado));
        this.estadoObjetivo = new Estado(estadoObjetivo);
    }

    public Estado(ArrayList<Integer> numeros) {
        this.numeros = numeros;
        this.dimensao = 3;
    }

    public Estado(ArrayList<Integer> numeros, Estado estadoObjetivo) {
        this.numeros = numeros;
        this.estadoObjetivo = estadoObjetivo;
        this.dimensao = 3;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < this.numeros.size(); i++) {
            if (numeros.get(i) == VAZIO){
                resultado += " - ";
            }else {
                resultado += " " + numeros.get(i) + " ";
            }
            if (((i+1) % dimensao) == 0)
                resultado += "\n";
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return !(numeros != null ? !numeros.equals(estado.numeros) : estado.numeros != null);

    }

    @Override
    public int hashCode() {
        return numeros != null ? numeros.hashCode() : 0;
    }

    //Move o espaco vazio para baixo
    public Estado moverParaBaixo(){
        Estado novoEstado = null;
        if (this.numeros.indexOf(VAZIO)+dimensao < this.numeros.size()){
            ArrayList<Integer> novosNumeros = (ArrayList<Integer>) this.numeros.clone();
            Collections.swap(novosNumeros,
                    novosNumeros.indexOf(VAZIO),
                    novosNumeros.indexOf(novosNumeros.get(this.numeros.indexOf(VAZIO)+dimensao)));
            novoEstado = new Estado(novosNumeros, this.estadoObjetivo);
        }
        return novoEstado;
    }

    //Move o espaco vazio para cima
    public Estado moverParaCima(){
        Estado novoEstado = null;
        if (this.numeros.indexOf(VAZIO)-dimensao > 0){
            ArrayList<Integer> novosNumeros = (ArrayList<Integer>) this.numeros.clone();
            Collections.swap(novosNumeros,
                    novosNumeros.indexOf(VAZIO),
                    novosNumeros.indexOf(novosNumeros.get(this.numeros.indexOf(VAZIO)-dimensao)));
            novoEstado = new Estado(novosNumeros, this.estadoObjetivo);
        }
        return novoEstado;
    }

    //Move o espaco vazio para direita
    public Estado moverParaDireita(){
        Estado novoEstado = null;
        if (((this.numeros.indexOf(VAZIO)+1) % dimensao) != 0){
            ArrayList<Integer> novosNumeros = (ArrayList<Integer>) this.numeros.clone();
            Collections.swap(novosNumeros,
                    novosNumeros.indexOf(VAZIO),
                    novosNumeros.indexOf(novosNumeros.get(this.numeros.indexOf(VAZIO)+1)));
            novoEstado = new Estado(novosNumeros, this.estadoObjetivo);
        }
        return novoEstado;
    }

    //Move o espaco vazio para direita
    public Estado moverParaEsquerda(){
        Estado novoEstado = null;
        if (((this.numeros.indexOf(VAZIO)) % dimensao) != 0){
            ArrayList<Integer> novosNumeros = (ArrayList<Integer>) this.numeros.clone();
            Collections.swap(novosNumeros,
                    novosNumeros.indexOf(VAZIO),
                    novosNumeros.indexOf(novosNumeros.get(this.numeros.indexOf(VAZIO)-1)));
            novoEstado = new Estado(novosNumeros, this.estadoObjetivo);
        }
        return novoEstado;
    }

    //retorna a quantidade de posicoes corretas baseado no estado objetivo
    public Integer qtdPosicoesCorretas(){
        Integer total = 0;
        for (int i = 0; i < this.numeros.size(); i++) {
            if (this.estadoObjetivo.numeros.get(i) == this.numeros.get(i)){
                total ++;
            }
        }
        return total;
    }
}
