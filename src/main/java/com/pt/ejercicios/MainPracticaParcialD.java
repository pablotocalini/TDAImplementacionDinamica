package com.pt.ejercicios;

import com.pt.conjuntoD.impl.ConjuntoDConRepetidosImpl;
import com.pt.conjuntoD.interfaces.ConjuntoConRepetidos;

/**
 * D. Conjunto con repetidos. Es un conjunto de duplas,
 * donde cada elemento tiene asociada una cantidad.
 */


public class MainPracticaParcialD {

    public static void main(String[] args) {

        ConjuntoConRepetidos conjunto = new ConjuntoDConRepetidosImpl();

        conjunto.add(1);
        conjunto.add(1);
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);
        conjunto.add(1);

        System.out.println(conjunto);

        conjunto.removeOne(1);
        conjunto.removeOne(2);

        System.out.println(conjunto);
    }
}
