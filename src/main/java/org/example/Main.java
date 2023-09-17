package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_PROCESOS = 50;
        Cola<Proceso> cola = new Cola<Proceso>();

        for(int i = 0; i < NUM_PROCESOS; i++){
            cola.addToCola(new Proceso());
        }

        while (!cola.isEmpty()){
            Proceso proceso = cola.extract();
            System.out.println("Proceso " + proceso.toString());
        }
    }
}