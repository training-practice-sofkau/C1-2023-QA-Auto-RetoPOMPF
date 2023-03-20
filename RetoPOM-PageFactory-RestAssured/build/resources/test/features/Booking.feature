Feature: Validar flujo de compra de vuelos
  Yo como usuario de una pagina de vuelos
  Quiero validar la compra de un vuelo
  Para comprar los tiquetes

  Scenario Outline: Compra de un tiquete de ida y vuelta agregando equipaje
    Given estoy en la pagina web deseada usando un navegador "<navegador>"
    When selecciono los destinos y la cantidad de pasajeros
    And se agrega una cantidad de equipaje "<cantidad equipaje>"
    Then ingreso mis datos e informacion de pago

    Examples:
      | navegador | cantidad equipaje |
      | edge      | 3                 |
      | chrome    | 4                 |