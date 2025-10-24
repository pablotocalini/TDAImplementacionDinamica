package com.pt.conjuntoD.interfaces;

/**
 * Interfaz extendida para conjuntos que permiten repeticiones con contador
 */
public interface ConjuntoConRepetidos extends ConjuntoD {

    /**
     * Reduce en una la cantidad de repeticiones y si queda en cero,
     * se elimina el elemento del conjunto.
     * Si el elemento no existe en el conjunto, la operación no tiene efecto.
     *
     * @param value El elemento a eliminar del conjunto.
     */
    void removeOne(int value);

    /**
     * Obtiene la cantidad de repeticiones de un elemento
     * @param value El elemento a consultar
     * @return La cantidad de repeticiones, 0 si no existe
     */
    int getCantidad(int value);
}