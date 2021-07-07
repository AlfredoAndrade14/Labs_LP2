/**
* Laboratório de Programação 2 - Lab 1
* R7qL9alKS
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String op = entrada.nextLine();
        
        if (op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-")) {
            float num1 = entrada.nextFloat();
            float num2 = entrada.nextFloat();
            float calc;
            
            switch (op) {
                case "*":
                    calc = num1 * num2;
                    break;
                case "+":
                    calc = num1 + num2;
                    break;
                case "-":
                    calc = num1 - num2;
                    break;
                default:
                    if (num2 == 0){
                        System.out.print("ERRO");
                        return;
                    } else {
                        calc = num1 / num2;
                    }

            }
            
            System.out.printf("RESULTADO: %.1f",calc);
            
        } else{
            System.out.print("ENTRADA INVALIDA");
        }
    }

}