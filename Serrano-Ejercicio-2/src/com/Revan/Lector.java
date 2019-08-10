package com.Revan;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lector{
    public static int solicitarEntero(String mensaje){
        Scanner lector= new Scanner(System.in);
        System.out.printf(mensaje);
        try{
            int numero= lector.nextInt();
            return numero;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarEntero(mensaje);
        }
    }
    public static String solicitarString(String mensaje){
        System.out.printf(mensaje);
        Scanner lector= new Scanner(System.in);
        try {
            String palabra= lector.nextLine();
            return palabra;
        } catch (InputMismatchException e){
            System.out.println("El dato ingresado no valido");
            return solicitarString(mensaje);
        }

    }
}