package busca;

import java.util.Comparator;

/**
 * Created by fauno on 11/25/15.
 */
public class ComparatorPosicoesCorretas implements Comparator<No> {

    private Integer calculaPosicoesCorretas(No no){
        return no.estado.qtdPosicoesCorretas();
    }

    @Override
    public int compare(No o1, No o2) {
        Integer posicoesCorretas1 = calculaPosicoesCorretas(o1);
        Integer posicoesCorretas2 = calculaPosicoesCorretas(o2);
        return posicoesCorretas2 - posicoesCorretas1;
    }

}
