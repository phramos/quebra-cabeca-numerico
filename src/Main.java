import busca.Busca;
import busca.No;
import models.Estado;

public class Main {

    public static void main(String[] args) {
        Integer[] numeros1 = {1,2,3,4,5,6,7,8,Estado.VAZIO};
        Integer[] estadoObjetivo = {1,2,3,4,5,6,7,8,Estado.VAZIO};
        Integer[] estadoInicial = {2,5,8,7,4,3,0,1,6};

//        Integer[] estadoInicialTest = { 8, 4, 0, 5, 1, 7, 6, 2, 3 };
//        Integer[] estadoObjetivoTest = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };

        No raiz = new No(new Estado(estadoInicial, estadoObjetivo), null, 0);

        Busca.heuriscaPosicoesCorretas(raiz);



    }
}
