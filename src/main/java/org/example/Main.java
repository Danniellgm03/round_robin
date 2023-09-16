package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cola<Proceso> cola = new Cola<Proceso>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de procesos");
        int numProcesos = scanner.nextInt();
        for(int i = 0; i < numProcesos; i++){
            cola.addToCola(new Proceso());
        }

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        System.out.println(cola.toString());
        while (!cola.isEmpty()){
            cola.sort();
            Proceso proceso = cola.sacar();
            System.out.println("Proceso " + proceso.toString());
        }
    }
}