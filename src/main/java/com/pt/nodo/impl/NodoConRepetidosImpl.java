package com.pt.nodo.impl;

import com.pt.nodo.interfaces.NodoConRepetidos;

public class NodoConRepetidosImpl implements NodoConRepetidos {

    private int info;
    private int cantidad;
    private NodoConRepetidos next;

    // Constructor
    public NodoConRepetidosImpl() {
        this.next = null;
    }

    /**
     * Obtiene un N° entero que representa la cantidad de veces que se repite el valor de info
     * @return un N° entero
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de veces que se repite el valor de info
     * @param cantidad un N° entero
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    public void setNext(NodoConRepetidos next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    @Override
    public NodoConRepetidos getNext() {
        return this.next;
    }
}
