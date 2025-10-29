package com.pt.ejercicios;

import com.pt.arbolBinarioBusqueda.impl.ArbolBinarioBusquedaImpl;
import com.pt.arbolBinarioBusqueda.interfaces.ArbolBinarioBusqueda;
import com.pt.linkedList.interfaces.LinkedList;

/**
 * D. Conjunto con repetidos. Es un conjunto de duplas,
 * donde cada elemento tiene asociada una cantidad.
 */


public class MainABB {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusquedaImpl();
        System.out.println("=== Prueba Árbol Binario de Búsqueda ===");

        // Agregar elementos
        int[] elementos = {7, 5, 13, 3, 12, 15};
        for (int elem : elementos) {
            arbol.agregarElem(elem);
        }

        System.out.println("Recorrido in-order:");
        arbol.inOrder(arbol);

        System.out.println("\n\nRecorrido pre-order:");
        arbol.preOrder(arbol);

        System.out.println("\n\nRecorrido post-order:");
        arbol.postOrder(arbol);

        // Sumar nodos
        System.out.println("\nSumando nodos....");
        int sumatoriaNodos = arbol.sumarNodos();
        System.out.println("\nLa Suma de los nodos es: " + sumatoriaNodos);

        //Buscar mayor
        System.out.println("\nBuscando el mayor....");
        int mayor = arbol.mayorValor(arbol);
        System.out.println("\nEl mayor nodo es: " + mayor);

        //Buscar mayor
        System.out.println("\nBuscando el menor....");
        int menor = arbol.menorValor(arbol);
        System.out.println("\nEl mayor nodo es: " + menor);

        // Probar hojas
        System.out.println("\nHojas del árbol:");
        LinkedList hojas = ((ArbolBinarioBusquedaImpl) arbol).enlazarHojas();
        System.out.println(hojas);

        // Buscar Nodos internos
        System.out.println("\nRecolectando los nodos internos....");
        LinkedList nodosInternos = arbol.buscarNodosInternos();
        System.out.println(nodosInternos);

        // Mostrar nodos en niveles impares
        System.out.println("\nNodos de Niveles Impares...");
        arbol.imprimirNivelesImpares();
        System.out.println();

        // Probar eliminación
        System.out.println("\nEliminando 7...");
        arbol.eliminarElem(7);
        System.out.println("In-order después de eliminar 7:");
        arbol.inOrder(arbol);


    }
}
