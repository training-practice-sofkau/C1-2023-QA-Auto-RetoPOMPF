Feature: Reservar un vuelo normal
  Yo como usuario de la página web despegar
  quiero ir a la página de reservas de vuelo
  para poder reservar un vuelo de ida y vuelta

  Scenario: Reservación exitosa con 3 pasajeros adultos
    Given que debo llevar tres personas en el viaje por "Chrome"
    When seleccione vuelos con  origen
    Then debera mostrar un mensaje de reserva exitosa



