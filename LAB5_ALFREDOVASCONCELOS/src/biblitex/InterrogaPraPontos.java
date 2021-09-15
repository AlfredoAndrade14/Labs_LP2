package biblitex;

/**
 * Classe de tarnsformação que substitui o caractere de interrogação "?"
 * pelo caractere de ponto ".".
 */
public class InterrogaPraPontos implements Transformacao{
    /**
     * Nome da transformação
     */
    private String nome;

    /**
     * Método Construtor da classe, que define o nome da transformação.
     */
    public InterrogaPraPontos() {
        this.nome = "InterrogaPraPontos";
    }

    /**
     * Método que retorna o nome da transformação.
     * @return nome da transformação.
     */
    @Override
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que recebe o texto a ser transformado
     * substitui todos os caracteres de interrogação pelo
     * caractere de ponto (.) e retorna a string formatada.
     *
     * @param texto texto a ser formatado
     * @return Texto formatado pela transformação
     */
    @Override
    public String transforma(String texto) {
        return texto.replaceAll("\\?", ".");
    }

    /**
     * Compara essa transformação a partir do seu nome com o nome de outra transfromação
     * passada por parametro. retorna um inteiro negativo, zero, ou um inteiro positivo
     * caso o nome do objeto seja por ordem alfabetia primeiro, igual ou depois.
     *
     * @param outraTransformacao Outra transformação passada por parametro.
     * @return um inteiro com base na comparação entre as duas transformações.
     */
    @Override
    public int compareTo(Transformacao outraTransformacao) {
        return (this.nome.toLowerCase()).compareTo(outraTransformacao.getNome().toLowerCase());
    }
}
