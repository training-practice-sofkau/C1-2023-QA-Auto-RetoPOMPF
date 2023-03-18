Feature: Busqueda y reservar de un tiquete multidestino en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo


  @ReservaMultidestinoCucutaMedellinCucuta
  Scenario: Reserva exitosa de armar tu tiquete
    Given el usuario esta en la pagina principal  de despegar
    When el usuario selecciona multidestino, el tramo uno de origen-destino, fecha salida, cantidad de pasajeros, tramo dos opcion destino, fecha salida,   opcion buscar, clase de tiquete
    And el usuario selecciona el vuelo, indica el equipaje y realiza el checkout con sus datos
    Then el usuario debera observar una reserva del vuelo exitosa


  @ReservaMultidestinoBogotaPereiraBogota
  Scenario: Reserva exitosa de armar tu tiquete
    Given el usuario esta en la pagina principal  de despegar opcion vuelo
    When el usuario elije multidestino, el tramo uno de origen-destino, fecha salida, cantidad de pasajeros , tramo dos opcion destino, fecha salida,   opcion buscar, clase de tiquete
    And el usuario toma el vuelo, indica el equipaje y realiza el checkout con sus datos
    Then el usuario debera observar una reserva del vuelo

