package lab2;

/**
 * Classe que representa o gasto de um aluno.
 * @author ALfredo Vasconcelos de Andrade
 */
public class Gasto {
    /**
     * Valor da despesa.
     */
    private int despesa;

    /**
     * Descrição da despesa.
     */
    private String descricao;

    /**
     * Metodo construtor que recebe o
     * valor da despesa.
     * @param valor o valor da despesa do aluno.
     */
    public Gasto(int valor){
        this.despesa = valor;
    }

    /**
     * Metodo construtor que recebe o
     * valor da despesa e a descrição dela.
     * @param valor o valor da despesa do aluno.
     * @param decricao a descrição da despesa.
     */
    public Gasto(int valor, String decricao){
        this.despesa = valor;
        this.descricao = decricao;
    }

    /**
     * Metodo que retorna a descrição
     * da despesa.
     * @return a descrição da despesa.
     */
    public String getDetalhe() {
        return this.descricao;
    }

    /**
     * Metodo que retorna o valor
     * da despesa.
     * @return o valor da despesa.
     */
    public int getGasto() {
        return this.despesa;
    }
}
