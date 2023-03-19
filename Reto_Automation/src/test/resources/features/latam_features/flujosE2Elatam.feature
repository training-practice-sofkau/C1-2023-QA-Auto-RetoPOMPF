
Feature: Compra de vuelos en Latam Airlines

  Scenario: Comprar un vuelo basico con 3 pasajeros
    Given Given que estoy en la pagina de Latam Airlines
    When he ingresado los detalles de mi viaje
    And he ingresado los datos de los pasajeros
    Then se muestra la descripcion del viaje en el modulo de pagar
