package com.matheusgr.lunr.documento;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

/**
 * Documento base java. As palavras-chave da linguagem ainda são preservadas
 * (como public, private, etc), mas elimina-se documentação e comentários.
 */
class DocumentoJava extends DocumentoAbstract {

	/**
	 * Cria o DocumentoJava, extraindo o texot base.
	 * 
	 * @param id       ID do documento a ser criado.
	 * @param original Código java original.
	 */
	public DocumentoJava(String id, String original) {
		super(id, original);
		var transformaTexto = new TransformaTexto();
		var txt = transformaTexto.transforma(TransformaTexto.Algoritmos.java, original);
		this.limpo = transformaTexto.transforma(TransformaTexto.Algoritmos.clean, txt).strip();
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
		DocumentoJava other = (DocumentoJava) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Metadados particulares de java: número de imports e autor da classe.
	 */
	protected Map<String, String> extractMetadadosEspecificos(String original2) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("IMPORTS", "" + ((this.limpo.length() - this.limpo.replaceAll("import ", "").length()) / 7));
		metadados2.put("AUTHOR", "" + (this.original.indexOf("@author") != -1 ? "TRUE" : ""));
		metadados2.put("TIPO", "" + "java");
		return metadados2;
	}

}
