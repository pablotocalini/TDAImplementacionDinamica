package com.pt.pilaD.impl;

import com.pt.nodo.impl.NodoImpl;
import com.pt.nodo.interfaces.Nodo;
import com.pt.pilaD.interfaces.PilaD;

public class PilaDImpl implements PilaD {

    private Nodo first;

    // Constructor vacío
    public PilaDImpl() {
        this.initialize();
    }

    /**
     * Inicializa la pila.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.first = null;
    }

    /**
     * Agrega un elemento al inicio (tope de la pila).
     *
     * @param x El elemento a apilar.
     */
    @Override
    public void add(int x) {
        Nodo nuevo = new NodoImpl();
        nuevo.setInfo(x);
        nuevo.setNext(this.first);
        this.first = nuevo; // El nuevo nodo ahora es el primero
    }

    /**
     * Elimina el elemento del tope de la pila.
     */
    @Override
    public void remove() {
        this.first = this.first.getNext();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return <code>true</code> si la pila no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Obtiene el elemento del tope de la pila sin eliminarlo.
     *
     * @return El elemento en el tope de la pila (último elemento apilado).
     */
    @Override
    public int getTop() {
        return this.first.getInfo();
    }

    /**
     * Representación en String de la pila
     */
    @Override
    public String toString() {
        if (this.first == null) {
            return "Pila vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Pila: tope → [");
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
