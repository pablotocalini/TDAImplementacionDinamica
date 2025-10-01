package com.pt.ejercicios;

import com.pt.colaConPrioridadD.impl.ColaConPrioridadDImpl;
import com.pt.colaConPrioridadD.interfaces.ColaConPrioridadD;
import com.pt.linkedList.impl.LinkedListImpl;
import com.pt.linkedList.interfaces.LinkedList;

import java.util.Scanner;

/**
 * Punto 5: Encontrar todos los elementos que posean una prioridad x en una cola con prioridad.
 */

public class MainPunto5 {

    public static LinkedList encontrarElementoConPrioridad(ColaConPrioridadD cola, int prioridad) {
        LinkedList listaElementos = new LinkedListImpl();

        while (!cola.isEmpty()) {
            if (cola.getPriority() == prioridad) {
                listaElementos.add(cola.getFirst());
            }
            cola.remove();
        }
        return listaElementos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo la cola con prioridad
        ColaConPrioridadD colaConPrioridad = new ColaConPrioridadDImpl();

        // Agrego valores
        colaConPrioridad.add(1, 4);
        colaConPrioridad.add(2, 3);
        colaConPrioridad.add(3, 2);
        colaConPrioridad.add(4, 1);
        colaConPrioridad.add(5, 1);
        colaConPrioridad.add(6, 1);
        colaConPrioridad.add(7, 2);

        // Muestro la Cola
        System.out.println(colaConPrioridad.toString());


        // Pido el elmento a buscar
        System.out.print("Ingrese la Prioridad a buscar en la cola: ");

        // Lectura del valor ingresado.
        int prioridad = scanner.nextInt();

        // Metodo para encontrar un elemento dado
        LinkedList elementos = encontrarElementoConPrioridad(colaConPrioridad, prioridad);

        // Mostrar el resultado
        if (!elementos.isEmpty()) {
            System.out.println("Elementos con la prioridad " + prioridad + ": " + elementos.toString());
        }  else {
            System.out.println("No hay Elementos con esa prioridad");
        }
    }
}