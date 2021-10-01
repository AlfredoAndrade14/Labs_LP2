import java.util.Scanner;
import java.util.ArrayList;
/**
* Laboratório de Programação 2 - Lab 1
* NIGzVIuci
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Notas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String linha = entrada.nextLine();
        
        ArrayList<Integer> notas = new ArrayList();
        int notaMaior = 0;
        int notaMenor = 1000;
        int media = 0;
        int maior = 0;
        int menor = 0;
        
        while (!(linha.equals("-"))) {
            String[] aluno = linha.split(" ");
            int nota = Integer.parseInt(aluno[1]);
            media += nota;
            notas.add(nota);
            
            if (nota < notaMenor) { 
                notaMenor = nota; 
            } 
            if(nota > notaMaior){ 
                notaMaior = nota; 
            }       
            
            linha = entrada.nextLine();
        }

        media /= Math.floor(notas.size());

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i) >= 700) {
                maior++;
            } else {
                menor++;
            }
        }

        System.out.println("maior: " + notaMaior);
        System.out.println("menor: " + notaMenor);
        System.out.println("media: " + media);
        System.out.println("acima: " + maior);
        System.out.println("abaixo: " + menor);
    }
}
