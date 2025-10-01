package com.pt.nodo.interfaces;

public interface Nodo {

    /**
     * Le otorga el valor a guardar en ese nodo
     *
     * @param value: valor entero a guardar
     */
    void setInfo(int value);

    /**
     * Obtiene el valor alojado en ese nodo
     *
     * @return el valor entero alojado en el nodo
     */
    int getInfo();

    /**
     * Establece el nodo siguiente
     *
     * @param next: el nodo siguiente
     */
    void setNext(Nodo next);

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    Nodo getNext();
}
