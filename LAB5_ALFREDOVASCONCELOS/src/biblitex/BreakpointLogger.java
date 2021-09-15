package biblitex;

/**
 * Classe de um Logger que sempre que no sistema é executado uma operação
 * em especifico retorna uma mensagem relatando;
 */
public class BreakpointLogger implements Logger{
    /**
     * nome do método especifico passado na chamada do construtor.
     */
    private String metodoEpecifico;

    /**
     * Método construtor da classe.
     * @param metodo nome do método especifico.
     */
    public BreakpointLogger(String metodo) {
        this.metodoEpecifico = metodo;
    }

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado no sistema
     * e o texto passado por parametro no método e retorna na siada padrão o registro.
     * @param metodo Nome do método que foi executado no sistema.
     * @param parametro  Primeiro parâmetro passado no método.
     */
    @Override
    public void log(String metodo, String parametro) {
        if (metodo.equals(metodoEpecifico)) {
            System.out.println("[INVOCADO - " + metodo + "] " + parametro);
        }
    }

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado.
     * no sistema e retorna na siada padrão o registro.
     * @param metodo Nome do método que foi executado no sistema.
     */
    @Override
    public void log(String metodo) {
        if (metodo.equals(metodoEpecifico)) {
            System.out.println("[INVOCADO - " + metodo + "]");
        }
    }
}
