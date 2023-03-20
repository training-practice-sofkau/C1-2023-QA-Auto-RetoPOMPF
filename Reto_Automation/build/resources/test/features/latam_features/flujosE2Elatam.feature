Feature: Compra de vuelos en Latam Airlines

  Scenario Outline: Comprar un vuelo basico con 4 pasajeros y agregando maleta
    Given Given que estoy en la pagina de Latam Airlines en el navegador "<nav>"
    When he ingresado los detalles de mi viaje con "<origen>"
    And he ingresado los datos de los pasajeros
    Then se muestra el modulo para pagar con PSE
    Examples:
      | nav    | origen       |
      | chrome | Medellin     |
      | edge   | Barranquilla |
      | chrome | Bogota       |