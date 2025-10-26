package com.pt.nodo.impl;

import com.pt.nodo.interfaces.NodoDobleRef;

public class NodoDobleRefImpl implements NodoDobleRef {

    private int info;
    private NodoDobleRef next;
    private NodoDobleRef prev;

    // Constructor
    public NodoDobleRefImpl() {
        this.next = null;
        this.prev = null;
    }

    /**
     * Le otorga el valor a guardar en ese nodo
     *
     * @param value : valor entero a guardar
     */
    @Override
    public void setInfo(int value) {
        this.info = value;
    }

    /**
     * Obtiene el valor alojado en ese nodo
     *
     * @return el valor entero alojado en el nodo
     */
    @Override
    public int getInfo() {
        return this.info;
    }

    /**
     * Establece el nodo siguiente
     *
     * @param next : el nodo siguiente
     */
    @Override
    public void setNext(NodoDobleRef next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    @Override
    public NodoDobleRef getNext() {
        return this.next;
    }

    /**
     * Obtiene el nodo previo
     *
     * @return el nodo previo si existe
     */
    @Override
    public NodoDobleRef getPrev() {
        return prev;
    }

    /**
     * Establece el nodo previo
     *
     * @param prev : el nodo previo
     */
    @Override
    public void setPrev(NodoDobleRef prev) {
        this.prev = prev;
    }
}
