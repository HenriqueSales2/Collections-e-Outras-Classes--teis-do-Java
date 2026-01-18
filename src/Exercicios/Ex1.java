package Exercicios;

import java.util.Scanner;

public class Ex1 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        soma(10, 20);
        System.out.println("==========");
        subtracao(10, 20);

    }

    private static void soma(double number, double number2) {
        double result = number + number2;
        System.out.printf("O resultado da soma %s + %s é igual à %s\n", number, number2, result);
    }

    private static void subtracao(double number, double number2) {
        double result = number - number2;
        if (result < 0) {
            System.out.println("Seu resultado é negativo!");
            System.out.printf("O resultado da subtração %s - %s é igual à %s\n", number, number2, result);

        } else if(result >= 0) {
            System.out.printf("O resultado da subtração %s - %s é igual à %s\n", number, number2, result);
        }

        else {
            System.out.println("ERRO");
        }
    }
}
