package com.pt.conjuntoD.impl;

import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.nodo.impl.NodoImpl;
import com.pt.nodo.interfaces.Nodo;

public class ConjuntoDImpl implements ConjuntoD {

    private Nodo conjunto;

    // Constructor
    public ConjuntoDImpl() {
        this.initialize();
    }

    /**
     * Inicializa el conjunto.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.conjunto = null;
    }

    /**
     * Agrega un elemento al conjunto si no existe previamente.
     * Si el elemento ya existe en el conjunto, la operación no tiene efecto.
     *
     * @param value El elemento a agregar al conjunto.
     */
    @Override
    public void add(int value) {
        if (!this.belongs(value)) {
            Nodo newConjunto = new NodoImpl();
            newConjunto.setInfo(value);
            newConjunto.setNext(this.conjunto);
            this.conjunto = newConjunto;
        }
    }

    /**
     * Verifica si un elemento pertenece al conjunto.
     *
     * @param value El elemento a verificar.
     * @return <code>true</code> si el elemento existe en el conjunto, <code>false</code> en caso contrario.
     */
    @Override
    public boolean belongs(int value) {
        Nodo aux = this.conjunto;
        while (aux != null && aux.getInfo() != value) {
            aux = aux.getNext();
        }
        return aux != null;
    }

    /**
     * Elimina un elemento del conjunto.
     * Si el elemento no existe en el conjunto, la operación no tiene efecto.
     *
     * @param value El elemento a eliminar del conjunto.
     */
    @Override
    public void remove(int value) {
        // Chequeo si no está vacío
        if (this.conjunto != null) {
            // Chequeo si el elemento a eliminar es el primero
            if (this.conjunto.getInfo() == value) {
                this.conjunto = this.conjunto.getNext();
            } else {
                Nodo aux = this.conjunto;
                while (aux.getNext() != null && aux.getNext().getInfo() != value) {
                    aux = aux.getNext();
                }

                if (aux.getNext() != null) {
                    aux.setNext(aux.getNext().getNext());
                }
            }
        }
    }

    /**
     * Verifica si el conjunto está vacío.
     *
     * @return <code>true</code> si el conjunto está vacío,
     * <code>false</code> en otro caso
     */
    @Override
    public boolean isEmpty() {
        return this.conjunto == null;
    }

    /**
     * Selecciona y devuelve un elemento arbitrario del conjunto.
     * El elemento devuelto puede ser cualquiera de los elementos del conjunto.
     *
     * @return Un elemento del conjunto.
     */
    @Override
    public int choose() {
        return this.conjunto.getInfo();
    }

    /**
     * Crea una copia exacta de este conjunto
     * @return nueva instancia con los mismos elementos
     */
    public ConjuntoD copy() {
        ConjuntoD copia =  new ConjuntoDImpl();
        Nodo actual = this.conjunto;

        // Recorro para ir agregando los elementos
        while (actual != null) {
            copia.add(actual.getInfo());
            actual = actual.getNext();
        }
        return copia;
    }

    /**
     * Verifica si este conjunto es subconjunto de otro
     * @param superConjunto El conjunto potencialmente más grande
     * @return <code>true</code> si todos los elementos de este están en el superconjunto
     */
    public boolean isSubsetOf(ConjuntoD superConjunto) {
        Nodo actual = this.conjunto;

        while (actual != null) {
            if (!superConjunto.belongs(actual.getInfo())) {
                return false;
            }
            actual = actual.getNext();
        }
        return true;
    }

    /**
     * Calcula la diferencia: elementos que están en este conjunto pero NO en otro
     * @param otherSet El conjunto a restar
     * @return Nuevo conjunto con la diferencia
     */
    public ConjuntoD difference(ConjuntoD otherSet) {
        ConjuntoD resultado = new ConjuntoDImpl();
        Nodo actual = this.conjunto;

        while (actual != null) {
            if (!otherSet.belongs(actual.getInfo())) {
                resultado.add(actual.getInfo());
            }
            actual = actual.getNext();
        }

        return resultado;
    }





    /**
     * Representación en String del conjunto
     * Muestra los elementos entre llaves {}
     */
    @Override
    public String toString() {
        if (this.conjunto == null) {
            return "Conjunto vacío";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Nodo actual = this.conjunto;
        while (actual != null) {
            sb.append(actual.getInfo());
            if (actual.getNext() != null) {
                sb.append(", ");
            }
            actual = actual.getNext();
        }
        sb.append("}");
        return sb.toString();
    }
}
