package AvaliacaoTargetSistemas;

import java.util.Scanner;

public class InversaoString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String str = scanner.nextLine();
        scanner.close();
        
        char[] caracteres = str.toCharArray();
        int tamanho = caracteres.length;
        
        for (int i = 0; i < tamanho/2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[tamanho-1-i];
            caracteres[tamanho-1-i] = temp;
        }
        
        String strInvertida = new String(caracteres);
        System.out.println("String invertida: " + strInvertida);
    }
}
