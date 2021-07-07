import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* MP51Jj5V2
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Maiores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        String[] gastos = linha.split(" ");
        int maior = 0;
        int maior2 = 0;
        int a = 0;

        for (int i = 0; i < gastos.length; i++) {
            if (Integer.parseInt(gastos[i]) > maior) {
                maior = Integer.parseInt(gastos[i]);
                a = i;
            }
        }
        
        gastos[a] = "0";
        
        for (int x = 0; x < gastos.length; x++) {
            if (Integer.parseInt(gastos[x]) > maior2){
                maior2 = Integer.parseInt(gastos[x]);
            }
        }

        int soma = maior + maior2;
        System.out.print(soma);
    }
}
