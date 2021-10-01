import java.util.Scanner;
/**
* Laboratório de Programação 2 - Lab 1
* Q36VouKXo
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Voo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int objetivo = Integer.parseInt(sc.nextLine());
        int difP;

        int altura = Integer.parseInt(sc.nextLine());
        difP = Math.abs(objetivo - altura);

        while (true){    
            altura = Integer.parseInt(sc.nextLine());
            int difA = Math.abs(objetivo - altura);

            if (difA == 0){break;}

            if (difA < difP) {
                System.out.println("ADEQUADO");
            } else {
                System.out.println("PERIGO");
            }
            difP = difA;
        }

        System.out.println("OK");
    }
}