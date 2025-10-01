package com.pt.colaD.impl;

import com.pt.colaD.interfaces.ColaD;
import com.pt.nodo.impl.NodoImpl;
import com.pt.nodo.interfaces.Nodo;

/**
 * Cola dinamica (FIFO): Se agrega al final y se elimina desde el inicio
 */
public class ColaDImpl implements ColaD {

    Nodo first;     // Primer elemento de la cola
    Nodo last;      // Ultimo elemento de la cola (ultimo agregado)

    // Constructor
    public ColaDImpl() {
        this.initialize();
    }

    /**
     * Inicializa la cola.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.first = null;
        this.last = null;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param x El elemento a agregar a la cola.
     */
    @Override
    public void add(int x) {
        Nodo aux = new NodoImpl();
        aux.setInfo(x);
        aux.setNext(null);

        // Si la cola NO está vacía
        if (this.last != null) {
            this.last.setNext(aux); // El último actual apunta al nodo aux
        }

        this.last = aux;  // El nuevo nodo es el último

        // Si la cola está vacía
        if (this.first == null) {
            this.first = aux;   // Ambos apuntan al mismo nodo
        }
    }

    /**
     * Elimina el primer elemento de la cola (elemento más antiguo).
     */
    @Override
    public void remove() {
        // Avanzar first al siguiente nodo
        this.first = this.first.getNext();

        // Si después de remover la cola queda vacía
        if (this.first == null) {
            this.last = null;
        }
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El elemento más antiguo de la cola (primero en ser agregado).
     */
    @Override
    public int getFirst() {
        return this.first.getInfo();
    }

    /**
     * Metodo para visualizar la cola
     *
     * @return la cola legible
     */
    @Override
    public String toString() {
        if (this.first == null) {
            return "Cola vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cola[");
        Nodo actual = this.first;
        while (actual != null) {
            sb.append(actual.getInfo());
            if (actual.getNext() != null) {
                sb.append(" → ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
