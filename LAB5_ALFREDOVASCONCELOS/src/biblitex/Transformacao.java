package biblitex;

/**
 * Interface de transformações textuais.
 */
public interface Transformacao extends Comparable<Transformacao> {
    /**
     * Método para retornar o nome da transformação.
     *
      * @return nome da transformação
     */
    public String getNome();

    /**
     * Método que realiza a transformação de um texto.
     *
     * @param texto texto a ser transformado.
     * @return O texto formatado.
     */
    public String transforma(String texto);

    /**
     * Método que compara com outra transformação para a ordenação alfabética.
     * @param o Transformação a ser comparada.
     * @return um inteiro com base na comparação entre as duas transformações.
     */
    public int compareTo(Transformacao o);
}
