package com.pt.colaDCircDobEnlaz.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Cola Dinámica Circular Doblemente Enlazada.
 * Una cola es una estructura de datos que sigue el principio FIFO
 * (First-In, First-Out) - primero en entrar, primero en salir.
 *
 * Precondición general: la cola debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface ColaDCircDobEnlaz {

    /**
     * Inicializa la cola.
     * Este método debe ser llamado antes de cualquier operación.
     *
     */
    void initialize();

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param x El elemento a agregar a la cola.
     */
    void add(int x);

    /**
     * Elimina el primer elemento de la cola (elemento más antiguo).
     *
     */
    void remove();

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El elemento más antiguo de la cola (primero en ser agregado).
     */
    int getFirst();

    /**
     * Obtiene el último elemento sin eliminarlo
     */
    public int getLast();
}
