package com.pt.nodo.interfaces;

/**
 * Interfaz que extiende Nodo para incluir funcionalidad de prioridad.
 * Para usar en Colas con Prioridad.
 */
public interface NodoConPrioridad extends Nodo {

    /**
     * Obtiene la prioridad del nodo.
     *
     * @return Valor de prioridad del nodo
     */
    int getPriority();

    /**
     * Establece la referencia al siguiente nodo con prioridad.
     *
     * @param next Siguiente nodo en la estructura (debe ser NodoConPrioridad)
     */
    void setNext(NodoConPrioridad next);

    /**
     * Obtiene la referencia al siguiente nodo con prioridad.
     *
     * @return Siguiente nodo en la estructura
     */
    NodoConPrioridad getNext();
}
