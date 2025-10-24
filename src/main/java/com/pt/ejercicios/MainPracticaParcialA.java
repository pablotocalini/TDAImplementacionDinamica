package com.pt.ejercicios;

import com.pt.conjuntoD.impl.ConjuntoDImpl;
import com.pt.conjuntoD.impl.SuperConjuntoImpl;
import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.conjuntoD.interfaces.SuperConjunto;
import com.pt.pilaD.impl.PilaDConLimiteImpl;
import com.pt.pilaD.interfaces.PilaD;

/**
 * A. Pila dinámica con capacidad limitada. Debe recibir la capacidad máxima por constructor.
 */


public class MainPracticaParcialA {

    public static void main(String[] args) {

        PilaD pilaConLimite = new PilaDConLimiteImpl(2);

        System.out.println("Pila con limite: " +  pilaConLimite);

        try {
            pilaConLimite.add(1);
            pilaConLimite.add(2);
            pilaConLimite.add(3);

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Pila con limite: " +  pilaConLimite);

    }
}
