package com.matheusgr.lunr.busca;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

import java.util.Map;

/**
 * Busca representa um busca a ser feita pelo sistema
 */
public interface Busca {
    /**
     * Realiza a busca a partir da consulta ao DocumentoService.
     *
     * O DocumentoService realiza operações de busca, mas sem
     * ordenação ou tratamento da lógica de relevância.
     *
     * @param ds DocumentoService a ser utilizado para busca.
     * @return Mapa com os documentos encontrados e o fator de relevância de cada
     *         operação.
     */
    public Map<Documento, Integer> busca(DocumentoService ds);

    /**
     * Descreve uma consulta para explicar a consulta que foi feita.
     *
     * @return Descrição da busca, onde cada linha representa um parâmetro de busca
     *         e as colunas representam um detelhamento de cada parâmetro.
     */
    public String[][] descreveConsulta();
}
