Feature: Reservar un vuelo
  Yo como usuario de la pagina web despegar
  Quiero dirigirme a la seccion de compras de vuelo
  Para poder reservar un vuelo

  Scenario: Reserva exitosa de un vuelo
    Given el usuario esta en la pagina principal y selecciona la opcion de vuelos usando  "Edge"
    When seleccione su destino y llena el formulario
    Then debe observar que el vuelo se ha reservado exitosamente
