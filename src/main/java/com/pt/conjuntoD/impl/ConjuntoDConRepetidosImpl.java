package com.pt.conjuntoD.impl;

import com.pt.conjuntoD.interfaces.ConjuntoConRepetidos;
import com.pt.nodo.impl.NodoConRepetidosImpl;
import com.pt.nodo.interfaces.NodoConRepetidos;

public class ConjuntoDConRepetidosImpl implements ConjuntoConRepetidos {

    private NodoConRepetidos conjunto;

    // Constructor
    public ConjuntoDConRepetidosImpl() {
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
        NodoConRepetidos existente = buscarNodo(value);

        if (existente != null) {
            // Si el elemento existe, incrementa el contador
            existente.setCantidad(existente.getCantidad() + 1);
        } else {
            // Si el elemento no existe, crea uno nuevo
            NodoConRepetidos nuevo = new NodoConRepetidosImpl();
            nuevo.setInfo(value);
            nuevo.setCantidad(1);
            nuevo.setNext(this.conjunto);
            this.conjunto = nuevo;
        }
    }

    /**
     * Método auxiliar para buscar nodo por valor
     */
    private NodoConRepetidos buscarNodo(int value) {
        NodoConRepetidos aux = this.conjunto;
        while (aux != null) {
            if (aux.getInfo() == value) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }



    /**
     * Verifica si un elemento pertenece al conjunto.
     *
     * @param value El elemento a verificar.
     * @return <code>true</code> si el elemento existe en el conjunto, <code>false</code> en caso contrario.
     */
    @Override
    public boolean belongs(int value) {
        return buscarNodo(value) != null;
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
                NodoConRepetidos aux = this.conjunto;
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
     * Reduce en una la cantidad de repeticiones y si queda en
     * cero, se elimina el elemento del conjunto.
     * Si el elemento no existe en el conjunto,
     * la operación no tiene efecto.
     *
     * @param value El elemento a eliminar del conjunto.
     */
//    public void removeOne(int value) {
//        // Chequeo si no está vacío
//        if (this.conjunto != null) {
//            // Chequeo si el elemento a eliminar es el primero
//            if (this.conjunto.getInfo() == value) {
//                if (this.conjunto.getCantidad() > 1) { //Si al restarle queda en 1, solo le saco uno a la cantidad
//                    this.conjunto.setCantidad(this.conjunto.getCantidad() - 1);
//                } else {
//                    this.conjunto = this.conjunto.getNext();    // Si al restarle queda en 0, entonces lo elimino
//                }
//            } else {
//                NodoConRepetidos aux = this.conjunto;
//                while (aux.getNext() != null && aux.getNext().getInfo() != value) {
//                    aux = aux.getNext();
//                }
//
//                if (aux.getNext() != null) {
//                    if (aux.getNext().getCantidad() > 1) {
//                        aux.getNext().setCantidad(aux.getNext().getCantidad() - 1);
//                    }  else {
//                        aux.setNext(aux.getNext().getNext());
//                    }
//                }
//            }
//        }
//
//    }
    public void removeOne(int value) {
        NodoConRepetidos nodo = buscarNodo(value);
        if (nodo != null) {
            if (nodo.getCantidad() > 1) {
                nodo.setCantidad(nodo.getCantidad() - 1);
            } else {
                // Si queda en 1, eliminar completamente
                this.remove(value);
            }
        }
    }

    /**
     * Obtiene la cantidad de repeticiones de un elemento
     *
     * @param value El elemento a consultar
     * @return La cantidad de repeticiones, 0 si no existe
     */
    @Override
    public int getCantidad(int value) {
        return 0;
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
    public ConjuntoConRepetidos copy() {
        ConjuntoConRepetidos copia =  new ConjuntoDConRepetidosImpl();
        NodoConRepetidos actual = this.conjunto;

        // Recorro para ir agregando los elementos
        while (actual != null) {
            copia.add(actual.getInfo());
            actual = actual.getNext();
        }
        return copia;
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

        NodoConRepetidos actual = this.conjunto;
        while (actual != null) {
            sb.append(actual.getInfo());
            sb.append(", Cantidad: ");
            sb.append(actual.getCantidad());
            if (actual.getNext() != null) {
                sb.append("; ");
            }
            actual = actual.getNext();
        }
        sb.append("}");
        return sb.toString();
    }
}
