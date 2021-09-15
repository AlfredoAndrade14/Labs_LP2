package biblitex;

/**
 * Classe de transformação que transforma o texto de entrada para caixa alta.
 */
public class UpperCase implements Transformacao{
    /**
     * Nome da transformação
     */
    private String nome;

    /**
     * Método Construtor da classe, que define o nome da transformação.
     */
    public UpperCase() {
        this.nome = "upperCase";
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
     * coloca todas as letras em caixa alta e retorna a
     * string formatada.
     *
     * @param texto texto a ser formatado
     * @return Texto formatado pela transformação
     */
    @Override
    public String transforma(String texto) {
        return texto.toUpperCase();
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
