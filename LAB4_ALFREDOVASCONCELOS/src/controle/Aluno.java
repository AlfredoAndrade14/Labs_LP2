package controle;

import java.util.Objects;

/**
 * Classe que representa um Aluno.
 *
 * @author Alfredo Vasconcelos
 */
public class Aluno {
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
     * Método construtor do aluno.
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
     * Gera a representação textual do aluno.
     * @return Retorna a representação textual do aluno.
     */
    @Override
    public String toString() {
        return  matricula + " - " + nome + " - " + curso;
    }
}
