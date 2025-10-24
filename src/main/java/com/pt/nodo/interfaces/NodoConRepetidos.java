package com.pt.nodo.interfaces;

public interface NodoConRepetidos {

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
    void setNext(NodoConRepetidos next);

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    NodoConRepetidos getNext();

    /**
     * Obtiene un N° entero que representa la cantidad de veces que se repite el valor de info
     * @return un N° entero
     */
    public int getCantidad();

    /**
     * Establece la cantidad de veces que se repite el valor de info
     * @param cantidad un N° entero
     */
    public void setCantidad(int cantidad);
}
