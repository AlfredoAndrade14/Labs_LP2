package com.matheusgr.lunr.documento;

import biblitex.TransformaTexto;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Supercalsse de documento que define alguns métodos padrões de documentos e atributos
 */
public abstract class DocumentoAbstract implements Documento{
    protected String id;
    protected String original;
    protected String limpo;
    protected String[] split;
    protected Map<String, String> metadados;

    /**
     * Construtor padrão do documento.
     * @param id ID do documento.
     * @param original Texto do documento.
     */
    public DocumentoAbstract(String id, String original) {
        this.id = id;
        this.original = original;
    }

    /**
     * Retorna a identificação do documento. A documentação é definida pelo próprio
     * documento e é uma String sem formatação específica. Todo documento gerado
     * pelo Lunr começa com o símbolo "_". O identificador não pode ser vazio ou
     * nulo.
     *
     * @return Identificação do documento.
     * @throws NullPointerException Caso o ID seja nulo.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * método que define o hashcode do objeto
     * @return hashcode do objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Retorna a quantidade de texto útil, sendo definido como a quantidade de
     * caracteres úteis (sem caracteres estranhos e sem espaços) sobre o total de
     * caracteres original (incluindo espaços).
     *
     * @return Percentual de texto útil (entre 0 e 1, inclusives).
     */
    @Override
    public double metricaTextoUtil() {
        long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo).length();
        return (1.0 * extractedSize) / this.original.length();
    }

    /**
     * Retorna os termos do texto em formato de String. Não podem existir termos
     * vazios (só de espaços, tabulações ou string vazia).
     *
     * @return Array de termos extraídos do documento.
     */
    @Override
    public String[] getTexto() {
        if (this.split == null) {
            this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
                    .split(" ");
            Arrays.sort(this.split);
        }
        return this.split;
    }

    /**
     * Método que gera e retorna a representação textual do Documento
     * @return representação textual do documento
     */
    @Override
    public String toString() {
        return "===" + this.id + System.lineSeparator() + this.limpo;
    }

    /**
     * Retorna metadados referente ao documento. Detalhes como seu tipo, autor, ou
     * características próprias do documento.
     *
     * Idealmente, todo metadado terá como características:
     *
     * LINHAS, TAMANHO (número de caracteres), METADATADATE (hora atual do sistema
     * na criação dos metadados, em ms), TIPO.
     *
     * @return Mapa com os metadados descrito em forma textual.
     */
    @Override
    public Map<String, String> getMetadados() {
        if (this.metadados != null) {
            return this.metadados;
        }
        this.metadados = extractMetadadosEspecificos(this.original);
        this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
        this.metadados.put("TAMANHO", "" + this.limpo.length());
        this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
        return this.metadados;
    }

    /**
     * Método que extrai os metadados especificos de cada documento
     * @param original texto original do documento
     * @return hashmap com os metadados especificos.
     */
    protected abstract Map<String, String> extractMetadadosEspecificos(String original);
}
