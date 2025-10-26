package com.pt.nodo.interfaces;

public interface NodoDobleRef {

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
    void setNext(NodoDobleRef next);

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    NodoDobleRef getNext();

    /**
     * Obtiene el nodo previo
     *
     * @return el nodo previo si existe
     */
    public NodoDobleRef getPrev();

    /**
     * Establece el nodo previo
     *
     * @param prev : el nodo previo
     */
    public void setPrev(NodoDobleRef prev);
}
