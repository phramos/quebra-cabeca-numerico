package busca;

import models.Estado;

import java.util.*;

/**
 * Created by fauno on 11/23/15.
 */
public class Busca {

    public static void heuriscaPosicoesCorretas(No raiz){
        HashSet<No> nosDescobertos = new HashSet<No>();
        nosDescobertos.add(raiz);
        No no;
        No solucao = null;


        PriorityQueue<No> fila = new PriorityQueue(20, new ComparatorPosicoesCorretas()); //Estrutura de fila de prioridades para realizar a busca em larguras
        fila.add(raiz); //Adiciona a raiz à fila de busca em largura

        while (!fila.isEmpty() &&  solucao == null){
            no = fila.remove();
            //System.out.println(no);


            //Verifica se o no possui o estado objetivo
            if (no.estado.qtdPosicoesCorretas() == 9){
                solucao = no;
            } else {
                no.gerarFilhos();//descobre os filhos do no a ser analisado
                for (No filho : no.filhos){
                    //Checa se o no filho recem descoberto ja foi analisado previamente
                    if (!nosDescobertos.contains(filho)){
                        nosDescobertos.add(filho);
                        fila.add(filho);
                    }


                }
            }

        }

        //Verifica se a solucao foi encontrada
        if (solucao != null){
            No aux = solucao;
            ArrayList<No> sequencia = new ArrayList<No>();
            while (aux!=null){
                sequencia.add(aux);
                aux = aux.pai;
            }

            Collections.reverse(sequencia);

            //Imprime a solucao
            for (No noSequencia : sequencia){
                System.out.println(noSequencia);

            }
            System.out.println("Niveis aprofundados na arvore: "+ solucao.profundidade);
            System.out.println("Jogadas Realizadas: "+ (sequencia.size()-1));
        } else{
            System.out.println("Solução não encontrada");
        }

    }
}
