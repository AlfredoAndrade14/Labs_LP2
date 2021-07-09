package lab2;

import java.util.ArrayList;

/**
 * Representação de um controle de finanças que ajuda
 * ao aluno controlar seus gastos durante o curso, pegando
 * o valor que o aluno tem disponivel, seus gastos e seus ganhos
 * @author ALfredo Vasconcelos de Andrade
 */
public class RegistroFinancas {
    /**
     * É um array que aramazena ordenadamente
     * os ganhos do aluno
     */
    private int[] ganhosLista;

    /**
     * Arraylist que armazena a descrição e o valor
     * dos gastos.
     */
    ArrayList<Gasto> despesas = new ArrayList();

    /**
     * O saldo inicial do aluno.
     */
    private int ganhoInicial;

    /**
     * Recebe o saldo inicial do aluno em centavos
     * e o tamanho do array que armazena os ganhos.
     * @param ganhosIniciais o saldo inicial do aluno.
     * @param totalDeGanhos a quantidade de ganhos.
     */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
        this.ganhoInicial = ganhosIniciais;
        this.ganhosLista = new int[totalDeGanhos];
    }

    /**
     * Recebe o valor recebido pelo aluno em centavos e armazena.
     * @param valorCentavos valor ganho em centavos.
     * @param posicaoGanho posição desejada para armazenar o ganho.
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
        this.ganhosLista[posicaoGanho - 1] = valorCentavos;
    }

    /**
     * Recebe como parametro o valor dos gastos do aluno
     * em centavos.
     * @param valorCentavos valor das despesas do aluno em centavos.
     */
    public void pagaDespesa(int valorCentavos) {
        Gasto valorPago = new Gasto(valorCentavos);
        this.despesas.add(valorPago);
    }

    /**
     * Recebe como parametro o valor dos gastos do aluno
     * em centavos junto de uma descrição do gasto, subtrai
     * do saldo do mesmo, soma ao montante de gastos e
     * guarda a descrição.
     * @param valorCentavos valor das despesas do aluno em centavos.
     * @param detalhes descrição do gasto.
     */
    void pagaDespesa(int valorCentavos, String detalhes) {
        Gasto valorPago = new Gasto(valorCentavos,detalhes);
        this.despesas.add(valorPago);
    }

    /**
     * Exibe os ganhos do aluno em uma tabela
     * @return uma tabela mostrando os ganhos
     * em suas possições previamente selecionadas.
     */
    public String exibeGanhos() {
        String tabela = "";
        for (int i = 0; i < ganhosLista.length - 1; i++) {
            tabela += ((i+1) + " - " + ganhosLista[i] +'\n');
        }
        tabela += ((ganhosLista.length) + " - " + ganhosLista[ganhosLista.length-1]);
        return tabela;
    }

    /**
     * Retorna a soma total dos valores das despesas
     * do aluno em centavos.
     * @return o valor total das despesas do aluno.
     */
    private int somaGastos() {
        int gastos = 0;
        for (int s = 0; s < despesas.toArray().length; s++) {
            gastos += this.despesas.get(s).getGasto();
        }
        return gastos;
    }

    /**
     * Lista as 5 ultimas descrições dos
     * ultimos 5 gastos ou se a quantidade
     * de gastos for menor que 5 listas todas
     * as descrições.
     * @return a descrição dos ultimos 5 gastos.
     */
    public String listarDetalhes() {
        String listagemDetalhes = "";
        int inicio = (despesas.size() > 5) ? (despesas.size() - 5) : 0;
        for (int i = inicio; i < despesas.size() - 1; i++) {
            listagemDetalhes += despesas.get(i).getDetalhe() + "\n";
        }
        listagemDetalhes += despesas.get(despesas.size()-1).getDetalhe();
        return listagemDetalhes;
    }

    /**
     * Função que retorna o valor total de ganhos
     * do aluno.
     * @return o valor total de ganhos.
     */
    private int somaGanhos(){
        int ganhos = this.ganhoInicial;
        for (int s : ganhosLista) {
            ganhos += s;
        }
        return ganhos;
    }

    /**
     * Exibe um relatorio dos gasto, ganhos, saldo final
     * e inicial do aluno.
     * @return relatorio das finanças do aluno.
     */
    public String toString() {
        return ("Total recebidos: " + somaGanhos() + ", Despesas totais: " + somaGastos() + ", Total disponível: " + (somaGanhos() - somaGastos()));
    }
}
