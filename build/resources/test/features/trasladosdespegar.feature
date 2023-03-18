    #Traslado
    Feature: Reservar el traslado vehicular
      yo como usuario de la pagina web despegar
      quiero dirigirme al modulo de traslado
      para poder reservar un transporte desde el aeropuerto al destino

      Scenario Outline: Reserva de traslado vehicular
        Given el usuario esta en la pagina despegar seccion traslados
        When el usuario registra la informacion de los campos en la pagina web
        And completa con nombre<aeropuerto>, destino<hotel>, fecha<fecharegistro>, pasajero<cantidadPasajero>
        Then debe mostrar una tabla con la informacion ingresada

        Examples:
          | aeropuerto   | hotel      | fecharegistro | cantidadPasajero |
          | matecania    | Soratama   | 25 Dic 2023    |  4              |
          | Los Garzones | Sol        | 25 May 2023    |  4              |




      Scenario: Solicitud de reserva invalida
        Given el usuario esta en la pagina despegar seccion traslados
        When selecciona un lugar de destino fuera del pais
        Then deberia obtener un mensaje exceda el limite de distancia del traslado