package com.pt.simpleDictionaryD.interfaces;

import com.pt.conjuntoD.interfaces.ConjuntoD;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para un Diccionario Simple.
 * Un Diccionario Simple almacena pares clave-valor donde cada clave es única
 * y está asociada a exactamente un valor.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface SimpleDictionaryD {

    /**
     * Inicializa el diccionario.
     * Este método debe ser llamado antes de cualquier operación.
     */
    void initialize ();

    /**
     * Agrega o actualiza un par clave-valor en el diccionario.
     * Si la clave no existe, crea una nueva entrada con el valor especificado.
     * Si la clave ya existe, actualiza su valor con el nuevo valor proporcionado.
     *
     * @param key La clave a agregar o actualizar. Debe ser un entero único.
     * @param value El valor a asociar con la clave. Puede ser cualquier entero.
     */
    void add(int key, int value);

    /**
     * Elimina una clave y su valor asociado del diccionario.
     * Si la clave no existe, la operación no tiene efecto.
     *
     * @param key La clave a eliminar del diccionario.
     */
    void remove(int key);

    /**
     * Recupera el valor asociado a una clave específica.
     *
     * @param key La clave de la que se obtendrá el valor.
     * @return El valor asociado a la clave especificada.
     */
    int recoverValue(int key);

    /**
     * Obtiene todas las claves almacenadas en el diccionario como un Conjunto.
     * El conjunto devuelvo contiene todas las claves que tienen un valor asociado.
     *
     * @return Un Conjunto con todas las claves existentes en el diccionario.
     *         Si el diccionario está vacío, retorna un conjunto vacío.
     */
    ConjuntoD setOfKeys();

}
