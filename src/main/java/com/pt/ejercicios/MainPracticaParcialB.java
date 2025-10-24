package com.pt.ejercicios;

import com.pt.conjuntoD.impl.ConjuntoDImpl;
import com.pt.conjuntoD.impl.SuperConjuntoImpl;
import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.conjuntoD.interfaces.SuperConjunto;

/**
 * B. Superconjunto (o conjunto universal). A partir de las operaciones de un conjunto normal,
 * debe contar con
 * un método que reciba una instancia del Set y devuelva true si es subconjunto. Debe contar con un
 * segundo método que permite calcular el conjunto complemento del recibido por parámetro. Debe ser
 * precondición que no se puede calcular el complemento de un conjunto que no es subconjunto del
 * superconjunto.
 */


public class MainPracticaParcialB {

/*
    public static boolean chequeoSubconjunto(ConjuntoD conjuntoUniversal, ConjuntoD subConjunto) {
        boolean esSubconjunto = true;
        ConjuntoD auxSubConjunto = new ConjuntoDImpl();

        while(!subConjunto.isEmpty()) {
            int valor = subConjunto.choose();

            if (!conjuntoUniversal.belongs(valor)) {
                esSubconjunto = false;            }

            auxSubConjunto.add(valor);
            subConjunto.remove(valor);

        }

        while(!auxSubConjunto.isEmpty()) {
            subConjunto.add(auxSubConjunto.choose());
            auxSubConjunto.remove(auxSubConjunto.choose());
        }

        return esSubconjunto;
    }
*/

/*
    public static ConjuntoD calcularComplemento(ConjuntoD conjuntoUniversal, ConjuntoD subConjunto) {

        while (!subConjunto.isEmpty()) {
            int valor = subConjunto.choose();
            if (conjuntoUniversal.belongs(valor)) {
                conjuntoUniversal.remove(valor);
            }
        }

        return conjuntoUniversal;
    }
*/

    public static void main(String[] args) {

       /* ConjuntoD conjuntoUniversal = new ConjuntoDImpl();

        for(int i = 0; i < 5; i++) {
            conjuntoUniversal.add(i + 1);
        }

        System.out.println("Conjunto Universal: " + conjuntoUniversal);


        ConjuntoD subConjunto = new ConjuntoDImpl();

        for(int i = 0; i < 2; i++) {
            subConjunto.add(i + 1);
        }
        System.out.println("Conjunto a evaluar: " + subConjunto);

        boolean esSubconjunto = chequeoSubconjunto(conjuntoUniversal, subConjunto);

        if(esSubconjunto) {
            System.out.println("El Conjunto a evaluar es subconjunto de " + conjuntoUniversal);


            //System.out.println(calcularComplemento(conjuntoUniversal, subConjunto));

        }  else {
            System.out.println("El Conjunto a evaluar NO es subconjunto de " + conjuntoUniversal);
        }*/

        // Creo un superconjunto universal
        SuperConjunto universal = new SuperConjuntoImpl();
        for(int i = 1; i <= 5; i++) {
            universal.add(i);
        }

        System.out.println("Conjunto Universal: " + universal);

        // Crear subconjunto válido {2, 4}
        ConjuntoD subconjunto = new ConjuntoDImpl();
        subconjunto.add(2);
        subconjunto.add(4);

        System.out.println("Subconjunto: " + subconjunto);

        // Uso los métodos de la interfaz SuperConjunto
        boolean esSubconjunto = universal.isSubset(subconjunto);
        System.out.println("¿Es subconjunto? " + esSubconjunto);

        if(esSubconjunto) {
            ConjuntoD complemento = universal.getComplement(subconjunto);
            System.out.println("Complemento: " + complemento); // {1, 3, 5}
        }
    }
}
