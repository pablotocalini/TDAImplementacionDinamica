package com.pt.MultipleDictionaryD.impl;

import com.pt.MultipleDictionaryD.interfaces.MultipleDictionaryD;
import com.pt.conjuntoD.impl.ConjuntoDImpl;
import com.pt.conjuntoD.interfaces.ConjuntoD;

public class MultipleDictionaryDImpl implements MultipleDictionaryD {

    class KeyNode {
        int key;
        ValueNode values;
        KeyNode nextNode;
    }

    class ValueNode {
        int value;
        ValueNode nextValue;
    }

    KeyNode origin;

    // Constructor
    public MultipleDictionaryDImpl() {
        this.initialize();
    }

    /**
     * Inicializa el diccionario múltiple.
     * Debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.origin = null;
    }

    /**
     * Agrega un valor asociado a una clave específica.
     * Si la clave no existe, se crea una nueva entrada para ella.
     * Si el valor ya existe para la clave, la operación no tiene efecto (no se permiten duplicados).
     *
     * @param key   La clave a la que se asociará el valor. Puede ser cualquier entero.
     * @param value El valor a agregar a la clave especificada. Puede ser cualquier entero.
     */
    @Override
    public void add(int key, int value) {
        KeyNode keyNode = key2KeyNode(key); // Busca si la clave ya existe

        // Si la clave NO existe, la crea
        if(keyNode == null){
            keyNode = new KeyNode();
            keyNode.key = key;
            keyNode.nextNode = this.origin; // Inserta al inicio
            this.origin = keyNode;          // Actualiza origen
        }

        // Chequea si el valor YA EXISTE para esta clave
        ValueNode aux = keyNode.values;
        while(aux != null && aux.value != value){
            aux = aux.nextValue;
        }

        // Si el valor NO existe, lo agrega
        if(aux == null){
            ValueNode newValue = new ValueNode();
            newValue.value = value;
            newValue.nextValue = keyNode.values;  // Inserta al inicio de la lista de valores
            keyNode.values = newValue;            // Actualiza la cabeza de valores
        }
    }

    /**
     * Elimina una clave y todos los valores asociados a ella del diccionario.
     * Si la clave no existe, la operación no tiene efecto.
     *
     * @param key La clave a eliminar junto con todos sus valores.
     */
    @Override
    public void remove(int key) {
        if(this.origin != null){

            if(this.origin.key == key) {

                this.origin = this.origin.nextNode;

            } else {
                KeyNode aux = this.origin;

                while(aux.nextNode != null && aux.nextNode.key != key) {
                    aux = aux.nextNode;
                }
                if(aux.nextNode != null) {
                    aux.nextNode = aux.nextNode.nextNode;
                }
            }
        }
    }

    /**
     * Elimina un valor específico asociado a una clave.
     * Si la clave queda sin valores después de esta operación, la clave también es eliminada.
     * Si la clave o el valor no existen, la operación no tiene efecto.
     *
     * @param key   La clave de la que se eliminará el valor.
     * @param value El valor específico a eliminar de la clave.
     */
    @Override
    public void removeValue(int key, int value) {
        if(this.origin != null){    // Chequeo si no está vacío

            if(this.origin.key == key){     //Chequeo si la clave en el nodo es en la que quiero eliminar el valor
                // Elimino el valor
                removeValueInNode(this.origin, value);

                if (this.origin.values == null) {
                    this.origin = this.origin.nextNode;
                }

            } else {
                KeyNode aux = this.origin;
                while(aux.nextNode != null && aux.nextNode.key != key){
                    aux = aux.nextNode;
                }
                if(aux.nextNode != null){
                    removeValueInNode(aux.nextNode, value);
                    if(aux.nextNode.values == null){
                        aux.nextNode = aux.nextNode.nextNode;
                    }
                }
            }
        }
    }

    /**
     * Obtiene todos los valores asociados a una clave específica como un Conjunto.
     * El conjunto devuelto contiene todos los valores únicos almacenados para la clave.
     *
     * @param key La clave de la que se obtendrán los valores.
     * @return Un Conjunto con todos los valores asociados a la clave.
     * Si la clave no existe, retorna un conjunto vacío.
     */
    @Override
    public ConjuntoD getValues(int key) {
        KeyNode keyNode = key2KeyNode(key); // Busca si la clave ya existe
        ConjuntoD set = new ConjuntoDImpl();
        set.initialize();

        if(keyNode != null){
            ValueNode aux = keyNode.values;
            while (aux != null) {
                set.add(aux.value);
                aux = aux.nextValue;
            }
        }
        return set;
    }

    /**
     * Obtiene todas las claves almacenadas en el diccionario como un Conjunto.
     * El conjunto devuelto contiene todas las claves que tienen al menos un valor asociado.
     *
     * @return Un Conjunto con todas las claves existentes en el diccionario.
     * Si el diccionario está vacío, retorna un conjunto vacío.
     */
    @Override
    public ConjuntoD getKeys() {
        ConjuntoD set = new ConjuntoDImpl();
        set.initialize();

        KeyNode aux = this.origin;
        while (aux != null) {
            set.add(aux.key);
            aux = aux.nextNode;
        }
        return set;
    }

    /**
     * Representación en String del diccionario múltiple
     * Muestra cada clave con todos sus valores asociados
     */
    @Override
    public String toString() {
        if (this.origin == null) {
            return "Diccionario múltiple vacío";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        KeyNode keyActual = this.origin;
        while (keyActual != null) {
            sb.append("  clave: ").append(keyActual.key).append(" -> valores: [");

            // Mostrar todos los valores de esta clave
            ValueNode valueActual = keyActual.values;
            while (valueActual != null) {
                sb.append(valueActual.value);
                if (valueActual.nextValue != null) {
                    sb.append(", ");
                }
                valueActual = valueActual.nextValue;
            }
            sb.append("]");

            if (keyActual.nextNode != null) {
                sb.append(",");
            }
            sb.append("\n");
            keyActual = keyActual.nextNode;
        }
        sb.append("}");
        return sb.toString();
    }

    // Metodos privados

    /**
     * Metodo para encontrar el nodo correspondiente a una clave
     *
     * @param key clave a buscar
     * @return KeyNode o null
     */
    private KeyNode key2KeyNode(int key) {
        KeyNode aux = this.origin;

        // Busco nodo a nodo la clave o llego al final
        while(aux != null && aux.key != key) {
            aux = aux.nextNode;
        }
        return aux;
    }

    /**
     * Metodo privado para eliminar un valor de una clave
     *
     * @param keyNode Clave donde buscar el valor a eliminar
     * @param value valor a eliminar
     */
    private void removeValueInNode(KeyNode keyNode, int value) {
        if (keyNode.values != null){

            if (keyNode.values.value == value) {
                keyNode.values = keyNode.values.nextValue;
            } else {
                ValueNode aux = keyNode.values;

                while(aux.nextValue != null && aux.nextValue.value != value) {
                    aux = aux.nextValue;
                }

                if (aux.nextValue != null) {
                    aux.nextValue = aux.nextValue.nextValue;
                }
            }
        }
    }
}
