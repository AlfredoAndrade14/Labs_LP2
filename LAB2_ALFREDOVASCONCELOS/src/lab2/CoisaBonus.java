package lab2;
/**
 * Classe para teste de funcionalidades extra que não
 * há na classe Coisa.
 * @author ALfredo Vasconcelos de Andrade
 */
public class CoisaBonus {
    public static void main(String[] args) {
        disciplina();
        System.out.println("-----");
        financas();
        System.out.println("-----");
        descanso();
        System.out.println("-----");
    }

    /**
     * Função que faz uso da implementação da funcionalidade
     * bonus de fazer uma media com uso de mais que ou menos
     * que quatro notas para a media da classe Disciplina.
     */
    private static void disciplina() {
        Disciplina ic = new Disciplina("INTRODUÇÂO À COMPUTAÇÂO", 2);
        ic.cadastraHoras(10);
        ic.cadastraNota(1, 8.0);
        ic.cadastraNota(2, 6.0);
        System.out.println(ic.aprovado());
        System.out.println(ic.toString());

        System.out.println();

        Disciplina icc = new Disciplina("INTRODUÇÂO À CIENCIA DA COMPUTAÇÂO", 6, new int[] {3, 2, 5, 4, 1, 5});
        icc.cadastraHoras(5);
        icc.cadastraNota(1, 7.0);
        icc.cadastraNota(2, 5.0);
        icc.cadastraNota(3, 8.0);
        icc.cadastraNota(4, 7.0);
        icc.cadastraNota(5, 5.0);
        icc.cadastraNota(6, 8.0);
        System.out.println(icc.aprovado());
        System.out.println(icc.toString());
    }

    /**
     * Função que faz uso da implementação da funcionalidade
     * bonus de fazer um resgistro de detalhes de uma despesa
     * e mostrar os 5 ultimos detalhes, da classe RigistroFinacas.
     */
    private static void financas() {
        int dinheiroGuardado = 10000;
        int historicoDeGanhos = 4;
        RegistroFinancas minhaFinanca = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);

        minhaFinanca.adicionaGanhos(12000, 1);
        minhaFinanca.adicionaGanhos(72100, 2);
        minhaFinanca.adicionaGanhos(7210, 3);
        minhaFinanca.pagaDespesa(200, "chocolate");
        minhaFinanca.pagaDespesa(2000, "queijo");
        minhaFinanca.pagaDespesa(200, "doce");
        minhaFinanca.pagaDespesa(5000, "aluguel");
        System.out.println(minhaFinanca.exibeGanhos());
        System.out.println(minhaFinanca.toString());
        System.out.println(minhaFinanca.listarDetalhes());

        System.out.println();

        RegistroFinancas financa = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);
        financa.adicionaGanhos(12000, 1);
        financa.adicionaGanhos(72100, 2);
        financa.adicionaGanhos(7210, 2);
        financa.pagaDespesa(200, "chocolate");
        financa.pagaDespesa(2000, "queijo");
        financa.pagaDespesa(200, "doce");
        financa.pagaDespesa(5000, "aluguel");
        financa.pagaDespesa(5000, "feira");
        financa.pagaDespesa(5000, "janta");
        financa.pagaDespesa(5000, "almoço");
        System.out.println(financa.toString());
        System.out.println(financa.listarDetalhes());
    }

    /**
     * Função que faz uso da implementação da funcionalidade
     * bonus de registrar um emoji relativo ao estado de cansaço
     * do aluno e expor junto do estado.
     */
    public static void descanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        descanso.definirEmoji("*_*");
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(40);
        descanso.defineNumeroSemanas(2);
        descanso.definirEmoji(":(");
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }
}
