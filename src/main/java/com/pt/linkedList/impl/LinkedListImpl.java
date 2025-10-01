package com.pt.linkedList.impl;

import com.pt.linkedList.interfaces.LinkedList;
import com.pt.nodo.impl.NodoImpl;
import com.pt.nodo.interfaces.Nodo;

public class LinkedListImpl implements LinkedList {

    private Nodo head;  // Apunta al primer elemento
    private Nodo tail;  // Apunta al ultimo elemento
    private int size;   // Tamaño de la lista


    // Constructor
    public LinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * Agregar un elemento en la última posicion.
     *
     * @param value contiene el valor a guardar en la ultima posicion.
     */
    @Override
    public void add(int value) {
        // Creo un nuevo objeto nodo y le asigno el valor
        Nodo newNodo = new NodoImpl();
        newNodo.setInfo(value);

        if (this.head == null) {    // Lista vacía
            this.head = newNodo;
        }  else {
            this.tail.setNext(newNodo);
        }
        this.tail = newNodo;
        this.size++;
    }

    /**
     * Metodo para eliminar un valor
     *
     * @param value a eliminar
     */
    @Override
    public void remove(int value) {
        if (this.head != null) {
            Nodo previous = null;
            Nodo current = this.head;

            // Busco el elemento a eliminar
            while (current != null && current.getInfo() != value) {
                previous = current;
                current = current.getNext();
            }

            // Sí encontramos el elemento, lo elimino
            if (current != null) {
                if (previous == null) {
                    // Elimino el primer elemento
                    this.head = this.head.getNext();
                } else {
                    // Elimino el elemento del medio o final
                    previous.setNext(current.getNext());
                }

                // Actualizo tail si elimino el último
                if (current == this.tail) {
                    this.tail = previous;
                }

                this.size--;

                // Si la lista quedó vacía
                if (this.head == null) {
                    this.tail = null;
                }
            }
        }
    }

    /**
     * Metodo para buscar si un valor existe
     *
     * @param value a encontrar
     * @return el nodo encontrado o null
     */
    @Override
    public Nodo exist(int value) {
        Nodo aux;

        aux = this.head.getNext();
        while (aux != null) {
            if (aux.getInfo() == value) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    /**
     * Metodo para buscar el tamaño
     *
     * @return el tamaño de la lista
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Metodo para saber si está vacía
     *
     * @return <code>true</code> si la lista no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "LinkedList vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: [");

        Nodo current = this.head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(" → ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
