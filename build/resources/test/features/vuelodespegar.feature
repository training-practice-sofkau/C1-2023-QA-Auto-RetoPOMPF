Feature: Reservar un vuelo en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo

  Scenario: Reserva exitosa de un vuelo
    Given el usuario esta en la pagina registro de vuelo con "Chrome"
    When selecciona lugar origen y de destino
    Then deberia obtener un mensaje de confirmacion de la reserva


  Scenario: Solicitud de reserva de vuelos en fecha no disponibles
    Given el usuario esta en la pagina registro de vuelo con navegador "Edge"
    When selecciona lugar origen y de destino de llegada
    Then deberia obtener un mensaje de confirmacion de la reserva de la web
