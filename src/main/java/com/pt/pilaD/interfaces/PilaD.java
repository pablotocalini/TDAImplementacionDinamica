package com.pt.pilaD.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Pila.
 * Una pila es una estructura de datos que sigue el principio LIFO
 * (Last-In, First-Out) - último en entrar, primero en salir.
 *
 * Precondición general: la pila debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface PilaD {

    /**
     * Inicializa la pila.
     * Este método debe ser llamado antes de cualquier operación.Debe ser un valor positivo mayor que cero.
     */
    void initialize();

    /**
     * Agrega un elemento al inicio (tope de la pila).
     *
     * @param x El elemento a apilar.
     */
    void add(int x);

    /**
     * Elimina el elemento del tope de la pila.
     */
    void remove();

    /**
     * Verifica si la pila está vacía.
     *
     * @return <code>true</code> si la pila no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el elemento del tope de la pila sin eliminarlo.
     *
     * @return El elemento en el tope de la pila (último elemento apilado).
     */
    int getTop();
}
