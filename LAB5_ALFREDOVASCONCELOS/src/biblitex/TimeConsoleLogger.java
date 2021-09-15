package biblitex;

/**
 * Classe de um Logger que imprime o momento em que
 * cada método foi executado em relação ao momento que
 * o objeto TimeConsoleLogger é criado em ms.
 */
public class TimeConsoleLogger implements Logger{
    /**
     * Tempo em que o Logger foi criado.
     */
    Long tempoDeCriação;

    /**
     * Método construtor que define o tempo em que o logger foi criado.
     */
    public TimeConsoleLogger() {
        this.tempoDeCriação = System.currentTimeMillis();
    }

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado no sistema
     * e o texto passado por parametro no método e retorna na saida padrão o registro com
     * o tempo em que foi executado depois da criação do logger.
     * @param metodo Nome do método que foi executado no sistema.
     * @param parametro Primeiro parâmetro passado no método.
     */
    @Override
    public void log(String metodo, String parametro) {
        System.out.println("[" + metodo + " - " + (System.currentTimeMillis() - tempoDeCriação) + "ms] " + parametro);
    }

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado
     * no sistema e retorna na saida padrão o registro com o tempo em que foi
     * executado depois da criação do logger.
     * @param metodo Nome do método que foi executado no sistema.
     */
    @Override
    public void log(String metodo) {
        System.out.println("[" + metodo + " - " + (System.currentTimeMillis() - tempoDeCriação) + "ms]");
    }
}
