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


    ArrayList<String> descricao = new ArrayList();

    /**
     * Soma total dos valores das despesas
     * do aluno em centavos.
     */
    private int gastos;

    /**
     * Soma total do ganhos do aluno em centavos
     * sem o saldo inicial.
     */
    private int ganhos;

    /**
     * É o valor líquido disponível do aluno
     * em centavos.
     */
    private int saldo;

    /**
     * Recebe o saldo inicial do aluno em centavos
     * e o tamanho do array que armazena os ganhos.
     * @param ganhosIniciais o saldo inicial do aluno.
     * @param totalDeGanhos a quantidade de ganhos.
     */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
        this.saldo = ganhosIniciais;
        this.ganhos = ganhosIniciais;
        this.ganhosLista = new int[totalDeGanhos];
    }

    /**
     * Recebe o valor recebido pelo aluno em centavos.
     * @param valorCentavos valor ganho em centavos.
     * @param posicaoGanho posição desejada para armazenar o ganho.
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
        this.ganhos -= this.ganhosLista[posicaoGanho - 1];
        this.ganhos += valorCentavos;
        this.saldo -= this.ganhosLista[posicaoGanho - 1];
        this.saldo += valorCentavos;
        this.ganhosLista[posicaoGanho - 1] = valorCentavos;
    }

    /**
     * Recebe como parametro o valor dos gastos do aluno
     * em centavos, subtrai do saldo do mesmo e soma ao
     * montante de gastos.
     * @param valorCentavos valor das despesas do aluno em centavos.
     */
    public void pagaDespesa(int valorCentavos) {
        this.saldo -= valorCentavos;
        this.gastos += valorCentavos;
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
        this.saldo -= valorCentavos;
        this.gastos += valorCentavos;
        this.descricao.add(detalhes);
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
     * Lista as 5 ultimas descrições dos
     * ultimos 5 gastos ou se a quantidade
     * de gastos for menor que 5 listas todas
     * as descrições.
     * @return
     */
    String listarDetalhes() {
        String listagemDetalhes = "";
        int inicio = (descricao.size() > 5) ? (descricao.size() - 5) : 0;
        for (int i = inicio; i < descricao.size() - 1; i++) {
            listagemDetalhes += descricao.get(i) + "\n";
        }
        listagemDetalhes += descricao.get(descricao.size()-1);
        return listagemDetalhes;
    }

    /**
     * Exibe um relatorio dos gasto, ganhos, saldo final
     * e inicial do aluno.
     * @return relatorio das finanças do aluno.
     */
    public String toString() {
        return ("Total recebidos: " + ganhos + ", Despesas totais: " + gastos + ", Total disponível: " + saldo);
    }
}
