package com.pt.nodo.interfaces;

public interface DictionaryNode {

    /**
     * Obtiene el valor de la clave
     *
     * @return la clave
     */
    int getKey();

    /**
     * Establece el valor de la clave
     *
     * @param key la clave a establecer
     */
    void setKey(int key);

    /**
     * Obtiene el valor asociado a una clave
     *
     * @return el valor contenido
     */
    int getValue();

    /**
     * Establece el valor asociado a una clave
     *
     * @param value a guardar
     */
    void setValue(int value);

    /**
     * Obtiene el nodo siguiente
     *
     * @return un elemento de tipo {@link DictionaryNode}
     */
    DictionaryNode getNextNode();

    /**
     * Establece el nodo siguiente al actual
     *
     * @param nextNode nodo siguiente
     */
    void setNextNode(DictionaryNode nextNode);

}
