package com.pt.colaConPrioridadD.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Cola con Prioridad.
 * Precondición general: la cola debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface ColaConPrioridadD {

    /**
     * Inicializa la cola con prioridad.
     * Este método debe ser llamado antes de cualquier operación.
     */
    void initialize();

    /**
     * Agrega un elemento a la cola según su prioridad.
     *
     * @param num El valor a almacenar en la cola.
     * @param priority La prioridad del elemento (mayor valor indica mayor prioridad).
     */
    void add(int num, int priority);

    /**
     * Elimina el elemento de mayor prioridad de la cola.
     */
    void remove();

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el valor del elemento de mayor prioridad sin eliminarlo.
     *
     * @return El valor del elemento con mayor prioridad en la cola.
     */
    int getFirst();

    /**
     * Obtiene la prioridad del elemento de mayor prioridad sin eliminarlo.
     *
     * @return La prioridad del elemento con mayor prioridad en la cola.
     */
    int getPriority();
}

