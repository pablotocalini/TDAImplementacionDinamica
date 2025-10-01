package com.pt.ejercicios;

import com.pt.MultipleDictionaryD.impl.MultipleDictionaryDImpl;
import com.pt.MultipleDictionaryD.interfaces.MultipleDictionaryD;
import com.pt.colaConPrioridadD.impl.ColaConPrioridadDImpl;
import com.pt.colaConPrioridadD.interfaces.ColaConPrioridadD;

/**
 * Punto 8: Tomar todos los elementos de una cola con prioridad e insertarlos en un diccionario múltiple, colocando las prioridades como “key” y los elementos que tengan esa prioridad como “value”.
 */

public class MainPunto8 {

    public static MultipleDictionaryD armarDiccionarioMultipleDeCola(ColaConPrioridadD colaConPrioridad) {
        MultipleDictionaryD diccionario = new MultipleDictionaryDImpl();

        while (!colaConPrioridad.isEmpty()) {
            diccionario.add(colaConPrioridad.getPriority(), colaConPrioridad.getFirst());
            colaConPrioridad.remove();
        }
        return diccionario;
    }

    public static void main(String[] args) {

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

        // Metodo para pasar de una cola con prioridad a a un diccionario multiple
        MultipleDictionaryD diccionarioMultiple = armarDiccionarioMultipleDeCola(colaConPrioridad);

        // Mostrar el resultado
        if (diccionarioMultiple.getKeys() != null) {
            System.out.println("Diccionario Múltiple: " + diccionarioMultiple.toString());
        }  else {
            System.out.println(diccionarioMultiple.toString());
        }
    }
}