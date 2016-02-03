package models;

import java.util.ArrayList;

/**
 * Created by fauno on 11/22/15.
 */
public class QuebraCabeca {
    public Estado estadoInicial;

    public Estado estadoObjetivo;
    ArrayList<Estado> estadosGerados;

//    public QuebraCabeca(){
//
//    }

    public QuebraCabeca(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
        Integer[] numeros = {1,2,3,8,Estado.VAZIO,4,7,5,6};
        this.estadoObjetivo = new Estado(numeros);

        estadosGerados = new ArrayList<>();
        estadosGerados.add(estadoInicial);
    }
}
