package com.idealista.drone;

import com.idealista.drone.comun.Direccion;

/**
 * Interfaz que define las consulta que se pueden hacer sobre la cartografia
 *
 * @author Miguel Gomez Cuesta
 * @since 1.0.0
 */
public interface Cartografia {

    /**
     * Dadas unas coordenadas, Devuelve el
     * identificador de la urbanización en la que están encerradas dichas
     * coordenadas
     *
     * @param coordX Coordenada X
     * @param coordY Coordenada Y
     * @return Identificador de la urbanicacion que comprende esas coordenadas
     */
    Integer obtenerIdentificadorUrbanizacion(double coordX, double coordY);

    /**
     * Dado un identificador y la dirección de adyacencia
     * devuelve el identificador de la urbanización adyacente
     *
     * @param idUrbanicacion Identificador de la urbanización
     * @param direccion      Direccion de adyacencia
     * @return identificador de la urbanizacion adyacente
     */
    Integer obtenerAdyacente(Integer idUrbanicacion, Direccion direccion);

}
