package lab2;
/**
 * Representação de um de resgistro de tempo online do aluno
 * para uma determinada disciplina remota.
 * Em que o aluno define o nome da disciplina e o tempo online
 * esperado,sendo possivel adicionar o seu  tempo online e
 * checar se já atingiu o tempo esperado. o usando como tempo
 * esperado padrão 120 horas
 * @author ALfredo Vasconcelos de Andrade
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina a ser analisada.
     */
    private String nomeDisciplina;

    /**
     * Quantidade de horas online
     * utilizada pelo aluno para
     * a disciplina.
     */
    private int horasOnline;

    /**
     * Quantidade de tempo esperado
     * online.
     */
    private int metaDeHoras;

    /**
     * metódo construtor da classe para criar um objeto
     * passando o nome da disciplina e quantidade de horas
     * esperadas.
     * @param nome o nome da disciplina.
     * @param meta o tempo esperado.
     */
    public RegistroTempoOnline(String nome, int meta) {
        this.nomeDisciplina = nome;
        this.metaDeHoras = meta;
    }

    /**
     * metódo construtor da classe para criar um objeto
     * passando o nome da disciplina e quantidade de horas
     * esperadas padrão(120 horas).
     * @param nome o nome da disciplina.
     */
    public RegistroTempoOnline(String nome) {
        this.nomeDisciplina = nome;
        this.metaDeHoras = 120;
    }

    /**
     * adiciona o tempo online passado pelo aluno
     * todos os alunos começan com horas igual a 0.
     * @param tempo a quantidade de horas utilizadas.
     */
    public void adicionaTempoOnline(int tempo) {
        this.horasOnline += tempo;
    }

    /**
     * Compara se a quantidade de horas já utilizadas
     * é maior ou igual ao esperado caso verdade retorna
     * true caso contrario false.
     * @return indicação se o aluno atingiu o tempo esperado.
     */
    public boolean atingiuMetaTempoOnline() {
        return  (horasOnline >= metaDeHoras);
    }

    /**
     * Retorna uma String que representa o aluno no formato
     * nome da disciplina tempo online já usado / tempo online esperado.
     * @return a representação das atividades online de um aluno.
     */
    public String toString() {
        return nomeDisciplina + " " + horasOnline + "/" + metaDeHoras;
    }
}
