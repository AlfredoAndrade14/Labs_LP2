package agenda;

/**
 * Classe que representa um contato
 *
 * @author Alfredo Vasconcelos
 *
 */
public class Contato {

    /**
     * nome do contato
     */
    private String nome;

    /**
     * sobrenome do contato
     */
    private String sobrenome;

    /**
     * telefone do contato
     */
    private String telefone;

    /**
     * tags do contato
     */
    private String[] tags;

    /**
     * Método construtor
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     * @param telefone telefone do contato
     */
    public Contato(String nome, String sobrenome, String telefone) {
        if (nome.isEmpty() || telefone.isEmpty()) {
            throw new IllegalArgumentException("PARAMETRO VAZIO");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.tags = new String[5];
    }

    /**
     * Acessa o nome e o sobrenome do contato.
     * @return retona numa string o nome e sobrenome do contato
     */
    public String getNomeSobrenome() {
        return this.nome + " " + this.sobrenome;
    }

    /**
     * Acessa o nome do contato.
     * @return retona numa string o nome do contato
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Acessa o sobrenome do contato.
     * @return retona numa string sobrenome do contato
     */
    public String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * Acessa aos atributos do contato.
     * @return retona numa string os atributos do contato
     */
    @Override
    public String toString() {
        return this.nome +  " " + this.sobrenome + '\n' + this.telefone + listaTags();
    }

    /**
     * Acessa as tags do contato.
     * @return lista de tags do contato
     */
    private String listaTags() {
        String tagsContato = "";
        for (String tag : this.tags) {
            if (tag != null) {
                tagsContato += tag + " ";
            }
        }
        if (tagsContato.equals("")) {return"";}
        return "\n" + tagsContato.trim();
    }

    /**
     * edita o telefone de um contato
     * @param telefone novo numero de telefone.
     */
    public void setTelefone(String telefone) {
        if (telefone.isEmpty()) {
            throw new IllegalArgumentException("PARAMETRO VAZIO");
        }
        this.telefone = telefone;
    }

    /**
     * Adiciona uma tag a um contato
     * @param tag tag.
     * @param posicaoTag posição na lista de tags.
     */
    public void setTag(String tag, int posicaoTag) {
        if (tag.isEmpty()) {
            throw new IllegalArgumentException("PARAMETRO VAZIO");
        }
        if (posicaoTag <= 0 || posicaoTag > 5) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        this.tags[posicaoTag-1] = tag;
    }

    /**
     * Remove uma tag de um contato
     * @param posicaoTag posição na lista de tags.
     */
    public void rmTag(int posicaoTag) {
        if (posicaoTag <= 0 || posicaoTag > 5) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        tags[posicaoTag-1] = null;
    }

    /**
     * Retorna uma tag de um contato
     * @param posicaoTag posição na lista de tags.
     * @return Tag do contato.
     */
    public String getTag(int posicaoTag) {
        if (posicaoTag <= 0 || posicaoTag > 5) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
        }
        return tags[posicaoTag-1];
    }

    /**
     * Método para comparar objetos
     * @param o objeto a ser comparado
     * @return True caso os objetos sejam iguais, false caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome);
    }
}