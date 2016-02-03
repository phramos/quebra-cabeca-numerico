package busca;

import jdk.management.resource.internal.inst.FileChannelImplRMHooks;
import models.Estado;
import models.Movimento;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by fauno on 11/23/15.
 */


public class No {
    public Estado estado;
    public Movimento movimento; //Movimento realizado no pai para se chegar a esse estado
    public No pai;
    public Integer profundidade;
    public HashSet<No> filhos;

    public No(Estado estado, No pai, Integer profundidade) {
        this.estado = estado;
        this.pai = pai;
        this.profundidade = profundidade;
    }

    public No(Estado estado, No pai, Movimento movimento, Integer profundidade) {
        this.estado = estado;
        this.pai = pai;
        this.movimento = movimento;
        this.profundidade = profundidade;
    }

    public void gerarFilhos(){
        this.filhos = new HashSet<No>();

        //Tenta gerar os filhos movendo o espaco vazio para baixo, cima, direita e esquerda
        if (this.estado.moverParaBaixo() != null)
            this.filhos.add(new No(this.estado.moverParaBaixo(), this, Movimento.BAIXO, this.profundidade++));

        if (this.estado.moverParaCima() != null)
            this.filhos.add(new No(this.estado.moverParaCima(), this, Movimento.CIMA, this.profundidade++));

        if (this.estado.moverParaDireita() != null)
            this.filhos.add(new No(this.estado.moverParaDireita(), this, Movimento.DIREITA, this.profundidade++));

        if (this.estado.moverParaEsquerda() != null)
            this.filhos.add(new No(this.estado.moverParaEsquerda(), this, Movimento.ESQUERDA, this.profundidade++));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        No no = (No) o;

        return !(estado != null ? !estado.equals(no.estado) : no.estado != null);

    }

    @Override
    public int hashCode() {
        return estado != null ? estado.hashCode() : 0;
    }

    @Override
    public String toString() {
        String resultado="\n\n";
        if (this.pai==null){
            resultado+= "-----------Estado Inicial----------\n";
        } else {
            resultado += "Movimento: ";
            resultado += this.movimento + "\n";
        }
        resultado += this.estado.toString();
        return resultado;
    }
}
