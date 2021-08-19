package controle;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um controle de alunos que tem um Hashset
 * de alunos e de grupos e uma lista com alunos que responderam questões
 */
public class ControleAlunos {
    /**
     * Hashmap de alunos
     */
    private HashMap<String, Aluno> alunos;

    /**
     * Hashmap de grupos
     */
    private HashMap<String, Grupo> grupos;

    /**
     * Lsita de alunos que respoderam questões no quadro
     */
    private ArrayList participacao;

    /**
     * Método construtor do controle de alunos
     */
    public ControleAlunos() {
        this.alunos = new HashMap();
        this.grupos = new HashMap();
        this.participacao = new ArrayList();
    }

    /**
     * Método que cadastra um aluno e o adciona no Hashset.
     *
     * @param matricula Matrícula do aluno
     * @param nome Nome do aluno
     * @param curso Curso que o aluno faz
     * @return Retorna se o cadastro foi realizado ou se a matricula já foi cadastrada.
     */
    public String cadastraAluno(String matricula, String nome, String curso) {
        if (!this.alunos.containsKey(matricula)) {
            this.alunos.put(matricula, new Aluno(matricula, nome,curso));

            return "CADASTRO REALIZADO!";
        }

        return "MATRÍCULA JÁ CADASTRADA!";
    }

    /**
     * Busca o aluno através de uma matrícula.
     *
     * @param matricula matrícula que sera buscada.
     * @return o aluno caso ele seja cadastrado.
     */
    public String getAluno(String matricula) {
        if (this.alunos.containsKey(matricula)) {
            return "Aluno: " + this.alunos.get(matricula);
        }

        return "Aluno não cadastrado.";
    }

    /**
     * Cadastra um grupo.
     *
     * @param nomeGrupo Nome do Grupo
     * @param tamanho Tamanho do grupo (Vazio caso seja sem limite)
     * @return Retorna se o grupo foi criado ou se ele já foi cadastrado antes.
     */
    public String cadastraGrupo(String nomeGrupo, String tamanho) {
        Grupo novoGrupo;
        if (tamanho.isEmpty()) {
            novoGrupo = new Grupo(nomeGrupo);
        } else {
            novoGrupo = new Grupo(nomeGrupo, Integer.parseInt(tamanho));
        }

        if (this.grupos.containsKey(nomeGrupo.toUpperCase())) {
            return "GRUPO JÁ CADASTRADO!";
        }

        this.grupos.put(nomeGrupo.toUpperCase(), novoGrupo);
        return "CADASTRO REALIZADO!";
    }

    /**
     * Aloca um aluno a um grupo caso ambos existam.
     *
      * @param matricula Matrícua do aluno.
     * @param nomeGrupo Nome do grupo
     * @return Retorna o retorno do método alocaAluno do grupo,
     * ou se o aluno ou o grupo não foram cadastrados
     */
    public String alocaAluno(String matricula, String nomeGrupo) {
        if (this.grupos.containsKey(nomeGrupo.toUpperCase())) {
            if (this.alunos.containsKey(matricula)) {
                return this.grupos.get(nomeGrupo.toUpperCase()).alocaAluno(matricula, this.alunos.get(matricula));
            }
            return "Aluno não cadastrado.";
        }
        return "Grupo não cadastrado.";
    }

    /**
     *
     * @param nomeGrupo Nome do Grupo
     * @param matricula Matrícula do aluno
     * @return Retorna o retorno se o aluno pertence ou não ao grupo ou
     * se o grupo não está cadastrado ou se o aluno não está cadastrado.
     */
    public String pertence(String nomeGrupo, String matricula) {
        if (this.alunos.containsKey(matricula)) {
            if (this.grupos.containsKey(nomeGrupo.toUpperCase())) {
                if (this.grupos.get(nomeGrupo.toUpperCase()).alunoPertence(matricula)) {
                    return "ALUNO PERTENCE AO GRUPO";
                } else {
                    return "ALUNO NÃO PERTENCE AO GRUPO";
                }
            }
            return "GRUPO NÃO CADASTRADO.";
        }
        return "Aluno não cadastrado.";
    }

    /**
     * Adiciona um aluno a lista de alunos que participaram.
     * @param matricula Matrícula do aluno
     * @return Retorna se o aluno foi registrado ou se ele não foi cadastrado.
     */
    public String registraParticpacao(String matricula) {
        if (this.alunos.containsKey(matricula)) {
            this.participacao.add(this.alunos.get(matricula));
            return "ALUNO REGISTRADO!";
        }
        return "Aluno não cadastrado.";
    }

    /**
     * Retorna a representação da lista de alunos que participaram.
     *
     * @return Lista de alunos que paticiparam
     */
    public String alunosParticipantes() {
        String lista = "";
        for (int i = 0;i < this.participacao.size(); i++) {
            lista += i+1 + ". " + this.participacao.get(i) + "\n";
        }
        return lista;
    }

    /**
     * Busca os grupos ao qual o aluno faz parte e retorna uma
     * lista com o nome deles.
     *
     * @param matricula Matrícula do aluno.
     * @return Retorna a lista de Grupos que o aluno faz parte
     */
    public String getGrupos(String matricula) {
        if (alunos.containsKey(matricula)) {
            String lista = "Grupos:\n";
            for (Grupo grupo : this.grupos.values()) {
                if (grupo.alunoPertence(matricula)) {
                    lista += "- " + grupo.getNomeDoGrupo() + "\n";
                }
            }
            return lista;
        }
        return "Aluno não cadastrado.";
    }
}
