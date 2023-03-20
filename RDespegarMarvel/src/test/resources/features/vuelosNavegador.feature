Feature: Reservar un vuelo normal
  Yo como usuario de la página web despegar
  quiero ir a la página de reservas de vuelo
  para poder reservar un vuelo de ida y vuelta


  Scenario Outline: Reservación exitosa con 3 pasajeros adultos
    Given que estoy en la web de despegar con el navegador <navegador>
    And necesito un vuelo de Medellin a Cali
    When seleccione el vuelo mas barato
    Then debera mostrar un mensaje de reserva de vuelos exitosa

    Examples:
      | navegador |
      | "Edge"    |
      | "Chrome"  |