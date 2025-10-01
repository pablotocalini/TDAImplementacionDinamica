package com.pt.linkedList.interfaces;

import com.pt.nodo.interfaces.Nodo;

public interface LinkedList {

    /**
     * Agregar un elemento en la última posicion.
     *
     * @param value contiene el valor a guardar en la ultima posicion.
     */
    void add(int value);

    /**
     * Metodo para eliminar un valor
     *
     * @param value a eliminar
     */
    void remove(int value);

    /**
     * Metodo para buscar si un valor existe
     *
     * @param value a encontrar
     * @return el nodo encontrado o null
     */
    Nodo exist(int value);

    /**
     * Metodo para buscar el tamaño
     *
     * @return el tamaño de la lista
     */
    int size();

    /**
     * Metodo para saber si está vacía
     *
     * @return <code>true</code> si la lista no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();
}
