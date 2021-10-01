import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* QCT9g3lJ2
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class DobroTriplo{
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();

        int dobro = num * 2;
        int triplo = num * 3;

        System.out.print("dobro: " + dobro + ", triplo: "+ triplo);
    }
}