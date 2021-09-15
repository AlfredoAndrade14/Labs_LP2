package biblitex;

import java.util.*;

/**
 * Classe que armazena algoritmos de transformação textual, que pode listar as transformações,
 * realiza elas, mostrar o numero de quantas foram realizadas, guardar o historico delas,
 * listar os textos originais sem repetição e cadastrar uma nova transformação.
 */
public class TransformaTexto {
    /**
     * Mapa de transformações textuais, onde a chave é o nome dado a ela e o valor o algoritmo de transformação.
     */
    private Map<String,Transformacao> transformacoes;

    /**
     * Lista de strings que representa o historico de cada transformação.
     */
    private ArrayList<String> historico;

    /**
     * HashSet que armazena os textos originais passados nas transformações..
     */
    private Set<String> originais;

    /**
     * Logger que pode ser passado no construtor ou não.
     */
    private Logger logger;

    /**
     * Método construtor que inicia o hashmap com os métodos já existentes e não recebe Logger como parâmetro.
     */
    public TransformaTexto() {
        this.transformacoes = new HashMap<>();
        this.historico = new ArrayList<>();
        this.originais = new HashSet<>();

        this.transformacoes.put("CaMeLcAsEfY", new CamelCasefy());
        this.transformacoes.put("clean", new Clean());
        this.transformacoes.put("interrogaPraPontos", new InterrogaPraPontos());
        this.transformacoes.put("upperCase", new UpperCase());
        this.transformacoes.put("CleanSpaces", new CleanSpaces());
        this.transformacoes.put("RemoveVogais", new RemoveVogais());
    }

    /**
     * Método construtor que inicia o hashmap com os métodos já existentes e recebe Logger como parâmetro.
     * @param logger logger que vai analisar a atividade realizadas no sistema.
     */
    public TransformaTexto(Logger logger) {
        this.transformacoes = new HashMap<>();
        this.historico = new ArrayList<>();
        this.originais = new HashSet<>();

        this.transformacoes.put("CaMeLcAsEfY", new CamelCasefy());
        this.transformacoes.put("clean", new Clean());
        this.transformacoes.put("interrogaPraPontos", new InterrogaPraPontos());
        this.transformacoes.put("upperCase", new UpperCase());
        this.transformacoes.put("CleanSpaces", new CleanSpaces());
        this.transformacoes.put("RemoveVogais", new RemoveVogais());

        this.logger = logger;
    }

    /**
     * Método que transforma o texto passado no segundo parâmetro com base no nome
     * do algoritmo guardado no hashmap escolhida pelo primeiro parâmetro, e guarda
     * o texto original e o historico da operação.
     *
     * @param transformacao O nome definido no hashmap para o algoritimo desejada.
     * @param texto O texto que deseja que seja transformado.
     * @return O texto depois de transformado.
     */
    public String transforma(String transformacao, String texto) {
        if (this.logger != null){
            this.logger.log("transforma",transformacao);
        }

        if (transformacoes.containsKey(transformacao)) {
            String textoFormatado = this.transformacoes.get(transformacao).transforma(texto);
            this.originais.add(texto);
            this.historico.add(texto + " " + transformacao + " -> " + textoFormatado);

            return textoFormatado;
        }
        return "Transformação não cadastrada";
    }

    /**
     * Método que retorna o numero de transformações textuais realizadas com base no histórico.
     *
     * @return numero de transformações textuais realizadas.
     */
    public int contaTransformacao() {
        if (this.logger != null){
            this.logger.log("contaTransformacao");
        }

        return this.historico.size();
    }

    /**
     * retorna o historico de uma determinada ,passada por parâmetro a possição na lista de hitorico,
     * transformação feita.
     *
     * @param posicao Numero do historico da transformação desejada.
     * @return historico de uma determinada transformação.
     */
    public String historico(int posicao) {
        if (this.logger != null){
            this.logger.log("historico", Integer.toString(posicao));
        }

        if(posicao <= 0 || posicao > historico.size() - 1) {
            throw new IllegalArgumentException("Posição invalida");
        }

        return this.historico.get(posicao);
    }

    /**
     * Método que retorna uma lista com os textos originais das transformações sem repetição.
     *
     * @return lista com os textos originais das transformações sem repetição.
     */
    public String listarOriginais() {
        if (this.logger != null){
            this.logger.log("listarOriginais");
        }

        String saida = "";
        for (String originai : this.originais) {
            saida += originai + "\n";
        }

        return saida;
    }

    /**
     * Método que retorna uam lista em ordem alfabetica com as transformações cadastradas no sistema.
     *
     * @return lista em ordem alfabetica das transformações cadastradas.
     */
    public String listarTransformacoes() {
        if (this.logger != null){
            this.logger.log("listarTransformacoes");
        }

        List<Transformacao> listaDeTranformacoes = new ArrayList<>(this.transformacoes.values());
        Collections.sort(listaDeTranformacoes);

        String saida = "";
        for (Transformacao listaDeTranformacoe : listaDeTranformacoes) {
            saida += listaDeTranformacoe.getNome() + "\n";
        }
        return saida;
    }

    /**
     * Método que cadastra uma nova transformação no sistema, recebendo por parâmetro seu nome a ser
     * cadastrado e o objeto que representa o algoritimo de transformação.
     *
     * @param nomeTransformacao nome desejado a ser cadastrado
     * @param Algoritmo objeto que representa o algoritimo de transformação.
     */
    public void cadastraTransformacao(String nomeTransformacao, Transformacao Algoritmo) {
        if (this.logger != null){
            this.logger.log("cadastraTransformacao");
        }

        this.transformacoes.put(nomeTransformacao, Algoritmo);
    }
}