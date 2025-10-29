package com.pt.arbolBinarioBusqueda.interfaces;

import com.pt.linkedList.interfaces.LinkedList;

public interface ArbolBinarioBusqueda {

    void inicializarArbol();

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     */
    int raiz ();

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     * @return un árbol
     */
    ArbolBinarioBusqueda hijoIzq();

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     * @return un árbol
     */
    ArbolBinarioBusqueda hijoDer();

    /**
     * Siempre que el árbol esté inicializado
     * @return <code>true</code> si el arbol está vacío, de lo contrario, <code>flase</code>
     */
    boolean arbolVacio();

    /**
     * Siempre que el árbol esté inicializado
     * @param x el elemento a agregar
     */
    void agregarElem( int x);

    /**
     * Siempre que el árbol esté inicializado
     * @param x el elemento a eliminar
     */
    void eliminarElem( int x);

    void preOrder(ArbolBinarioBusqueda arbol);
    void postOrder(ArbolBinarioBusqueda arbol);
    void inOrder(ArbolBinarioBusqueda arbol);

    /**
     * Obtiene la altura del árbol
     *
     * @return altura máxima del árbol
     */
    int altura();

    /**
     * Busca un elemento en el árbol
     *
     * @param value elemento a buscar
     *
     * @return <code>true</code> si existe, <code>false</code> en caso contrario
     */
    boolean buscar(int value);

    int sumarNodos();
    int mayorValor(ArbolBinarioBusqueda arbol);
    int menorValor(ArbolBinarioBusqueda arbol);
    LinkedList buscarNodosInternos();
    void imprimirNivelesImpares();
}
