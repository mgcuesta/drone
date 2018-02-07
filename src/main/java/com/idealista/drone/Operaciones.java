package com.idealista.drone;

import java.util.List;

/**
 * Interfaz que define las operaciones
 *
 * @author Miguel Gomez Cuesta
 * @since 1.0.0
 */
public interface Operaciones {

    /**
     * Dadas unas coordenadas y un rango, nos devuelva el
     * identificador de todas las urbanizaciones que deberá visitar el drone
     *
     * @param coordX Coordenada X
     * @param coordY Coordenada Y
     * @param rango
     * @return
     */
    List<Integer> obtenerUrbanizaciones(double coordX, double coordY, int rango);
}
