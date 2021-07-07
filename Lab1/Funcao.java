/**
* Laboratório de Programação 2 - Lab 1
* O74TDGIEa
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
import java.util.Scanner;
public class Funcao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1 = entrada.nextInt();
        int num2 = entrada.nextInt();
        int num3 = entrada.nextInt();
        int num4 = entrada.nextInt();

        if(num1 > num2 && num2 > num3 && num3 > num4){
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        } else if (num1 < num2 && num2 < num3 && num3 < num4) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        } else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }

    }
}
