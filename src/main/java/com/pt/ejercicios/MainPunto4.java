package com.pt.ejercicios;

import com.pt.colaD.impl.ColaDImpl;
import com.pt.colaD.interfaces.ColaD;

import java.util.Scanner;

/**
 * Punto 4: Encontrar un elemento (dado como entrada) en una cola.
 */

public class MainPunto4 {

    public static int encontrarElemento(ColaD cola, int elemento) {
        // Variables banderas
        int contador = 0;
        int posicion = -1;

        while (!cola.isEmpty()) {
            contador++;
            if (cola.getFirst() == elemento) {
                posicion = contador;
            }
            cola.remove();
        }
        return posicion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo la cola
        ColaD cola = new ColaDImpl();

        // Agrego valores
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);
        cola.add(6);

        // Muestro la Cola
        System.out.println(cola.toString());

        // Pido el elmento a buscar
        System.out.print("Ingrese el N° a buscar en la cola: ");

        // Lectura del valor ingresado.
        int input = scanner.nextInt();

        // Metodo para encontrar un elemento dado
        int posicionDeElemento = encontrarElemento( cola, input);

        // Mostrar el resultado
        if (posicionDeElemento != -1) {
            System.out.println("El elemento " + input + " está en la posición " + posicionDeElemento );
        }  else {
            System.out.println("El elemento " + input + " no existe en la cola");
        }
    }
}