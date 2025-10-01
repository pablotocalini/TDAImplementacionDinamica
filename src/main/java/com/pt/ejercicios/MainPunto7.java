package com.pt.ejercicios;

import com.pt.colaD.impl.ColaDImpl;
import com.pt.colaD.interfaces.ColaD;
import com.pt.simpleDictionaryD.impl.SimpleDictionaryDImpl;
import com.pt.simpleDictionaryD.interfaces.SimpleDictionaryD;

/**
 * Punto 7: Tomar todos los elementos de una cola e insertarlos en un diccionario simple, colocando el elemento como “key” y su posición en la cola como “value”.
 */

public class MainPunto7 {

    public static SimpleDictionaryD armarDiccionarioDeCola(ColaD cola) {
        SimpleDictionaryD diccionario = new SimpleDictionaryDImpl();
        int contador = 0;

        while (!cola.isEmpty()) {
            contador++;
            diccionario.add(cola.getFirst(), contador);
            cola.remove();
        }
        return diccionario;
    }

    public static void main(String[] args) {

        // Creo la cola
        ColaD cola = new ColaDImpl();

        // Agrego valores
        cola.add(5);
        cola.add(3);
        cola.add(4);
        cola.add(8);
        cola.add(10);
        cola.add(6);

        // Muestro la Cola
        System.out.println(cola.toString());

        // Metodo para pasar de una cola a un diccionario
        SimpleDictionaryD diccionario = armarDiccionarioDeCola(cola);

        // Mostrar el resultado
        if (diccionario.setOfKeys() != null) {
            System.out.println("Diccionario: " + diccionario.toString());
        }  else {
            System.out.println(diccionario.toString());
        }
    }
}