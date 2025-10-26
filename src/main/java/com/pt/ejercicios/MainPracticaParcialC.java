package com.pt.ejercicios;

import com.pt.colaDCircDobEnlaz.impl.ColaDCircDobEnlazImpl;
import com.pt.colaDCircDobEnlaz.interfaces.ColaDCircDobEnlaz;


/**
 * C. Cola dinámica cíclica doblemente enlazada. Los métodos que posee
 * deben usar esta propiedad para disminuir la complejidad computacional.
 */

public class MainPracticaParcialC {

    public static void main(String[] args) {
        ColaDCircDobEnlaz cola = new ColaDCircDobEnlazImpl();

        System.out.println("=== Prueba Cola Circular Doblemente Enlazada ===");

        // Agregar elementos
        System.out.println("\n--- Agregando elementos ---");
        cola.add(10);
        cola.add(20);
        cola.add(30);
        System.out.println(cola);
        System.out.println("Primero: " + cola.getFirst());

        // Eliminar
        System.out.println("\n--- Eliminando ---");
        cola.remove();
        System.out.println(cola);
        System.out.println("Primero después de remove: " + cola.getFirst());

        // Probar circularidad agregando más
        System.out.println("\n--- Probando circularidad ---");
        cola.add(40);
        cola.add(50);
        System.out.println(cola);

        // Vaciar progresivamente
        System.out.println("\n--- Vaciar cola ---");
        while (!cola.isEmpty()) {
            System.out.println("Eliminando: " + cola.getFirst());
            cola.remove();
            System.out.println(cola);
        }

        // Probar los errores
        try {
            cola.remove();
        } catch (IllegalStateException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
    }
}
