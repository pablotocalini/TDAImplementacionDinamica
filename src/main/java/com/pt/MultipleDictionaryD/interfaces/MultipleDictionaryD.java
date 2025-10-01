package com.pt.MultipleDictionaryD.interfaces;

import com.pt.conjuntoD.interfaces.ConjuntoD;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para un Diccionario Múltiple.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface MultipleDictionaryD {

    /**
     * Inicializa el diccionario múltiple.
     * Debe ser llamado antes de cualquier operación.
     */
    void initialize ();

    /**
     * Agrega un valor asociado a una clave específica.
     * Si la clave no existe, se crea una nueva entrada para ella.
     * Si el valor ya existe para la clave, la operación no tiene efecto (no se permiten duplicados).
     *
     * @param key La clave a la que se asociará el valor. Puede ser cualquier entero.
     * @param value El valor a agregar a la clave especificada. Puede ser cualquier entero.
     */
    void add (int key, int value);

    /**
     * Elimina una clave y todos los valores asociados a ella del diccionario.
     * Si la clave no existe, la operación no tiene efecto.
     *
     * @param key La clave a eliminar junto con todos sus valores.
     */
    void remove (int key);

    /**
     * Elimina un valor específico asociado a una clave.
     * Si la clave queda sin valores después de esta operación, la clave también es eliminada.
     * Si la clave o el valor no existen, la operación no tiene efecto.
     *
     * @param key La clave de la que se eliminará el valor.
     * @param value El valor específico a eliminar de la clave.
     */
    void removeValue (int key, int value);

    /**
     * Obtiene todos los valores asociados a una clave específica como un Conjunto.
     * El conjunto devuelto contiene todos los valores únicos almacenados para la clave.
     *
     * @param key La clave de la que se obtendrán los valores.
     * @return Un Conjunto con todos los valores asociados a la clave.
     *         Si la clave no existe, retorna un conjunto vacío.
     */
    ConjuntoD getValues (int key);

    /**
     * Obtiene todas las claves almacenadas en el diccionario como un Conjunto.
     * El conjunto devuelto contiene todas las claves que tienen al menos un valor asociado.
     *
     * @return Un Conjunto con todas las claves existentes en el diccionario.
     *         Si el diccionario está vacío, retorna un conjunto vacío.
     */
    ConjuntoD getKeys ();
}
