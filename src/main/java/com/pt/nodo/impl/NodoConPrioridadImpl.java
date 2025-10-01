package com.pt.nodo.impl;

import com.pt.nodo.interfaces.Nodo;
import com.pt.nodo.interfaces.NodoConPrioridad;

/**
 * Implementación de un nodo con prioridad para estructuras de datos ordenadas.
 * Cada nodo contiene un valor, una prioridad y referencia al siguiente nodo.
 */
public class NodoConPrioridadImpl implements NodoConPrioridad {

    private int info;
    private int priority;
    private NodoConPrioridad next;

    /**
     * Constructor por defecto.
     * Inicializa el nodo con next en null.
     */
    public NodoConPrioridadImpl() {
        this.next = null;
    }

    /**
     * Constructor con valores iniciales.
     *
     * @param info Valor a almacenar en el nodo
     * @param priority Prioridad del nodo
     */
    public NodoConPrioridadImpl(int info, int priority) {
        this.info = info;
        this.priority = priority;
        this.next = null;
    }

    // Implementación de métodos de la interfaz Nodo

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
     * Establece el siguiente nodo.
     * Realiza casting a NodoConPrioridad para mantener consistencia de tipos.
     *
     * @param next : el nodo siguiente
     */
    @Override
    public void setNext(Nodo next) {
        this.next = (NodoConPrioridad) next;
    }

    /**
     * Obtiene la referencia al siguiente nodo con prioridad.
     *
     * @return Siguiente nodo en la estructura
     */
    @Override
    public NodoConPrioridad getNext() {
        return this.next;
    }

    // Implementación de métodos de la interfaz NodoConPrioridad

    /**
     * Obtiene la prioridad del nodo.
     *
     * @return Valor de prioridad del nodo
     */
    @Override
    public int getPriority() {
        return this.priority;
    }

    // Métodos específicos para NodoConPrioridad

    /**
     * Establece la referencia al siguiente nodo con prioridad.
     *
     * @param next Siguiente nodo en la estructura (debe ser NodoConPrioridad)
     */
    @Override
    public void setNext(NodoConPrioridad next) {
        this.next = next;
    }

    /**
     * Representación en String del nodo.
     *
     * @return String con formato "(valor: prioridad)"
     */
    @Override
    public String toString() {
        return "(" + this.info + ": " + this.priority + ")";
    }

}
