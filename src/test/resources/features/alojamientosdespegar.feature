Feature: Reservar alojamiento
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de alojamientos
  para poder reservar un hospedaje

  @first
  Scenario: Reserva exitosa 2 habitaciones 3 adultos
    Given que estoy en la pagina de despegar con "Edge"
    And que necesito un alojamiento para mi viaje a "Medellin"
    When seleccione las habitacion llenando los formularios
    Then debe observar que el alojamiento se ha reservado exitosamente

  Scenario: Buscar 1 habitacion para 8 personas en san pablo
    Given  que estoy en la pagina de despegar con "Edge"
    And Tengo 8 personas en el viaje
    When busque una sola habitacion para hospedarse
    Then debo obtener un mensaje de no disponibilidad
