package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno andrade
 * @author Alfredo Vasconcelos
 *
 */
public class Agenda {

	/**
	 * tamanho maximo da lista de contatos
	 */
	private static final int TAMANHO_AGENDA = 100;

	/**
	 * lista de contatos
	 */
	private Contato[] contatos;

	/**
	 * lista de favoritos
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior
	 * E um contato com o mesmo Nome e Sabrenome não cadastra.
	 * @param posicaoContato Posição do contato.
	 * @param nome Nome do contato.
	 * @return retorna que o cadastro foi realizado, ou se o contato já é cadastrado.
	 */
	public String cadastraContato(int posicaoContato, String nome, String sobrenome, String telefone) {
		if (nome.isEmpty() || telefone.isEmpty()) {
			throw new IllegalArgumentException("PARAMETRO VAZIO");
		}
		if (posicaoContato < 0 || posicaoContato > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}

		Contato novoContato = new Contato(nome, sobrenome, telefone);

		for (Contato contato : this.contatos) {
			if (contato != null) {
				if (contato.equals(novoContato)) {
					return "CONTATO JA CADASTRADO";
				}
			}
		}

		contatos[posicaoContato-1] = novoContato;
		return "CADASTRO REALIZADO";
	}

	/**
	 * Edita o telefone de um contato.
	 * @param posicaoContato posição do contato a ser editado.
	 * @param telefone novo numero.
	 */
	public void editaTelefone(int posicaoContato, String telefone) {
		if (posicaoContato <= 0 || posicaoContato > 100 || contatos[posicaoContato - 1] == null) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if (telefone.isEmpty()) {
			throw new IllegalArgumentException("PARAMETRO VAZIO");
		}
		this.contatos[posicaoContato - 1].setTelefone(telefone);
	}

	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String getContatos() {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (contatos[i] != null) {
				lista += i+1 + " - " + contatos[i].getNomeSobrenome() +"\n";
			}
		}
		return lista;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicaoContato Posição do contato na agenda.
	 * @return Dados do contato. "POSIÇÃO INVÁLIDA" se não há contato na posição.
	 */
	public String getContato(int posicaoContato) {
		String contato = "POSIÇÃO INVÁLIDA!";
		if (posicaoContato-1 >= 0 && posicaoContato-1 < 100) {
			if (this.contatos[posicaoContato-1] != null) {
				contato = verificaFavorito(posicaoContato) + this.contatos[posicaoContato-1].toString();
			}
		}
		return contato;
	}

	/**
	 * Adiciona uma tag a um contato
	 * @param contatos contatos que vão receber a tag.
	 * @param tag tag a ser colocado.
	 * @param posicaoTag posição da tag na lista de tags.
	 */
	public void setTag(String[] contatos, String tag, int posicaoTag) {
		if (posicaoTag <= 0 || posicaoTag > 5) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if (tag.isEmpty() || contatos.length == 0) {
			throw new IllegalArgumentException("PARAMETRO VAZIO");
		}
		for (String contato : contatos) {
			this.contatos[Integer.parseInt(contato) - 1].setTag(tag, posicaoTag);
		}
	}

	/**
	 * favorita um contato em uma posição. Um contato em uma posição que já existe sobrescreve o anterior.
	 * @param posicaoContato contato a ser favoritado.
	 * @param posicaoFavorito Posição da lista de favoritos.
	 * @return Retorna se a posição é invalida, ou se o Contato já foi favoritado em outra posição e qual posição,
	 * ou em qual posição foi favoritado.
	 */
	public String favoritar(int posicaoContato, int posicaoFavorito) {
		if (posicaoContato <= 0 || posicaoContato > 100 || posicaoFavorito <= 0 || posicaoFavorito > 10) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if (this.contatos[posicaoContato-1] == null) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		for ( int i = 0; i < favoritos.length; i++){
			if (this.favoritos[i] != null) {
				if (this.favoritos[i].equals(this.contatos[posicaoContato-1])) {
					return "CONTATO FAVORITADO NA POSIÇÃO " + (i + 1);
				}
			}
		}
		this.favoritos[posicaoFavorito - 1] = this.contatos[posicaoContato - 1];
		return "CONTATO FAVORITADO NA POSIÇÃO " + (posicaoFavorito + 1);
	}

