Feature: Vuelo Normal en chrome
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo

  Scenario: Reserva exitosa con 4 pasajeros
    Given que debo llevar 4 personas en este viaje
    When este en la pagina web de despegar
    And seleccione un vuelo llenando los formularios
    Then debe observar que el vuelo se ha reservado exitosamente

  Scenario: vuelo urgente a Montague para 1 adulto y 1 menor de 10
    Given Estoy en la pagina de despegar
    When selecciono un vuelo para el dia de hoy a Montague
    Then debo observar un mensaje de no disponibilidad de vuelos
