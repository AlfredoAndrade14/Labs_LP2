package com.matheusgr.lunr.busca;

/**
 * Armazena o histórico de uma busca realizada. O histórico não deve ter custo
 * computacional e deve ser genérico para diferentes tipos de busca.
 */
public class HistoricoBusca {

	private Busca buscaFeita;
	private String[] documentosIds;

	/**
	 * Construção do histórico a partir dos parâmetros de busca (definido pelo
	 * objeto de busca) e resultado da consulta.
	 * 
	 * @param buscaFeita      Objeto de busca realizado.
	 * @param documentosIds Resultado da pesquisa.
	 */
	public HistoricoBusca(Busca buscaFeita, String[] documentosIds) {
		this.buscaFeita = buscaFeita;
		this.documentosIds = documentosIds;
	}

	/**
	 * Depura uma busca onde cada linha representa um parâmetro de busca e cada
	 * coluna representa esse parâmetro em detalhes.
	 * 
	 * @return Depuração da busca. Cada linha representa um parâmetro de busca e
	 *         cada coluna um detalhamento desse parâmetro (ex.: NOME_DO_PARAMETRO e
	 *         VALOR).
	 */
	public String[][] debug() {
		return this.buscaFeita.descreveConsulta();
	}

	/**
	 * Retorna os IDs dos documentos retornados da busca.
	 * 
	 * @return Array de string com IDs dos documentos retornados.
	 */
	public String[] ids() {
		return documentosIds;
	}

}