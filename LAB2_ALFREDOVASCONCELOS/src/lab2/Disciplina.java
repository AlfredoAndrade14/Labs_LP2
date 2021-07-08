package lab2;

import java.util.Arrays;

/**
 * Representação de um controle de notas e de horas
 * de estudo de uma disciplina, que recebe as notas
 * do aluno e horas de estudo, mostra se o aluno
 * foi aprovado ou não e um relatrio dos dados da
 * disciplina.
 * @author ALfredo Vasconcelos de Andrade
 */
public class Disciplina {
    /**
     * Nome da disciplina em analise.
     */
    private String nomeDaDisciplina;

    /**
     * Array para armazenar as notas,
     * sem limite maximo definido.
     */
    private double notas[];

    /**
     * Array para armazenar os pesos
     * das notas,sem limite maximo
     * definido.
     */
    private int pesos[];

    /**
     * Valor da soma de todos os pesos
     * das notas da disciplina
     */
    private int somaDosPesos;

    /**
     * Valor da soma de todas as notas
     * da disciplina
     */
    private double somaDasNotas;

    /**
     * Media aritimética da quatro notas.
     */
    private double mediaDasNotas;

    /**
     * Numero de horas de estudo.
     */
    private int tempoEstudo;

    /**
     * Constroi uma disciplina recebendo como parametro o nome
     * para acompanhamento de dados.
     * @param nomeDisciplina nome da disciplina que sera cadastrada.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.notas = new double[4];
        this.pesos = new int[] {1,1,1,1};
    }

    /**
     * Constroi uma disciplina recebendo como parametro o nome e
     * a quantidade de notas da disciplina para acompanhamento de dados.
     * @param nomeDisciplina nome da disciplina que sera cadastrada.
     * @param numeroDeNotas quantidade de motas a serem cadastradas.
     */
    public Disciplina(String nomeDisciplina,int numeroDeNotas) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.notas = new double[numeroDeNotas];
        this.pesos = new int[numeroDeNotas];

        Arrays.fill(pesos, 1);
    }

    /**
     * Constroi uma disciplina recebendo como parametro o nome,
     * a quantidade de notas da disciplina e uma lsiat com os
     * pesos das notas da disciplina para acompanhamento de dados.
     * @param nomeDisciplina nome da disciplina que sera cadastrada.
     * @param numeroDeNotas quantidade de motas a serem cadastradas.
     * @param valoresPesos array com os valores dos pesos das notas
     */
    public Disciplina(String nomeDisciplina,int numeroDeNotas, int[] valoresPesos) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.notas = new double[numeroDeNotas];
        this.pesos = valoresPesos;
    }

    /**
     * Recebe horas de estudo do aluno e soma
     * ao total de horas de estudo dele na disciplina.
     * @param horas horas a quantidade de horas de estudo.
     */
    public void cadastraHoras(int horas) {
        this.tempoEstudo += horas;
    }

    /**
     * Cadastra as notas da disciplina de cada prova
     * de acordo com o parametro que for passado.
     * @param nota numero correspondente a nota.
     * @param valorNota nota obtida.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota-1] = valorNota;
    }

    /**
     * Calcula a media ponderada ou a media
     * acetimetrica quando uma lista de pessos é
     * passada na criação do objeto das quatro ou mais
     * notas.
     */
    private void calculaMedia() {
        for (int i = 0; i < notas.length; i++) {
            this.somaDasNotas += (this.notas[i] * this.pesos[i]);
            this.somaDosPesos += this.pesos[i];
        }

        this.mediaDasNotas = somaDasNotas / somaDosPesos;
        this.somaDasNotas = this.somaDosPesos = 0;
    }

     /**
     * Verifica se a media do aluno é maior que 7 e false caso contrario.
     * @return é true se a media for maior que 7 caso contrario é false
     */
    public boolean aprovado() {
        calculaMedia();
        return (this.mediaDasNotas >= 7.0);
    }

    /**
     * Gera uma representação da disciplina contendo o nome
     * da disciplina, o número de horas de estudo, a média
     * do aluno e as notas de cada prova.
     * @return a representação da disciplina.
     */
    public String toString() {
        calculaMedia();
        return (this.nomeDaDisciplina + " " + this.tempoEstudo + " " + this.mediaDasNotas + " " + Arrays.toString(notas));
    }
}
