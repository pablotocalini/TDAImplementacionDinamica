package com.pt.simpleDictionaryD.impl;

import com.pt.conjuntoD.impl.ConjuntoDImpl;
import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.nodo.impl.DictionaryNodeImpl;
import com.pt.nodo.interfaces.DictionaryNode;
import com.pt.simpleDictionaryD.interfaces.SimpleDictionaryD;

public class SimpleDictionaryDImpl implements SimpleDictionaryD {

    DictionaryNode origin;

    // Constructor
    public SimpleDictionaryDImpl() {
        this.initialize();
    }

    /**
     * Inicializa el diccionario.
     * Este método debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.origin = null;
    }

    /**
     * Agrega o actualiza un par clave-valor en el diccionario.
     * Si la clave no existe, crea una nueva entrada con el valor especificado.
     * Si la clave ya existe, actualiza su valor con el nuevo valor proporcionado.
     *
     * @param key   La clave a agregar o actualizar. Debe ser un entero único.
     * @param value El valor a asociar con la clave. Puede ser cualquier entero.
     */
    @Override
    public void add(int key, int value) {
        DictionaryNode aux = key2DictionaryNode(key);   //Busco la clave

        // Si no encuentra la clave (está vacío o no está)
        if(aux == null) {
            aux = new DictionaryNodeImpl();
            aux.setKey(key);
            aux.setNextNode(this.origin);
            this.origin = aux;
        }
        aux.setValue(value);    // Establece el valor
    }

    /**
     * Elimina una clave y su valor asociado del diccionario.
     * Si la clave no existe, la operación no tiene efecto.
     *
     * @param key La clave a eliminar del diccionario.
     */
    @Override
    public void remove(int key) {
        if(this.origin != null) {   // Chequeo que no esté vacío

            if(this.origin.getKey() == key) {   // Chequeo si es el nodo que busco
                this.origin = this.origin.getNextNode();    // Reemplazo el nodo, con el siguiente

            } else {    // Si no está vacio y no es el nodo origen el que busco
                DictionaryNode aux = this.origin;
                while (aux.getNextNode() != null && aux.getNextNode().getKey() != key) {
                    aux = aux.getNextNode();
                }
                if (aux.getNextNode() != null) {    // Si encuentra la clave
                    // Elimina el nodo siguiente al que esta (el que tiene la clave buscada) reemplazandolo con el proximo que sigue
                    // Es decir que deja al nodo a eliminar sin referencia
                    aux.setNextNode(aux.getNextNode().getNextNode());
                }
            }
        }
    }

    /**
     * Recupera el valor asociado a una clave específica.
     *
     * @param key La clave de la que se obtendrá el valor.
     * @return El valor asociado a la clave especificada.
     */
    @Override
    public int recoverValue(int key) {
        DictionaryNode aux = key2DictionaryNode(key);

        if(aux == null) {
            throw new IllegalStateException("No se encontró un valor asociado a la clave: " + key);
        }

        return aux.getValue();
    }

    /**
     * Obtiene todas las claves almacenadas en el diccionario como un Conjunto.
     * El conjunto devuelvo contiene todas las claves que tienen un valor asociado.
     *
     * @return Un Conjunto con todas las claves existentes en el diccionario.
     * Si el diccionario está vacío, retorna un conjunto vacío.
     */
    @Override
    public ConjuntoD setOfKeys() {
        ConjuntoD set = new ConjuntoDImpl();    // Creo el conjunto
        set.initialize();   // Inicializo el conjunto
        DictionaryNode aux = this.origin;   // Creo un diccionario auxiliar

        // Itera sobre todos los nodos y va poniendo la clave en el conjunto
        while (aux != null) {
            set.add(aux.getKey());
            aux = aux.getNextNode();
        }
        return set;
    }

    /**
     * Representación en String del diccionario
     * Muestra los pares clave-valor en formato JSON
     */
    @Override
    public String toString() {
        if (this.origin == null) {
            return "Diccionario vacío";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        DictionaryNode actual = this.origin;
        while (actual != null) {
            sb.append("  clave: ").append(actual.getKey())
                    .append(", valor: ").append(actual.getValue());
            if (actual.getNextNode() != null) {
                sb.append(",");
            }
            sb.append("\n");
            actual = actual.getNextNode();
        }
        sb.append("}");
        return sb.toString();
    }

    // Metodos privados

    /**
     * Metodo para encontrar el nodo correspondiente a una clave
     *
     * @param key clave a buscar
     * @return DictionaryNode o null
     */
    private DictionaryNode key2DictionaryNode(int key) {
        DictionaryNode aux = this.origin;

        // Busco nodo a nodo la clave o llego al final
        while(aux != null && aux.getKey() != key) {
            aux = aux.getNextNode();
        }
        return aux;
    }
}
