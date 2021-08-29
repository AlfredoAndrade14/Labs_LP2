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
    private ArrayList<Aluno> participacao;

    /**
     * Método construtor do controle de alunos
     */
    public ControleAlunos() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.participacao = new ArrayList<>();
    }

    /**
     * Método que recebe uma matricula de um aluno, o nome do aluno e o curso dele,
     * cadastra ele e o adciona no Hashmap, retornando se a matricula já foi cadastrada
     * e se foi realizado o cadastro.
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
     * Busca o aluno através de uma matrícula que é recebida por parametro,
     * retornando a representação do aluno caso ele exista ou mostrando que
     * ele não foi cadastrado.
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
     * Cadastra um grupo, recebendo como parametro o nome e o tamanho do grupo.
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
     * Recebe uma matricula de um aluno e o nome de um grupo, se o aluno e o grupo já
     * estiverem cadastrados aloca o aluno no grupo.
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
     * Recebe uma matricula de um aluno e o nome de um grupo, e se o aluno e o grupo já
     * estiverem cadastrados verifica se o aluno faz parte do grupo.
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
     * Recebe uma matricula por parametro e adiciona o aluno da matricula na lista de alunos
     * que participaram de atividades durante a aula caso esse aluno esteja cadastrado.
     *
     * @param matricula Matrícula do aluno
     * @return Retorna se o aluno foi registrado ou se ele não foi cadastrado.
     */
    public String registraParticpacao(String matricula) {
        if (this.alunos.containsKey(matricula)) {
            this.participacao.add(this.alunos.get(matricula));
            this.alunos.get(matricula).cadastraParticipacao();
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
     * Recebe uma matricula por parametro e busca os grupos ao qual o aluno faz parte e retorna uma
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

    /**
     * Método que percorre os alunos cadastrados, verifica caso esse aluno não tenha participado
     * se assim for ele é adicionado a lista da representação textual para ser retornado junto
     * com outros que não participaram.
     *
     * @return lista de aluno(s) que não participaram durante a aula.
     */
    public String alunosNaoParticiparam() {
        String saida = "Alunos que não participaram:\n";
        for (Aluno aluno: alunos.values()) {
            if (aluno.getParticipacao() == 0) {
                saida += aluno + "\n";
            }
        }

        return saida;
    }

    /**
     * Método que percorre os alunos cadastrados e analisa o numero de participação se for maior
     * que o atual numero a lista para armazenar esses alunos é limpa, e esse aluno é adicionado,
     * caso o numero seja igual ao já armazenado ele é adicionado a lista.
     * pós isso é feito uma representação textual com esse(s) alunos e a retorna.
     *
     * @return lista de aluno(s) que mais participaram durante a aula.
     */
    public String alunosMaisChamados() {
        int maiorNumeroDeChamadas = 0;
        ArrayList<Aluno> maisChamados = new ArrayList<Aluno>();

        for (Aluno aluno: alunos.values()) {
            if (aluno.getParticipacao() > maiorNumeroDeChamadas) {
                maiorNumeroDeChamadas = aluno.getParticipacao();
                maisChamados.clear();
                maisChamados.add(aluno);
            }
            else if (aluno.getParticipacao() == maiorNumeroDeChamadas && maiorNumeroDeChamadas > 0) {
                maisChamados.add(aluno);
            }
        }

        String saida = "Aluno(s) mais chamado(s):\n";
        for (Aluno alunoMaisChamado: maisChamados) {
            saida += alunoMaisChamado + "- Vezes chamado: " + alunoMaisChamado.getParticipacao()+ "\n";
        }
        return saida;
    }

    /**
     * Método que percorre os alunos cadastrados, verifica de qual curso
     * ele faz parte e adiciona o numero de participações dele, se for maior que zero, ao valor do
     * curso, caso alguém desse curso já sido analizado e tenha participado, caso contrario é criado
     * uma chave com esse curso e o valor sera o numero de participação do aluno.
     * Que é armazenado em um hashmap e após isso é feito uma representação textual ordenada do curso
     * com mais participação ao com menos.
     *
     * @return representação textual da quantidade de participação de alunos por curso ordenado
     * do com mais participação ao com menos.
     */
    public String alunosPorCurso() {
        HashMap<String, Integer> cursos = new HashMap<String, Integer>();
        int maisVezesChamado = 0;

        for (Aluno aluno: alunos.values()) {
            if (aluno.getParticipacao() > 0) {
                String cursoAluno = aluno.getCurso();
                if (cursos.containsKey(cursoAluno)) {
                    cursos.put(cursoAluno, ((cursos.get(cursoAluno) + aluno.getParticipacao())));
                } else {
                    cursos.put(cursoAluno, aluno.getParticipacao());
                }
                maisVezesChamado = cursos.get(cursoAluno) > maisVezesChamado ? cursos.get(cursoAluno) : maisVezesChamado;
            }
        }

        String saida = "Numero de alunos chamados por curso:\n";

        for (int i = maisVezesChamado;i > 0; i--) {
            for (String curso: cursos.keySet()) {
                if (cursos.get(curso) == i){
                    saida += curso + " - Numero de vezes: " + i +"\n";
                }
            }
        }
        return saida;
    }
}
