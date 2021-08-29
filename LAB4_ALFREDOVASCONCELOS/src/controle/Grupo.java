package controle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Classe que representa um Grupo, que pode ter ou não um limite.
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
     * Método construtor de grupo com limite, recebe como parametro o nome do grupo
     * e o limite dele.
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
     * Método construtor de grupo sem limite, recebe como parametro o nome do grupo.
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
     * Método que recebe como parametro a matricula de um aluno e
     * o objeto que representa o aluno da matricula e aloca esse
     * aluno no grupo caso tenha limite disponivel,caso
     * o grupo esteja cheio retorna que ele esta cheio.
     *
     * @param aluno Aluno.
     * @param matricula matricula do aluno a ser alocado
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
     * Recebe como parametro a matricula de um aluno verifica se ele faz parte do grupo,
     * caso faça parte retorna true, caso contrario retorna false.
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
