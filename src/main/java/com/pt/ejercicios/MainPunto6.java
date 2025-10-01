package com.pt.ejercicios;

import com.pt.conjuntoD.impl.ConjuntoDImpl;
import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.linkedList.impl.LinkedListImpl;
import com.pt.linkedList.interfaces.LinkedList;

/**
 * Punto 6: Encontrar todos los elementos que comparten 2 conjuntos C1 y C2 (la intersección de conjuntos).
 */

public class MainPunto6 {

    public static LinkedList encontrarInterseccion(ConjuntoD conjunto1, ConjuntoD conjunto2) {
        LinkedList listaElementos = new LinkedListImpl();

        while (!conjunto1.isEmpty()) {
            int value = conjunto1.choose();
            if (conjunto2.belongs(value)) {
                listaElementos.add(value);
            }
            conjunto1.remove(value);
        }
        return listaElementos;
    }

    public static void main(String[] args) {

        // Creo los conjuntos
        ConjuntoD conjunto1 = new ConjuntoDImpl();
        ConjuntoD conjunto2 = new ConjuntoDImpl();

        // Agrego valores
        conjunto1.add(1);
        conjunto1.add(2);
        conjunto1.add(3);
        conjunto1.add(4);

        conjunto2.add(1);
        conjunto2.add(2);
        conjunto2.add(5);
        conjunto2.add(6);

        // Muestro los Conjuntos
        System.out.println("Conjunto 1: " + conjunto1.toString());
        System.out.println("Conjunto 2: " + conjunto2.toString());

        // Metodo para encontrar la interseccion de 2 conjuntos
        LinkedList interseccion = encontrarInterseccion(conjunto1, conjunto2);

        // Mostrar el resultado
        if (!interseccion.isEmpty()) {
            System.out.println("Los elementos que comparten los 2 conjuntos son: " + interseccion.toString());
        }  else {
            System.out.println("No hay Elementos en común entre los dos conjuntos");
        }
    }
}