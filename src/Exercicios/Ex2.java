package Exercicios;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Scanner;

public class Ex2 {



    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Bem-vindo ao formatador de telefone!");
        System.out.println(" ");
        System.out.println("Telefone fixo ( 8 dígitos sem DDD xxxx-xxxx, 10 dígitos com DDD (xx)xxxx-xxxx )");
        System.out.println("================================");
        System.out.println("Celular ( 9 dígitos sem DDD xxxxx-xxxx, 11 dígitos (xx)xxxxx-xxxx )");
        System.out.println(" ");
        System.out.println("DIGITE APENAS NÚMEROS");
        System.out.println(" ");

        System.out.println("Digite seu número de telefone: ");



        String value = scanner.nextLine();

        formattedPhone(value);

    }


    public static void formattedPhone(String input) throws ParseException {

        if (input.length() == 11) {
            MaskFormatter phoneFormatter = new MaskFormatter("(##) #####-####");
            JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
            txtPhone.setText(input);
            System.out.println("Celular com DDD: " + txtPhone.getText());
        }

        else if (input.length() == 9) {
            MaskFormatter phoneFormatter = new MaskFormatter("#####-####");
            JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
            txtPhone.setText(input);
            System.out.println("Celular sem DDD: " + txtPhone.getText());
        }

        else if (input.length() == 10) {
            MaskFormatter phoneFormatter = new MaskFormatter("(##) ####-####");
            JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
            txtPhone.setText(input);
            System.out.println("Telefone com DDD: " + txtPhone.getText());
        }

        else if (input.length() == 8) {
            MaskFormatter phoneFormatter = new MaskFormatter("####-####");
            JFormattedTextField txtPhone = new JFormattedTextField(phoneFormatter);
            txtPhone.setText(input);
            System.out.println("Telefone sem DDD: " + txtPhone.getText());
        }

        else {
            System.out.println("não se trata de um número válido");
        }


    }

}
