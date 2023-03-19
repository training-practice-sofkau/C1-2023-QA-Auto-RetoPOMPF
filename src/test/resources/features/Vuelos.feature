Feature: Reservar alojamiento
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de alojamientos
  para poder reservar un hospedaje

  @Second
  Scenario Outline: Reserva exitosa de un vuelo
    Given que estoy en la pagina de despegar con el navegador <navegador>
    And que necesito un vuelo con origen "Bogota" y destino "Barranquilla"
    When seleccione el vuelo mas barato disponible
    Then debe observar que el vuelo se ha reservado exitosamente
  Examples:
      | navegador |
      | "Chrome"  |
      | "Edge"    |