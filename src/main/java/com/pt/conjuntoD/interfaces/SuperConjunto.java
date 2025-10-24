package com.pt.conjuntoD.interfaces;

/**
 * Interfaz que define un SuperConjunto (Conjunto Universal)
 * Extiende las operaciones básicas de ConjuntoD con operaciones
 * específicas de superconjunto
 */
public interface SuperConjunto extends ConjuntoD {

    /**
     * Verifica si un conjunto es subconjunto de este superconjunto
     * @param subconjunto El conjunto a verificar
     * @return true si es subconjunto, false en caso contrario
     */
    boolean isSubset(ConjuntoD subconjunto);

    /**
     * Calcula el complemento de un subconjunto respecto a este superconjunto
     * @param subconjunto El subconjunto para calcular complemento
     * @return El conjunto complemento (elementos del universal que no están en el subconjunto)
     * @throws IllegalArgumentException si el parámetro no es subconjunto de este superconjunto
     */
    ConjuntoD getComplement(ConjuntoD subconjunto);
}