	/**
	 * Acessa a lista de favoritos.
	 * @return O array de favoritos.
	 */
	public String getFavoritos() {
		String lista = "";
		for (int i = 0; i < this.favoritos.length; i++) {
			if (favoritos[i] != null) {
				lista += i+1 + " - " + this.favoritos[i].getNomeSobrenome() +"\n";
			}
		}
		return lista;
	}

	/**
	 * Verifica se um contato está na lista de favoritos.
	 * @param posicaoContato possição do contato na lista de contatos.
	 * @return string vazia caso não seja favorito, e um coração caso seja favorito.
	 */
	private String verificaFavorito(int posicaoContato) {
		if (posicaoContato <= 0 || posicaoContato > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		for (Contato favorito : this.favoritos) {
			if (favorito != null) {
				if (favorito.equals(this.contatos[posicaoContato - 1])) {
					return "❤ ";
				}
			}
		}
		return "";
	}

	/**
	 * Remove uma tag de uma posição de um contato.
	 * @param posicaoContato possição do contato na lista de contatos.
	 * @param posicaoTag posição da tag a ser removida.
	 * @return Confirma que a Tag foi removida
	 */
	public String rmTag(int posicaoContato, int posicaoTag) {
		if (posicaoContato <= 0 || posicaoContato > 100 || posicaoTag <= 0 || posicaoTag > 5) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		contatos[posicaoContato - 1].rmTag(posicaoTag);
		return "Tag removida com sucesso";
	}

	/**
	 * Remove um contato que foi favoritado.
	 * @param posicaoFavorito posição do contato na lista de favoritos a ser removido.
	 * @return Confirma que o contato foi desfavoritado com sucesso
	 */
	public String desfavorita(int posicaoFavorito) {
		if (posicaoFavorito <= 0 || posicaoFavorito > 10 || this.favoritos[posicaoFavorito-1] == null) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		this.favoritos[posicaoFavorito-1] = null;
		return "Desfavoritado com sucesso";
	}

	/**
	 * Remove um contato da lista de contatos e dos favoritos.
	 * @param posicaoContato posição do contato a ser removido.
	 * @return Confirma que o contato foi apagado com sucesso
	 */
	public String zerarContato(int posicaoContato) {
		if (posicaoContato <= 0 || posicaoContato > 100 || contatos[posicaoContato-1] == null) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				if (this.favoritos[i].equals(this.contatos[posicaoContato-1])) {
					this.favoritos[i] = null;
				}
			}
		}
		this.contatos[posicaoContato-1] = null;
		return "Contato apagado com sucesso";
	}

	/**
	 * Retorna uma lista de contatos com o mesmo nome.
	 * @param nome o nome a ser consultado.
	 * @return O array de contatos com mesmo nome.
	 */
	public String pesquisaNome(String nome) {
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("PARAMETRO VAZIO");
		}
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getNome().equals(nome)) {
					lista += i+1 + " - " + contatos[i].getNomeSobrenome() + "\n";
				}
			}
		}
		return lista;
	}

	/**
	 * Retorna uma lista de contatos com o mesmo sobrenome.
	 * @param sobrenome o sobrenome a ser consultado.
	 * @return O array de contatos com mesmo sobrenome.
	 */
	public String pesquisaSobrenome(String sobrenome) {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getSobrenome().equals(sobrenome)) {
					lista += i+1 + " - " + contatos[i].getNomeSobrenome() + "\n";
				}
			}
		}
		return lista;
	}

	/**
	 * Retorna uma lista de contatos com a mesma Tag.
	 * @param tag a tag a ser consultada.
	 * @return O array de contatos com mesma tag.
	 */
	public String pesquisaTag(String tag) {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (contatos[i] != null) {
				for (int j = 1; j < 6; j++)	 {
					if (contatos[i].getTag(j) != null) {
						if (contatos[i].getTag(j).equals(tag)) {
								lista += i+1 + " - " + contatos[i].getNomeSobrenome() + "\n";
								break;
						}
					}
				}
			}
		}
		return lista;
	}
}