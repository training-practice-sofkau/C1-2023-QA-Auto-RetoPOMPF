Feature: Reservar vuelo en premium economy
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compra de vuelos
  para poder reservar un viaje en primera clas

  Scenario: Reserva exitosa 2 adultos premium economy
    Given que quiero viajar en premium economy
    When seleccione un vuelo de este tipo
    And llene el formulario
    Then debe recibir un mensaje de confimacion del vuelo

  Scenario: Reserva exitosa 8 adultos premium economy
    Given tengo 8 personas para viajar
    When seleccione un vuelo de tipo premium economy para 8
    And llene el formulario para cada persona
    Then debe recibir un mensaje de confimacion de reserva del vuelo