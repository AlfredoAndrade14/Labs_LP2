package controle;

/**
 * Classe que representa um Aluno.
 *
 * @author Alfredo Vasconcelos
 */
public class Aluno{
    /**
     * Matrícula do aluno.
     */
    private String matricula;

    /**
     * Nome do aluno.
     */
    private String nome;

    /**
     * Curso do aluno.
     */
    private String curso;

    /**
     * Numero de vezes que o aluno participou
     */
    private int participacao;

    /**
     * Método construtor do aluno, recebe como parametro o nome do aluno, a matricula de e o curso.
     * @param matricula Matrícula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {
        if(matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
            throw new IllegalArgumentException("Entrada Inválida");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Método que adiciona um ao numero de participação do aluno
     */
    public void cadastraParticipacao() {
        this.participacao ++;
    }

    /**
     * Método que retorna o numero de participação do aluno;
     *
     * @return numero de vezes que o aluno participou;
     */
    public Integer getParticipacao() {
        return this.participacao;
    }

    /**
     * Método que retorna o curso que o aluno faz parte;
     * @return curso do aluno
     */
    public String getCurso() {
        return this.curso;
    }

    /**
     * Gera a representação textual do aluno.
     * @return Retorna a representação textual do aluno.
     */
    @Override
    public String toString() {
        return  matricula + " - " + nome + " - " + curso;
    }
}
