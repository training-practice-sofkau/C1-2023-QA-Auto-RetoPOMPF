Feature: comprar vuelo en Latam
  Yo como usuario de latam
  quiero diligenciar el formulario
  para comprar vuelos de ida y vuelta

  Scenario: Vuelo MDE-CLO
    Given el usuario ingresa a la pagina web de Latam
    When diligencia el formulario con Medellin y Cali como ciudades de origen y destino
    Then retorna un mensaje con el resumen de la informacion de los vuelos

