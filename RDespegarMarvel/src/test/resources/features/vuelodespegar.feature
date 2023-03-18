Feature: Reservar un vuelo normal
  Yo como usuario de la página web despegar
  quiero ir a la página de reservas de vuelo
  para poder reservar un vuelo de ida y vuelta

  Scenario: Reservación exitosa con 3 pasajeros adultos
    Given que debo llevar  3 personas en el viaje
    When este en la pagina web de despegar
    And seleccione un vuelo
    Then deberá mostrar un mensaje de reserva exitosa

  Scenario Outline: Reservación de vuelo con 2 adultos y 1 menor
    Given que el usuario se encuentra en la página de vuelos
    When selecciona el origen <origen>,destino <destino>, fecha de ida <fechaida> y vuelta <fechavuelta>
    Then deberá mostrar un mensaje indicando vuelos no disponibles

    Examples:
      | origen    | destino   | fechaida     | fechavuelta  |
      | "ipiales" | "cali"    | "27/03/2023" | "28/03/2023" |
      | "ipiales" | "leticia" | "27/03/2023" | "28/03/2023" |
      | "ipiales" | "pasto"   | "27/03/2023" | "28/03/2023" |

