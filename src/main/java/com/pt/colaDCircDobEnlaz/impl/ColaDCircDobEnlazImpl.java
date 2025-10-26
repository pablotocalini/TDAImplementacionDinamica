package com.pt.colaDCircDobEnlaz.impl;

import com.pt.colaDCircDobEnlaz.interfaces.ColaDCircDobEnlaz;
import com.pt.nodo.impl.NodoDobleRefImpl;
import com.pt.nodo.interfaces.NodoDobleRef;

public class ColaDCircDobEnlazImpl implements ColaDCircDobEnlaz {

    NodoDobleRef firstNode;
    NodoDobleRef lastNode;
    int size;

    public ColaDCircDobEnlazImpl() {
        this.initialize();
    }


    /**
     * Inicializa la cola.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param x El elemento a agregar a la cola.
     */
    @Override
    public void add(int x) {
        // creo un nuevo nodo y le asigno el valor
        NodoDobleRef newNode = new NodoDobleRefImpl();
        newNode.setInfo(x);

        // Caso en que esté vacía la cola
        if(this.isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            this.lastNode = newNode;
            this.firstNode = newNode;
        } else {
            // Insertar al final (después de lastNode)
            newNode.setNext(this.firstNode);    // para que sea cíclico, el último apunta al primero
            newNode.setPrev(this.lastNode);     // El anterior es el que era último

            this.lastNode.setNext(newNode);     // el que era último, apunta al nuevo ultimo
            this.firstNode.setPrev(newNode);    // para que sea cíclico, el primero apunta al último

            this.lastNode = newNode;            // Actualizar el último
        }
        this.size++;
    }

    /**
     * Elimina el primer elemento de la cola (elemento más antiguo).
     */
    @Override
    public void remove() {
        if(this.isEmpty()) { // Cola vacía
            throw new IllegalStateException("No se puede eliminar, la cola está vacía");

        } else if(this.size == 1) { // Si hay sólo un elemento
            this.firstNode = null;
            this.lastNode = null;

        } else {
            // Avanzar el firstNode
            NodoDobleRef nuevoPrimero = this.firstNode.getNext();

            // Reconectar circularidad
            nuevoPrimero.setPrev(this.lastNode);    // Uno el Nuevo primero al último
            this.lastNode.setNext(nuevoPrimero);    // Uno el último al nuevo primero

            this.firstNode = nuevoPrimero;          // Actualizo el firstNode
        }

        this.size--;    // disminuir el contador
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El elemento más antiguo de la cola (primero en ser agregado).
     */
    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("No se puede obtener el primer valor: la cola está vacía");
        }
        return this.firstNode.getInfo();
    }

    /**
     * Obtiene el último elemento sin eliminarlo
     */
    @Override
    public int getLast() {
        if (this.isEmpty()) {
            throw new IllegalStateException("No se puede obtener el último valor: la cola está vacía");
        }
        return this.lastNode.getInfo();
    }

    /**
     * Representación
     */
    @Override
    public String toString() {
        if (this.isEmpty()) return "Cola vacía";

        StringBuilder sb = new StringBuilder();
        sb.append("Cola circular [").append(size).append("]: ");

        NodoDobleRef actual = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            sb.append(actual.getInfo());
            if (i < this.size - 1) sb.append(" ⇄ ");
            actual = actual.getNext();
        }
        sb.append(" (cíclica)");
        return sb.toString();
    }
}
