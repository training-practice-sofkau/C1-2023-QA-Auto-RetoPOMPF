Feature: Compra de productos zona fit
  yo como cliente de la tienda virtual zonafit
  necesito comprar comprar productos en el outlet
  con el fin de hacer uso de ellos

  Background:
    Given que el cliente se encuentra en la pagina principal de la tienda zonafit

  @Scenario1
  Scenario: medio de pago baloto
    When el cliente selecciona los producto y ingresa la informacion requerida dejando como medio de pago la opcion baloto
    Then el sistema debera mostrar la pagina de confirmacion de compra

  @Scenario2
  Scenario: medio de pago efecty
    When el cliente selecciona los productos y ingresa la informacion requerida dejando como medio de pago la opcion efecty
    Then el sistema debera muestra un mensaje de la confirmacion de la compra