Feature: Reservar un vuelo normal
  Yo como usuario de la página web despegar
  quiero ir a la página de reservas de vuelo
  para poder reservar un vuelo de ida y vuelta

  Scenario: Reservación exitosa con 3 pasajeros adultos
    Given que debo llevar tres personas en el viaje por "Chrome"
    When seleccione vuelos con  origen
    Then debera mostrar un mensaje de reserva exitosa

  Scenario Outline: Reservación de vuelo con dos adultos y un menor
    Given que el usuario se encuentra en la página de vuelos
    When selecciona el origen <origen>, destino <destino>, fecha de ida <fechaida> y vuelta <fechavuelta>
    Then debera mostrar un mensaje indicando vuelos no disponibles

    Examples:
      | origen    | destino   | fechaida     | fechavuelta  |
      | "ipiales" | "cali"    | "27/03/2023" | "28/03/2023" |
      | "ipiales" | "leticia" | "27/03/2023" | "28/03/2023" |
      | "ipiales" | "pasto"   | "27/03/2023" | "28/03/2023" |

