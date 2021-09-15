package biblitex;

/**
 * Classe de um Logger que retorna uma mensagem relatando qual operação foi executada.
 */
public class ConsoleLogger implements Logger{

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado no sistema
     * e o texto passado por parametro no método e retorna na saida padrão o registro.
     * @param metodo Nome do método que foi executado no sistema.
     * @param parametro Primeiro parâmetro passado no método.
     */
    @Override
    public void log(String metodo, String parametro) {
        System.out.println("[" + metodo + "] " + parametro);
    }

    /**
     * Método de registro de operação realizada no sistema
     * recebe por parametro o nome do método que foi executado.
     * no sistema e retorna na saida padrão o registro.
     * @param metodo Nome do método que foi executado no sistema.
     */
    @Override
    public void log(String metodo) {
        System.out.println("[" + metodo + "]");
    }
}
