package com.pt.pilaD.impl;

import com.pt.nodo.impl.NodoImpl;
import com.pt.nodo.interfaces.Nodo;
import com.pt.pilaD.interfaces.PilaD;

public class PilaDConLimiteImpl implements PilaD {

    private Nodo first;
    private int contador;
    private final int capacidadMaxima;

    // Constructor
    public PilaDConLimiteImpl(int capacidadMaxima) {
        if(capacidadMaxima <= 0) {
            throw new IllegalStateException("La capacidad debe ser mayor a cero");
        }
        this.initialize();
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Inicializa la pila.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.first = null;
        this.contador = 0;
    }

    /**
     * Agrega un elemento al inicio (tope de la pila).
     *
     * @param x El elemento a apilar.
     */
    @Override
    public void add(int x) {
        if(this.contador >= capacidadMaxima) {
            throw new IllegalStateException("Pila llena, no se pueden agregar más elementos. Capacidad máxima: " + this.capacidadMaxima);
        } else {
            Nodo nuevo = new NodoImpl();
            nuevo.setInfo(x);
            nuevo.setNext(this.first);
            this.first = nuevo; // El nuevo nodo ahora es el primero
            this.contador++;
        }
    }

    /**
     * Elimina el elemento del tope de la pila.
     */
    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new IllegalStateException("Pila vacia, no se puede desapilar");
        } else {
            this.first = this.first.getNext();
            this.contador--;
        }
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
        if(this.isEmpty()) {
            throw new IllegalStateException("Pila vacia");
        } else {
            return this.first.getInfo();
        }
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
