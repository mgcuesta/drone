package com.idealista.drone.impl;

import com.idealista.drone.Cartografia;
import com.idealista.drone.Operaciones;
import com.idealista.drone.comun.Direccion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que implementa las operaciones que se pueden realizar a un drone
 *
 * @author Miguel Gomez Cuesta
 * @since 1.0.0
 */
public class OperacionesDrone implements Operaciones {

    private Cartografia cartografia;

    public List<Integer> obtenerUrbanizaciones(double coordX, double coordY, int rango) {
        if (isValid(rango)) {
            Set<Integer> urbanizaciones = new HashSet<>();
            urbanizaciones.add(cartografia.obtenerIdentificadorUrbanizacion(coordX, coordY));
            int nivel = 1;
            while (nivel <= rango) {
                Set<Integer> urbanizacionesRango = new HashSet<>();
                for (Integer origen : urbanizaciones) {

                    Integer arriba = cartografia.obtenerAdyacente(origen, Direccion.ARRIBA);
                    Integer abajo = cartografia.obtenerAdyacente(origen, Direccion.ABAJO);
                    Integer izquierda = cartografia.obtenerAdyacente(origen, Direccion.IZQUIERDA);
                    Integer derecha = cartografia.obtenerAdyacente(origen, Direccion.DERECHA);

                    urbanizacionesRango.add(arriba);
                    urbanizacionesRango.add(abajo);
                    urbanizacionesRango.add(izquierda);
                    urbanizacionesRango.add(derecha);
                    urbanizacionesRango.add(cartografia.obtenerAdyacente(abajo, Direccion.IZQUIERDA));
                    urbanizacionesRango.add(cartografia.obtenerAdyacente(abajo, Direccion.DERECHA));
                    urbanizacionesRango.add(cartografia.obtenerAdyacente(arriba, Direccion.IZQUIERDA));
                    urbanizacionesRango.add(cartografia.obtenerAdyacente(arriba, Direccion.DERECHA));
                }
                urbanizaciones.addAll(urbanizacionesRango);
                nivel++;
            }

            return urbanizaciones.stream().collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

    }

    /**
     * Chequea que el rango es valido
     *
     * @param rango rango solicitado
     * @return true si es valido y false en otro caso
     */
    private boolean isValid(int rango) {
        return rango >= 0;
    }

    /**
     * Contruye objeto
     *
     * @param cartografia Cartografia para ejecutar operaciones
     */
    public OperacionesDrone(Cartografia cartografia) {
        this.cartografia = cartografia;
    }

}
