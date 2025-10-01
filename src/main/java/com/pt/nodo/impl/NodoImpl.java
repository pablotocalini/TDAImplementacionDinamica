package com.pt.nodo.impl;

import com.pt.nodo.interfaces.Nodo;

public class NodoImpl implements Nodo {

    private int info;
    private Nodo next;

    // Constructor
    public NodoImpl() {
        this.next = null;
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
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    @Override
    public Nodo getNext() {
        return this.next;
    }
}
