import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* PoFnkEzvk
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Lista {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String linha = entrada.nextLine();
        String[] lista = linha.split(" ");
        int soma = 0;

        for(int a = 0; a < lista.length; a++) {
            soma += Integer.parseInt(lista[a]);
        }

        float media = (soma / (lista.length));
        
        for(int a = 0; a < lista.length; a++) {
            if (Integer.parseInt(lista[a]) > media) {
                System.out.print(Integer.parseInt(lista[a]));
                System.out.print(" ");
            }
        }
    }
}
