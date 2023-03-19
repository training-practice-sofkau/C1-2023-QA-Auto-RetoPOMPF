Feature: Validar flujo de compra de vuelos
  Yo como usuario de una pagina de vuelos
  Quiero validar la compra de un vuelo
  Para comprar los tiquetes

  Scenario: Compra de un tiquete de ida y vuelta con 1 adulto, 1 menor y un infante
    Given estoy en la pagina web deseada
    When selecciono los destinos y la cantidad de pasajeros
    And selecciono un vuelo disponible
    Then ingreso mis datos e informacion de pago
