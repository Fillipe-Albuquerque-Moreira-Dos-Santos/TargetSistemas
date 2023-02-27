package AvaliacaoTargetSistemas;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um número:");
        int n = sc.nextInt();
        sc.close();
        if (confirma(n)) {
            System.out.println(n + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(n + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean confirma(int n) {
        int a = 0, b = 1, c = 0;
        while (c < n) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == n;
    }
}

