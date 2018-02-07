package com.idealista.drone.impl

import com.idealista.drone.Cartografia
import com.idealista.drone.comun.Direccion
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * Clase que prueba el comportamiento de las operaciones sobre un dron
 *
 * @author Miguel Gomez Cuesta
 * @since 1.0.0
 */
@Title("Tests sobre operaciones del drone")
class OperacionesDroneTest extends Specification {

    @Subject
    OperacionesDrone operacionesDrone;

    private cartografia = Mock(Cartografia.class);

    def setup() {
        operacionesDrone = new OperacionesDrone(cartografia);
    }

    def "obtener urbanizaciones con rango negativo"() {
        when: "consulta urbanizaciones"
        int[] urbanizaciones = operacionesDrone.obtenerUrbanizaciones(1, 1, -1)
        then:
        0 * cartografia.obtenerAdyacente(_, _)
        0 * cartografia.obtenerIdentificadorUrbanizacion(_, _)
        urbanizaciones.length == 0
    }

    def "obtener urbanizaciones con rango 0 y origen urbanizacion 13"() {
        given:
        cartografia.obtenerIdentificadorUrbanizacion(38.56889d, 40.511107d) >> 13
        when: "consulta urbanizaciones"
        List<Integer> urbanizaciones = operacionesDrone.obtenerUrbanizaciones(38.56889d, 40.511107d, 0)
        then:
        urbanizaciones.size() == 1
        urbanizaciones.containsAll(Arrays.asList(13))
    }

    def "obtener urbanizaciones con rango 1 y origen urbanizacion 13"() {
        given:
        cartografia.obtenerIdentificadorUrbanizacion(38.56889d, 40.511107d) >> 13
        getCartografiaConDosNiveles()
        when: "consulta urbanizaciones"
        List<Integer> urbanizaciones = operacionesDrone.obtenerUrbanizaciones(38.56889d, 40.511107d, 1)
        then:
        urbanizaciones.size() == 9
        urbanizaciones.containsAll(Arrays.asList(7, 8, 9, 12, 13, 14, 17, 18, 19)
        )
    }

    def "obtener urbanizaciones con rango 1 y origen urbanizacion 12"() {
        given:
        cartografia.obtenerIdentificadorUrbanizacion(30.56889d, 40.511107d) >> 12
        getCartografiaConDosNiveles()
        when: "consulta urbanizaciones"
        List<Integer> urbanizaciones = operacionesDrone.obtenerUrbanizaciones(30.56889d, 40.511107d, 1)
        then:
        urbanizaciones.size() == 9
        urbanizaciones.containsAll(Arrays.asList(6,7, 8, 11,12, 13, 16, 17, 18)
        )
    }


    def "obtener urbanizaciones con rango 2"() {
        given:
        cartografia.obtenerIdentificadorUrbanizacion(38.56889d, 40.511107d) >> 13
        getCartografiaConDosNiveles()
        when: "consulta urbanizaciones"
        List<Integer> urbanizaciones = operacionesDrone.obtenerUrbanizaciones(38.56889d, 40.511107d, 2)
        then:
        urbanizaciones.size() == 25
        urbanizaciones.containsAll(IntStream.range(1, 26).boxed().collect(Collectors.toList()))
    }

    /**
     * Mockear la cartografia para simular un escenario con 2 niveles
     */
    private void getCartografiaConDosNiveles() {
        cartografia.obtenerAdyacente(7, Direccion.ARRIBA) >> 2
        cartografia.obtenerAdyacente(7, Direccion.ABAJO) >> 12
        cartografia.obtenerAdyacente(7, Direccion.IZQUIERDA) >> 6
        cartografia.obtenerAdyacente(7, Direccion.DERECHA) >> 8

        cartografia.obtenerAdyacente(8, Direccion.ARRIBA) >> 3
        cartografia.obtenerAdyacente(8, Direccion.ABAJO) >> 13
        cartografia.obtenerAdyacente(8, Direccion.IZQUIERDA) >> 7
        cartografia.obtenerAdyacente(8, Direccion.DERECHA) >> 9

        cartografia.obtenerAdyacente(9, Direccion.ARRIBA) >> 4
        cartografia.obtenerAdyacente(9, Direccion.ABAJO) >> 14
        cartografia.obtenerAdyacente(9, Direccion.IZQUIERDA) >> 8
        cartografia.obtenerAdyacente(9, Direccion.DERECHA) >> 10

        cartografia.obtenerAdyacente(12, Direccion.ARRIBA) >> 7
        cartografia.obtenerAdyacente(12, Direccion.ABAJO) >> 17
        cartografia.obtenerAdyacente(12, Direccion.IZQUIERDA) >> 11
        cartografia.obtenerAdyacente(12, Direccion.DERECHA) >> 13

        cartografia.obtenerAdyacente(13, Direccion.ARRIBA) >> 8
        cartografia.obtenerAdyacente(13, Direccion.ABAJO) >> 18
        cartografia.obtenerAdyacente(13, Direccion.IZQUIERDA) >> 12
        cartografia.obtenerAdyacente(13, Direccion.DERECHA) >> 14

        cartografia.obtenerAdyacente(14, Direccion.ARRIBA) >> 9
        cartografia.obtenerAdyacente(14, Direccion.ABAJO) >> 19
        cartografia.obtenerAdyacente(14, Direccion.IZQUIERDA) >> 13
        cartografia.obtenerAdyacente(14, Direccion.DERECHA) >> 15

        cartografia.obtenerAdyacente(17, Direccion.ARRIBA) >> 12
        cartografia.obtenerAdyacente(17, Direccion.ABAJO) >> 22
        cartografia.obtenerAdyacente(17, Direccion.IZQUIERDA) >> 16
        cartografia.obtenerAdyacente(17, Direccion.DERECHA) >> 18

        cartografia.obtenerAdyacente(18, Direccion.ARRIBA) >> 13
        cartografia.obtenerAdyacente(18, Direccion.ABAJO) >> 23
        cartografia.obtenerAdyacente(18, Direccion.IZQUIERDA) >> 17
        cartografia.obtenerAdyacente(18, Direccion.DERECHA) >> 19

        cartografia.obtenerAdyacente(19, Direccion.ARRIBA) >> 14
        cartografia.obtenerAdyacente(19, Direccion.ABAJO) >> 24
        cartografia.obtenerAdyacente(19, Direccion.IZQUIERDA) >> 18
        cartografia.obtenerAdyacente(19, Direccion.DERECHA) >> 20

        //Laterales segundo nivel
        cartografia.obtenerAdyacente(2, Direccion.IZQUIERDA) >> 1
        cartografia.obtenerAdyacente(2, Direccion.DERECHA) >> 3

        cartografia.obtenerAdyacente(3, Direccion.IZQUIERDA) >> 2
        cartografia.obtenerAdyacente(3, Direccion.DERECHA) >> 4

        cartografia.obtenerAdyacente(4, Direccion.IZQUIERDA) >> 3
        cartografia.obtenerAdyacente(4, Direccion.DERECHA) >> 5

        cartografia.obtenerAdyacente(22, Direccion.IZQUIERDA) >> 21
        cartografia.obtenerAdyacente(22, Direccion.DERECHA) >> 23

        cartografia.obtenerAdyacente(23, Direccion.IZQUIERDA) >> 22
        cartografia.obtenerAdyacente(23, Direccion.DERECHA) >> 24

        cartografia.obtenerAdyacente(24, Direccion.IZQUIERDA) >> 23
        cartografia.obtenerAdyacente(24, Direccion.DERECHA) >> 25


    }
}
