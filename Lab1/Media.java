import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* QN9tFkXbc
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Media{
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        float num1 = entrada.nextFloat();
        float num2 = entrada.nextFloat();

        float media = (num1 + num2) / 2;

        if (media >= 7.0){
            System.out.println("pass: True!");
        } else {
            System.out.println("pass: False!");
        }
    }
}