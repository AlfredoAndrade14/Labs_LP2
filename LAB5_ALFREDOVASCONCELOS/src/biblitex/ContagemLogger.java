package biblitex;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de um Logger que registra as operações executadas no sistema
 * e que pode retornar um relatori dessas operações com quantidade de vezes feitas.
 */
public class ContagemLogger implements Logger{
    /**
     * Mapa que armazena os métodos que foram chamados e
     * a quantidade de vezes chamado.
     */
    private Map<String, Integer> metodosChamados;

    /**
     * Método construtor que inicializa o mapa que vai armazenar
     * os métodos chamados e a quantidade de vezes que foi chamado.
     */
    public ContagemLogger() {
        this.metodosChamados = new HashMap<>();
    }

    /**
     * Método que gera e retorna uma representação textual do historico de operações
     * executadas no sistema.
     * @return representação textual do historico de operações executadas no sistema.
     */
    @Override
    public String toString() {
        String saida = "";
        for (String metodo: this.metodosChamados.keySet()) {
            saida += metodo + " - " + this.metodosChamados.get(metodo) + "\n";
        }

        return saida;
    }

    /**
     * Método de armazenamento de operações realizadas no sistema
     * recebe por parametro o nome do método que foi executado no sistema
     * e o texto passado por parametro no método e no mapa.
     * @param metodo Nome do método que foi executado no sistema.
     * @param parametro Primeiro parâmetro passado no método.
     */
    @Override
    public void log(String metodo, String parametro) {
        if (metodosChamados.containsKey(metodo)) {
            this.metodosChamados.put(metodo,this.metodosChamados.get(metodo) + 1);
        } else {
            this.metodosChamados.put(metodo,1);
        }
    }

    /**
     * Método de armazenamento de operações realizadas no sistema
     * recebe por parametro o nome do método que foi executado
     * no sistema e armazena no mapa.
     * @param metodo Nome do método que foi executado no sistema.
     */
    @Override
    public void log(String metodo) {
        if (this.metodosChamados.containsKey(metodo)) {
            this.metodosChamados.put(metodo,this.metodosChamados.get(metodo) + 1);
        } else {
            this.metodosChamados.put(metodo,1);
        }
    }
}
