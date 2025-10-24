package com.pt.conjuntoD.impl;

import com.pt.conjuntoD.interfaces.ConjuntoD;
import com.pt.conjuntoD.interfaces.SuperConjunto;

/**
 * Implementación de SuperConjunto que hereda de ConjuntoDImpl
 */
public class SuperConjuntoImpl extends ConjuntoDImpl implements SuperConjunto {


    public SuperConjuntoImpl() {
        super(); // Llama al constructor de ConjuntoDImpl
    }

    @Override
    public boolean isSubset(ConjuntoD subconjunto) {
        // Se usa el método de ConjuntoDImpl
        // Casteo porque el método isSubsetOf está en la implementación
        return ((ConjuntoDImpl) subconjunto).isSubsetOf(this);
    }

    @Override
    public ConjuntoD getComplement(ConjuntoD subconjunto) {
        // Precondición: verificar que es subconjunto
        if (!isSubset(subconjunto)) {
            throw new IllegalArgumentException(
                    "No se puede calcular complemento: el conjunto " + subconjunto +
                            " no es subconjunto del superconjunto " + this
            );
        }
        // El complemento es la diferencia: SuperConjunto - Subconjunto
        return this.difference(subconjunto);
    }
}