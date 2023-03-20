Feature:  Busqueda y reservar de un tiquete en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo


  @ReservaTiqueteCualquierFecha
  Scenario: Reservar un tiquete exitoso en cualquier fecha dada por la pagina
    Given el usuario esta en la pagina principal  de despegar.com
    When  el usuario selecciona el lugar de origen-destino,  opcion ida, opcion cualquier fecha mas barata, opcion buscar
    And  el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos
    Then el usuario debe observar una reserva del vuelo


  @TiqueIdaYVuelta
  Scenario: Reservar un tiquete exitoso en cualquier fecha dada por la pagina con la aerolinea
    Given el usuario esta en la pagina principal de despegar
    When  el cliente elije el lugar de origen-destino, ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, clase de tiquete, opcion buscar
    And el usuario selecciona la aeroplinea, elije el vuelo, indica el equipaje y realiza el checkout con sus datos
    Then el usuario debe observar un mensaje reserva exitosa
