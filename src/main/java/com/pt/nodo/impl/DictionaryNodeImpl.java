package com.pt.nodo.impl;

import com.pt.nodo.interfaces.DictionaryNode;

public class DictionaryNodeImpl implements DictionaryNode {

    private int key;
    private int value;
    private DictionaryNode nextNode;

    // Constructor vacío
    public DictionaryNodeImpl() {
        this.nextNode = null;
    }

    // Constructor con parámetros
    public DictionaryNodeImpl(int key, int value, DictionaryNode nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    /**
     * Obtiene el valor de la clave
     *
     * @return la clave
     */
    @Override
    public int getKey() {
        return this.key;
    }

    /**
     * Establece el valor de la clave
     *
     * @param key la clave a establecer
     */
    @Override
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Obtiene el valor asociado a una clave
     *
     * @return el valor contenido
     */
    @Override
    public int getValue() {
        return this.value;
    }

    /**
     * Establece el valor asociado a una clave
     *
     * @param value a guardar
     */
    @Override
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return un elemento de tipo {@link DictionaryNode}
     */
    @Override
    public DictionaryNode getNextNode() {
        return this.nextNode;
    }

    /**
     * Establece el nodo siguiente al actual
     *
     * @param nextNode
     */
    @Override
    public void setNextNode(DictionaryNode nextNode) {
        this.nextNode = nextNode;
    }
}
