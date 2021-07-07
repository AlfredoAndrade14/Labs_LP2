package lab2;
/**
 * Representação de um controle de descanso de um aluno.
 * Em que o aluno define a quantidade de horas de descanso,
 * a quantidade de semanas e pode ver seu status geral.
 * Para ser considerado descansado o aluno precisa de
 * 26 horas por semana de descanso.
 * @author ALfredo Vasconcelos de Andrade
 */
public class Descanso {
    /**
     * Quantidade de horas de descanso.
     */
    private int horasDeDescanso;

    /**
     * Quantiddade de semanas.
     */
    private int semanas;

    /**
     * Variavel que representa o status do aluno
     * através de um emoji.
     */
    private String emoji = "";

    /**
     * Variavel que recebe o status do auno
     */
    private String status;

    /**
     * Recebe a quantidade de horas de descanso e armazena a quantidade de horas.
     * @param valor a quantidade de horas de descanço.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
        this.emoji = "";
    }

    /**
     * Recebe a quantidade de semanas e armazena o numero de semanas.
     * @param valor a quantidade de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        this.semanas = valor;
    }

    /**
     * Recebe um emoji como parametro que representa o status do aluno.
     * @param valor emoji representante de status
     */
    public void definirEmoji(String valor){
        this.emoji = valor;
    }

    /**
     * verifica o estado de descanso fazendo a media de horas
     * por semana e expondo o estado de descanso levando em
     * consideração o valor de 26 horas como o minimo para ser
     * considerado descansado.
     * @return é o status relativo a um aluno
     */
    public String getStatusGeral() {
        if (semanas != 0) {
            this.status = (horasDeDescanso / semanas >= 26) ? "descansado" : "cansado";
        } else { this.status = "cansado"; }

        if (this.emoji != "") {
            this.status += " " + this.emoji;
        }
        return this.status;
    }

}
