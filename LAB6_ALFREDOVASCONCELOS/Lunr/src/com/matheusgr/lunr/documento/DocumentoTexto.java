package com.matheusgr.lunr.documento;

import biblitex.TransformaTexto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Documento de texto simples. Não precisa de tratamento complexos nem tem
 * metadados próprios.
 */
class DocumentoTexto extends DocumentoAbstract {

	/**
	 * Construtor padrão do documento de texto.
	 * @param id ID do documento.
	 * @param original Texto do documento.
	 */
	public DocumentoTexto(String id, String original) {
		super(id, original);
		this.limpo = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, original).strip();
	}

	/**
	 * Método que verifica a igualdade entre o documento e outros objetos.
	 *
	 * @param obj objeto a ser checado
	 * @return ture caso os objteos sejam iguais e false caso contrário
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoTexto other = (DocumentoTexto) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Inicializa o hashmap de metadados e adiciona o metadado tipo
	 * @param original texto original do documento
	 * @return metadados do documento
	 */
	@Override
	protected Map<String, String> extractMetadadosEspecificos(String original) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("TIPO", "" + "txt");
		return metadados2;
	}
}
