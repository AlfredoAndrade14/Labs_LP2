package biblitex;

/**
 * Classe de transformação que transforma o texto de modo que
 * os caracteres nas posições pares ficam em maiúsculo e nas
 * posições impares, em minúsculas.
 */
public class CamelCasefy implements Transformacao {
    /**
     * Nome da transformação
     */
    private String nome;

    /**
     * Método Construtor da classe, que define o nome da transformação.
     */
    public CamelCasefy() {
        this.nome = "CaMeLcAsEfY";
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
     * Método que recebe o texto e transforma ele de modo que
     * os caracteres nas posições pares ficam em maiúsculo e nas
     * posições impares, em minúsculas, e retorna a string formatada.
     *
     * @param texto texto a ser formatado
     * @return Texto formatado pela transformação
     */
    @Override
    public String transforma(String texto) {
        String saida = "";
        char[] letrasTexto = texto.toCharArray();

        for (int i = 0; i < letrasTexto.length; i++ ) {
            if (i % 2 == 0) {
                saida += Character.toUpperCase(letrasTexto[i]);
            } else {
                saida += Character.toLowerCase(letrasTexto[i]);
            }
        }

        return saida;
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
