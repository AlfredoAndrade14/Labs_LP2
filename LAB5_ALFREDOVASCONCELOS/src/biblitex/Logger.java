package biblitex;

/**
 * Interface de Loggers
 */
public interface Logger {
    /**
     * Log para quando o método executado recebe parâmetro.
     * @param metodo nome do método executado.
     * @param parametro Primeiro parâmetro passado no método passado no método.
     */
    public void log(String metodo, String parametro);

    /**
     * Log para quando o método executado não recebe parâmetro.
     * @param metodo nome do método executado.
     */
    public void log(String metodo);
}
