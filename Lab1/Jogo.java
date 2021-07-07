import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* PmZq7rg1I
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Jogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        String tentativa = sc.nextLine();

        while (Integer.parseInt(tentativa) != Integer.parseInt(numero)) {
            if (Integer.parseInt(tentativa) > Integer.parseInt(numero)) {
                System.out.println("MAIOR");
            } else if (Integer.parseInt(tentativa) < Integer.parseInt(numero)) {
                System.out.println("MENOR");
            }

            tentativa = sc.nextLine();
        }
        System.out.println("ACERTOU");
    }
}
