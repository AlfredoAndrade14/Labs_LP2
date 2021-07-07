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
        while (true) {
            Scanner sc = new Scanner(System.in);
            String linha = sc.nextLine();
            String[] comando = linha.split(" ");

            if (comando[0].equals("TEMPOONLINE")) {
                registroOnline(comando[1], Integer.parseInt(comando[2]));
            } else if (comando[0].equals("DESPESA")) {
                financas(Integer.parseInt(comando[1]));
            } else if (comando[0].equals("NOTAS")) {
                disciplina(comando[1], Integer.parseInt(comando[2]), Integer.parseInt(comando[3]), Integer.parseInt(comando[4]), Integer.parseInt(comando[5]));
            } else if (comando[0].equals("STATUS")) {
                descanso(Integer.parseInt(comando[1]), Integer.parseInt(comando[2]),comando[3]);
            }
        }
    }

    private static void registroOnline(String nome, int tempo) {
        RegistroTempoOnline disciplina = new RegistroTempoOnline(nome);
        disciplina.adicionaTempoOnline(tempo);
        System.out.println(disciplina.toString());
    }

    private static void financas(int gasto) {
        RegistroFinancas minhaFinanca = new RegistroFinancas(10000, 4);
        minhaFinanca.pagaDespesa(gasto);
        System.out.println(minhaFinanca.toString());
    }

    private static void disciplina(String materia, int nota1 ,int nota2 , int nota3 , int nota4) {
        Disciplina cadeira = new Disciplina(materia);
        cadeira.cadastraNota(1, nota1);
        cadeira.cadastraNota(2, nota2);
        cadeira.cadastraNota(3, nota3);
        cadeira.cadastraNota(4, nota4);
        System.out.println(cadeira.toString());
    }

    public static void descanso(int horas, int semanas, String emoji) {
        Descanso descanso = new Descanso();
        descanso.defineHorasDescanso(horas);
        descanso.defineNumeroSemanas(semanas);
        descanso.definirEmoji(emoji);
        System.out.println(descanso.getStatusGeral());
    }
}
