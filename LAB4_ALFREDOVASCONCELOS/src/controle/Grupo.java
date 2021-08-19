package controle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Classe que representa um Grupo.
 *
 * @author Alfredo Vasconcelos
 */
public class Grupo {
    /**
     * Tamanho do grupo.
     */
    private int tamanho;

    /**
     * Nome do grupo.
     */
    private String nomeDoGrupo;

    /**
     * Hashmap dos alunos do grupo.
     */
    private HashMap<String, Aluno> alunosDoGrupo;

    /**
     * Método construtor do grupo com limite.
     *
     * @param nome nome do grupo.
     * @param tamanhoDoGrupo tamanho do grupo.
     */
    public Grupo(String nome, int tamanhoDoGrupo) {
        if(nome.isEmpty() || tamanhoDoGrupo <= 0) {
            throw new IllegalArgumentException("Entrada Inválida");
        }

        this.nomeDoGrupo = nome;
        this.tamanho = tamanhoDoGrupo;
        this.alunosDoGrupo = new HashMap(tamanhoDoGrupo);
    }

    /**
     * Método construtor do grupo sem limite.
     *
     * @param nome nome do grupo.
     */
    public Grupo(String nome) {
        if(nome.isEmpty()) {
            throw new IllegalArgumentException("Entrada Inválida");
        }

        this.nomeDoGrupo = nome;
        this.tamanho = -1;
        this.alunosDoGrupo = new HashMap();
    }

    /**
     * Método que aloca um aluno no grupo caso tenha limite disponovel.
     *
     * @param aluno Aluno.
     * @return Retorna se o aluno foi alocado ou se o grupo está cheio.
     */
    public String alocaAluno(String matricula, Aluno aluno) {
        if (matricula.isEmpty()) {
            throw new IllegalArgumentException("Entrada Inválida");
        }

        if (this.tamanho == -1 || this.alunosDoGrupo.size() < tamanho) {
            this.alunosDoGrupo.put(matricula, aluno);
            return "ALUNO ALOCADO!";
        }
        return "GRUPO CHEIO";
    }

    /**
     * Verifica se o aluno faz parte do grupo.
     *
     * @param matricula Matrícula do aluno.
     * @return Retrona true caso o aluno faça parte e false caso contrario.
     */
    public Boolean alunoPertence(String matricula) {
        if (matricula.isEmpty()) {
            throw new IllegalArgumentException("Entrada Inválida");
        }

        return alunosDoGrupo.containsKey(matricula);
    }

    /**
     * Método para acessar o nome do grupo.
     *
     * @return Retorna o nome do grupo.
     */
    public String getNomeDoGrupo () {
        return this.nomeDoGrupo;
    }
}
