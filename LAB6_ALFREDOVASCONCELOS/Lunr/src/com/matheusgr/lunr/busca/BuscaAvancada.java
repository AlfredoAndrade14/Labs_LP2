package com.matheusgr.lunr.busca;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

import java.util.HashMap;
import java.util.Map;

public class BuscaAvancada implements Busca{
    private Map<String, String> metadados;

    /**
     * Construtor padrão com os metadados a serem encontrados.
     *
     * Os metadados vazios são ignorados. Pelo menos 1 metadados deve ser não vazio.
     *
     * @param metadados metadados a serem pesquisados.
     */
    public BuscaAvancada(Map<String, String> metadados) {
        (new ValidadorBusca()).valida(metadados);
        this.metadados = metadados;
    }

    /**
     * Realiza a busca a partir da consulta ao DocumentoService.
     *
     * O DocumentoService realiza a operação avançada de busca, sem
     * ordenação ou tratamento da lógica de relevância.
     *
     * @param ds DocumentoService a ser utilizado para busca.
     * @return Mapa com os documentos encontrados e o fator de relevância de cada
     *         operação.
     */
    @Override
    public Map<Documento, Integer> busca(DocumentoService ds) {
        Map<Documento, Integer> respostaDocumento = new HashMap<>();
        for (String metadado : this.metadados.keySet()) {
            if (metadado.isBlank() || metadados.get(metadado).isBlank()) {
                continue;
            }
            for (Documento d : ds.busca(metadados)) {
                respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
            }
        }
        return respostaDocumento;
    }

    /**
     * Descreve uma consulta para explicar a consulta que foi feita.
     *
     * @return Descrição da busca, onde cada linha representa um parâmetro de busca
     *         e as colunas representam um detelhamento de cada parâmetro.
     */
    @Override
    public String[][] descreveConsulta() {
        return new String[0][];
    }
}
