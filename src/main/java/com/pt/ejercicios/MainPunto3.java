package com.pt.ejercicios;

import com.pt.linkedList.impl.LinkedListImpl;
import com.pt.linkedList.interfaces.LinkedList;
import com.pt.pilaD.impl.PilaDImpl;
import com.pt.pilaD.interfaces.PilaD;

/**
 * Punto 3: Desapilar todos los elementos de una pila y devolverlos en una lista enlazada.
 */

public class MainPunto3 {

    public static void desapilar(PilaD pila, LinkedList lista) {

        // Desapilar mientras haya un valor en la pila
        while (!pila.isEmpty()) {
            lista.add(pila.getTop());   // Guarda el valor en la lista
            pila.remove();
        }
    }

    public static void main(String[] args) {

        // Creamos la pila y la llenamos
        PilaD pila = new PilaDImpl();

        pila.add(1);
        pila.add(2);
        pila.add(3);
        pila.add(4);
        pila.add(5);

        // Creamos la lista
        LinkedList lista = new LinkedListImpl();

        //Mostramos la pila y la lista
        System.out.println("Antes de desapilar");
        System.out.println(pila.toString());
        System.out.println(lista.toString());
        System.out.println();

        //Metodo para desapilar y pasar a una lista
        desapilar(pila, lista);

        //Mostramos la pila y la lista
        System.out.println("Luego de desapilar");
        System.out.println(pila.toString());
        System.out.println(lista.toString());

    }
}