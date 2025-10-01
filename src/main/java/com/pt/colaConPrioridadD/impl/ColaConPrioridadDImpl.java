package com.pt.colaConPrioridadD.impl;

import com.pt.colaConPrioridadD.interfaces.ColaConPrioridadD;
import com.pt.nodo.impl.NodoConPrioridadImpl;
import com.pt.nodo.interfaces.NodoConPrioridad;

public class ColaConPrioridadDImpl implements ColaConPrioridadD {

    NodoConPrioridad highPriorityNode;

    // Constructor
    public ColaConPrioridadDImpl() {
        this.initialize();
    }

    /**
     * Inicializa la cola con prioridad con una capacidad específica.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.highPriorityNode = null;
    }

    /**
     * Agrega un elemento a la cola según su prioridad.
     *
     * @param num      El valor a almacenar en la cola.
     * @param priority La prioridad del elemento (mayor valor indica mayor prioridad).
     */
    @Override
    public void add(int num, int priority) {
        NodoConPrioridad newNode = new NodoConPrioridadImpl(num, priority);

        // Si la cola está vacía o tiene mayor prioridad
        if (highPriorityNode == null || priority > highPriorityNode.getPriority()) {
           newNode.setNext(highPriorityNode);
           highPriorityNode = newNode;
        }  else {       // Si la cola no está vacía o el elemento tiene < prioridad que el de mayor prioridad en la cola
            NodoConPrioridad aux = highPriorityNode;
            // Chequeo si el nodo sig. al de > prioridad no está vacío y el siguiente tenga mayor o igual prioridad que el nuevo nodo a ingresar
            while (aux.getNext() != null && aux.getNext().getPriority() >= priority) {
                aux = aux.getNext();    // Voy pasando de nodo en nodo
            }
            // Cuando encuentro el lugar que corresponde según prioridad
            newNode.setNext(aux.getNext()); // asigno la referencia al nodo vacío o con menor prioridad
            aux.setNext(newNode);   // cambio la referencia del nodo siguiente desde un nodo con más prioridad que el que quiero agregar
        }
    }

    /**
     * Elimina el elemento de mayor prioridad de la cola.
     */
    @Override
    public void remove() {
        this.highPriorityNode = this.highPriorityNode.getNext();
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.highPriorityNode == null;
    }

    /**
     * Obtiene el valor del elemento de mayor prioridad sin eliminarlo.
     *
     * @return El valor del elemento con mayor prioridad en la cola.
     */
    @Override
    public int getFirst() {
        return this.highPriorityNode.getInfo();
    }

    /**
     * Obtiene la prioridad del elemento de mayor prioridad sin eliminarlo.
     *
     * @return La prioridad del elemento con mayor prioridad en la cola.
     */
    @Override
    public int getPriority() {
        return this.highPriorityNode.getPriority();
    }

    /**
     * Representación en String de la cola con prioridad
     * Muestra los elementos en formato: (valor: prioridad)
     */
    @Override
    public String toString() {
        if (this.highPriorityNode == null) {
            return "Cola Con Prioridad vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cola Con Prioridad: [");

        NodoConPrioridad actual = this.highPriorityNode;
        while (actual != null) {
            // formato (valor: prioridad)
            sb.append("(").append(actual.getInfo()).append(": p ").append(actual.getPriority()).append(")");

            if (actual.getNext() != null) {
                sb.append(" → ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
