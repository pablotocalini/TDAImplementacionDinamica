package com.pt.conjuntoD.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para un Conjunto.
 * Un conjunto es una colección de elementos únicos sin orden específico.
 *
 * Precondición general: el conjunto debe estar inicializado antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface ConjuntoD {

    /**
     * Inicializa el conjunto.
     * Este método debe ser llamado antes de cualquier operación.
     */
    void initialize();

    /**
     * Agrega un elemento al conjunto si no existe previamente.
     * Si el elemento ya existe en el conjunto, la operación no tiene efecto.
     *
     * @param value El elemento a agregar al conjunto.
     */
    void add(int value);

    /**
     * Verifica si un elemento pertenece al conjunto.
     *
     * @param value El elemento a verificar.
     * @return <code>true</code> si el elemento existe en el conjunto, <code>false</code> en caso contrario.
     */
    boolean belongs(int value);

    /**
     * Elimina un elemento del conjunto.
     * Si el elemento no existe en el conjunto, la operación no tiene efecto.
     *
     * @param value El elemento a eliminar del conjunto.
     */
    void remove(int value);

    /**
     * Verifica si el conjunto está vacío.
     *
     * @return <code>true</code> si el conjunto está vacío,
     * <code>false</code> en otro caso
     */
    boolean isEmpty();

    /**
     * Selecciona y devuelve un elemento arbitrario del conjunto.
     * El elemento devuelto puede ser cualquiera de los elementos del conjunto.
     *
     * @return Un elemento del conjunto.
     */
    int choose();
}
