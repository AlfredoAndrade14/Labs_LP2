import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
/**
* Laboratório de Programação 2 - Lab 1
* QIXAfeChM
* @author Alfredo Vasconcelos de Andrade - 120210139
*/
public class Consulta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String linha = sc.nextLine();
        String[] mes = linha.split(" ");

        String linha2 = sc.nextLine();
        String[] valor = linha2.split(" ");

        Map<String, String> dic = new HashMap<String, String>();

        for (int i = 0; i < mes.length; i++) {
            dic.put(mes[i], valor[i]);
        }

        String consulta = sc.nextLine();
        System.out.print(dic.get(consulta));
    }
}
