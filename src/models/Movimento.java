package models;

/**
 * Created by fauno on 11/25/15.
 */
public enum Movimento {
    CIMA("Cima"), BAIXO("Baixo"), ESQUERDA("Esquerda"), DIREITA("Direita");


    private final String text;

    /**
     * @param text
     */
    private Movimento(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
