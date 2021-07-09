package lab2;

import java.util.Scanner;

/**
 * Sistema que recebe comandos da entrada e que
 * traduzem tais comandos em ações nos 4 objetos
 * do sistema.
 * @author ALfredo Vasconcelos de Andrade
 */
public class CoisaCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        System.out.println("Digite o comando ou para ver os comandos digite 'c', para sair digite 's'." );
        while (rodando) {
            String linha = sc.nextLine();
            String[] comando = linha.split(" ");

            switch (comando[0].toUpperCase()) {
                case "C":
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("TEMPOONLINE nome tempo -=-=- Para registar o tempo online em uma disciplina. nome = nome da disciplina; tempo = tempo online"
                    + "\nDESPESA gasto -=-=- para registrar um gasto e a descrição do gasto. gasto = valor em centavos"
                    + "\nNOTAS nome n1 n2 n3 n4 -=-=- para registrar notas de uma disciplina. nome = nome da disciplina; n1-4 = notas"
                    + "\nSTATUS horas semanas emoji -=-=- registra status de descanso do aluno. horas = horas de descanso; semanas = quantidade de semana; emoji = emoji de status");
                    System.out.println("----------------------------------------------------------------");
                    break;
                case "S":
                    rodando = false;
                    break;
                case "TEMPOONLINE":
                    registroOnline(comando[1], Integer.parseInt(comando[2]));
                    break;
                case "DESPESA":
                    financas(Integer.parseInt(comando[1]));
                    break;
                case "NOTAS":
                    disciplina(comando[1], Integer.parseInt(comando[2]), Integer.parseInt(comando[3]), Integer.parseInt(comando[4]), Integer.parseInt(comando[5]));
                    break;
                case "STATUS":
                    descanso(Integer.parseInt(comando[1]), Integer.parseInt(comando[2]),comando[3]);
                    break;
                default:
                    System.out.println("Comando não reconhecido, tente novamente.");
            }
        }
    }

    /**
     * Função chamada quando o usuaria escrve "TEMPOONLINE"
     * e passa o nome da disciplina e o tempo online na
     * mesma linha separado por espaço.
     * @param nome o nome da disciplina.
     * @param tempo o tempo online gasto por um aluno.
     */
    private static void registroOnline(String nome, int tempo) {
        RegistroTempoOnline disciplina = new RegistroTempoOnline(nome);
        disciplina.adicionaTempoOnline(tempo);
        System.out.println(disciplina.toString());
    }

    /**
     * Função chamada quando o usuaria escrve "DESPESA"
     * e passa o gasto de um aluno mesma linha separado
     * por espaço.
     * @param gasto valor gasto em centavos por um aluno.
     */
    private static void financas(int gasto) {
        RegistroFinancas minhaFinanca = new RegistroFinancas(10000, 4);
        minhaFinanca.pagaDespesa(gasto);
        System.out.println(minhaFinanca.toString());
    }

    /**
     * Função chamada quando o usuaria escrve "NOTAS"
     * e passa o nome da disciplina e as notas dela
     * mesma linha separado por espaço.
     * @param materia o nome da disciplina.
     * @param nota1 nota 1 da disciplina.
     * @param nota2 nota 2 da disciplina.
     * @param nota3 nota 3 da disciplina.
     * @param nota4 nota 4 da disciplina.
     */
    private static void disciplina(String materia, double nota1 ,double nota2 , double nota3 , double nota4) {
        Disciplina cadeira = new Disciplina(materia);
        cadeira.cadastraNota(1, nota1);
        cadeira.cadastraNota(2, nota2);
        cadeira.cadastraNota(3, nota3);
        cadeira.cadastraNota(4, nota4);
        System.out.println(cadeira.toString());
    }

    /**
     * Função chamada quando o usuaria escrve "STATUS"
     * e passa horas de descanso quantidade de semanas
     * e um emoji que representa o estado do aluno na
     * mesma linha separado por espaço.
     * @param horas quantidade de horas de descanso.
     * @param semanas quantidade de semanas.
     * @param emoji emoji que representa o estado do aluno.
     */
    public static void descanso(int horas, int semanas, String emoji) {
        Descanso descanso = new Descanso();
        descanso.defineHorasDescanso(horas);
        descanso.defineNumeroSemanas(semanas);
        descanso.definirEmoji(emoji);
        System.out.println(descanso.getStatusGeral());
    }
}
