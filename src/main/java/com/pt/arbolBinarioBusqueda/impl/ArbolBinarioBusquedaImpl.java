package com.pt.arbolBinarioBusqueda.impl;

import com.pt.arbolBinarioBusqueda.interfaces.ArbolBinarioBusqueda;
import com.pt.linkedList.impl.LinkedListImpl;
import com.pt.linkedList.interfaces.LinkedList;

public class ArbolBinarioBusquedaImpl implements ArbolBinarioBusqueda {

    class NodoABB{
        int info;
        ArbolBinarioBusqueda hijoIzq;
        ArbolBinarioBusqueda hijoDer;
    }

    NodoABB raiz;

    public ArbolBinarioBusquedaImpl() {
        this.inicializarArbol();
    }

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
        if (this.arbolVacio()) {
            throw new IllegalStateException("No se puede obtener la raíz: el árbol está vacío");
        }
        return this.raiz.info;
    }

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     *
     * @return un árbol que representa el hijo izquierdo del nodo raiz
     */
    @Override
    public ArbolBinarioBusqueda hijoIzq() {
        if (this.arbolVacio()) {
            throw new IllegalStateException("No se puede obtener el hijo izquierdo: el árbol está vacío");
        }
        return this.raiz.hijoIzq;
    }

    /**
     * Siempre que el árbol esté inicializado y no esté vacío
     *
     * @return un árbol que representa el hijo derecho del nodo raiz
     */
    @Override
    public ArbolBinarioBusqueda hijoDer() {
        if (this.arbolVacio()) {
            throw new IllegalStateException("No se puede obtener el hijo derecho: el árbol está vacío");
        }
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
            this.raiz.hijoDer = new ArbolBinarioBusquedaImpl();     // Creo una nueva instancia de ABB en el nodo derecho

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

            } else if (this.raiz.info == x && !this.raiz.hijoIzq.arbolVacio()) {    // Si no es una hoja
                this.raiz.info = this.mayor(this.raiz.hijoIzq); // Busco el mayor valor de los menores y lo asigno a donde elimine el valor
                this.raiz.hijoIzq.eliminarElem(this.raiz.info); // Elimino el elemento que movi

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

    /**
     * Propone visitar primero los padres y luego cada hijo en el mismo orden,
     * es decir se visita el nodo raíz, y luego cada subárbol en pre-order.
     *
     * @param arbol a recorrer
     */
    @Override
    public void preOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            System.out.print(arbol.raiz());
            preOrder(arbol.hijoIzq());
            preOrder(arbol.hijoDer());
        }
    }

    /**
     * Metodo para recolectar todas las hojas del árbol en una lista
     *
     * @return LinkedList con todos los valores de las hojas
     */
    public LinkedList enlazarHojas() {
        LinkedList hojasEnlazadas = new LinkedListImpl();
        this.recolectarHojasRecursivo(this, hojasEnlazadas);
        return hojasEnlazadas;
    }

    /**
     * Propone visitar in-order el subárbol izquierdo, luego la raíz y por último
     * in-order el subárbol derecho.
     *
     * @param arbol a recorrer
     */
    @Override
    public void inOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            inOrder(arbol.hijoIzq());
            System.out.print(arbol.raiz());
            inOrder(arbol.hijoDer());
        }
    }

    /**
     * Propone visitar primero los hijos en post-orden y luego la raiz.
     *
     * @param arbol a recorrer
     */
    @Override
    public void postOrder(ArbolBinarioBusqueda arbol) {
        if(!arbol.arbolVacio()) {
            postOrder(arbol.hijoIzq());
            postOrder(arbol.hijoDer());
            System.out.print(arbol.raiz());
        }
    }

    //--------------------- Metodos especificos -----------------------//

    /**
     * Metodo para sumar los valores de los nodos
     * @return la suma total de los nodos
     */
    public int sumarNodos() {
        if(this.arbolVacio()) {
            return 0;
        }
        return this.raiz()
                + this.hijoIzq().sumarNodos()
                + this.hijoDer().sumarNodos();
    }

    /**
     * Obtiene la altura del árbol
     * @return altura máxima del árbol
     */
    public int altura() {
        if (this.arbolVacio()) {
            return 0;
        }
        return 1 + Math.max(this.raiz.hijoIzq.altura(), this.raiz.hijoDer.altura());
    }

    /**
     * Busca un elemento en el árbol
     * @param value elemento a buscar
     * @return true si existe, false en caso contrario
     */
    public boolean buscar(int value) {
        if (this.arbolVacio()) {
            return false;
        }

        if (this.raiz.info == value) {
            return true;
        } else if (value < this.raiz.info) {
            return this.raiz.hijoIzq.buscar(value);
        } else {
            return this.raiz.hijoDer.buscar(value);
        }
    }

    /**
     * Método para retornar el mayor valor
     *
     * @param arbol
     * @return el mayor
     */
    @Override
    public int mayorValor(ArbolBinarioBusqueda arbol) {
        return this.mayor(arbol);
    }

    /**
     * Método para retornar el menor valor
     *
     * @param arbol
     * @return el menor
     */
    @Override
    public int menorValor(ArbolBinarioBusqueda arbol) {
        return this.menor(arbol);
    }

    /**
     * Metodo para buscar los nodos internos
     *
     * @return LinkedList con los nodos internos
     */
    public LinkedList buscarNodosInternos() {
        LinkedList nodosInternos = new LinkedListImpl();
        this.recolectarNodosInternos(this, nodosInternos);
        return nodosInternos;
    }

    /**
     * Imprime todos los valores almacenados en nodos de niveles impares
     * Nivel 0 (raíz) es par, nivel 1 es impar, nivel 2 es par, etc.
     */
    public void imprimirNivelesImpares() {
        this.imprimirNivelesImparesRecursivo(this, 0);
    }



    // Metodos privados

    /**
     * Método auxiliar recursivo para imprimir nodos en niveles impares
     * @param arbol actual
     * @param nivel nivel actual
     */
    private void imprimirNivelesImparesRecursivo(ArbolBinarioBusqueda arbol, int nivel) {
        if(!arbol.arbolVacio()) {   // si el árbol no está vacío

            if(nivel % 2 == 1) {    // si el nivel es impar
                System.out.print(arbol.raiz() + " ");
            }

            // Repetir con los hijos
            imprimirNivelesImparesRecursivo(arbol.hijoIzq(), nivel + 1);
            imprimirNivelesImparesRecursivo(arbol.hijoDer(), nivel + 1);
        }
    }


    /**
     * Método auxiliar recursivo para recolectar nodos internos
     */
    private void recolectarNodosInternos(ArbolBinarioBusqueda arbol, LinkedList nodosInternos) {
        if(!arbol.arbolVacio()) {   // si el árbol no está vacío

            // Chequeo si es un nodo hoja
            boolean esNodoInterno = !arbol.hijoIzq().arbolVacio() || !arbol.hijoDer().arbolVacio();

            if (esNodoInterno) {    // Si es un nodo interno lo agrego a la lista
                nodosInternos.add(arbol.raiz());
            }

            // Repito el proceso con los nodos hijos
            recolectarNodosInternos(arbol.hijoIzq(), nodosInternos);
            recolectarNodosInternos(arbol.hijoDer(), nodosInternos);
        }
    }

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

    /**
     * Método auxiliar recursivo para recolectar hojas
     */
    private void recolectarHojasRecursivo(ArbolBinarioBusqueda arbol, LinkedList hojasEnlazadas) {
        if(!arbol.arbolVacio()) {
            // en este caso es hoja, solo si ambos hijos están vacíos
            if(arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) {
                hojasEnlazadas.add(arbol.raiz());
            } else {
                // Busco las hojas recursivamente en los hijos
                recolectarHojasRecursivo(arbol.hijoIzq(), hojasEnlazadas);
                recolectarHojasRecursivo(arbol.hijoDer(), hojasEnlazadas);
            }
        }
    }
}
