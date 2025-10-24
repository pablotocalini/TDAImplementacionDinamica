package com.pt.arbolBinarioBusqueda.impl;

import com.pt.arbolBinarioBusqueda.interfaces.ArbolBinarioBusqueda;

public class ArbolBinarioBusquedaImpl implements ArbolBinarioBusqueda {

    class NodoABB{
        int info;
        ArbolBinarioBusqueda hijoIzq;
        ArbolBinarioBusqueda hijoDer;
    }

    NodoABB raiz;

    /**
     *
     */
    @Override
    public void inicializarArbol() {
        this.raiz = null;
    }

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     * @return el valor del nodo raiz
     */
    @Override
    public int raiz() {
        return this.raiz.info;
    }

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     *
     * @return un árbol que representa el hijo izquierdo del nodo raiz
     */
    @Override
    public ArbolBinarioBusqueda hijoIzq() {
        return this.raiz.hijoIzq;
    }

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     *
     * @return un árbol que representa el hijo derecho del nodo raiz
     */
    @Override
    public ArbolBinarioBusqueda hijoDer() {
        return this.raiz.hijoDer;
    }

    /**
     * Siempre que el árbol esté inicializado
     *
     * @return <code>true</code> si el arbol está vacío, de lo contrario, <code>flase</code>
     */
    @Override
    public boolean arbolVacio() {
        return this.raiz == null;
    }

    /**
     * Siempre que el árbol esté inicializado
     *
     * @param x el elemento a agregar
     */
    @Override
    public void agregarElem(int x) {
        if(this.raiz == null) {     // Si el arbol esta vacío, entonces creo la raiz y los dos hijos
            this.raiz = new NodoABB();
            this.raiz.info = x;     // Agrego el valor del nodo raiz
            this.raiz.hijoIzq = new ArbolBinarioBusquedaImpl();     // Creo una nueva instancia de ABB en el nodo izquierdo
            this.raiz.hijoIzq.inicializarArbol();       // Inicializo el ABB
            this.raiz.hijoDer = new ArbolBinarioBusquedaImpl();     // Creo una nueva instancia de ABB en el nodo derecho
            this.raiz.hijoDer.inicializarArbol();       // Inicializo el ABB

        } else if (this.raiz.info > x) {
            this.raiz.hijoIzq.agregarElem(x);

        }  else if (this.raiz.info < x) {
            this.raiz.hijoDer.agregarElem(x);
        }
    }

    /**
     * Siempre que el árbol esté inicializado
     *
     * @param x el elemento a eliminar
     */
    @Override
    public void eliminarElem(int x) {
        if(this.raiz != null) {     // Si el arbol no está vacío
            // Si el elemento buscado está en el nodo raiz y los dos nodos hijos son árboles vacíos
            if(this.raiz.info == x && this.raiz.hijoIzq.arbolVacio() && this.raiz.hijoDer.arbolVacio()) {
                this.raiz = null;

            } else if (this.raiz.info == x && !this.raiz.hijoIzq.arbolVacio()) {
                this.raiz.info = this.mayor(this.raiz.hijoIzq);
                this.raiz.hijoIzq.eliminarElem(this.raiz.info);

            }  else if (this.raiz.info == x && this.raiz.hijoIzq.arbolVacio()) {
                this.raiz.info = this.menor(this.raiz.hijoDer);
                this.raiz.hijoDer.eliminarElem(this.raiz.info);

            } else if (this.raiz.info < x) {
                this.raiz.hijoDer.eliminarElem(x);

            } else {
                this.raiz.hijoIzq.eliminarElem(x);
            }
        }
    }

    @Override
    public void preOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            System.out.print(arbol.raiz());
            preOrder(arbol.hijoIzq());
            preOrder(arbol.hijoDer());
        }
    }

    @Override
    public void inOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            inOrder(arbol.hijoIzq());
            System.out.print(arbol.raiz());
            inOrder(arbol.hijoDer());
        }
    }

    @Override
    public void postOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            postOrder(arbol.hijoIzq());
            postOrder(arbol.hijoDer());
            System.out.print(arbol.raiz());
        }
    }

    // Metodos privados

    private int mayor(ArbolBinarioBusqueda a) {
        if(a.hijoDer().arbolVacio()) {
            return a.raiz();

        }  else {
            return mayor(a.hijoDer());
        }
    }

    private int menor(ArbolBinarioBusqueda a) {
        if (a.hijoIzq().arbolVacio()) {
            return a.raiz();
        } else {
            return menor(a.hijoIzq());
        }
    }
}
