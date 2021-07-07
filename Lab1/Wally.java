import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* SlfR6pBmC
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Wally {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String linha = entrada.nextLine();
        
        while (!(linha.equals("wally"))) {
            String nome = "?";
            String[] lista = linha.split(" ");
            
            for(int a = 0; a < lista.length; a++) {
                if (lista[a].length() == 5){
                    nome = lista[a];
                }
            }
            System.out.println(nome);
            linha = entrada.nextLine();
        }
    }
}