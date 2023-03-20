Feature: Compra de productos ZonaFit
  yo como cliente de la tienda virtual zonafit
  necesito comprar comprar productos en el outlet
  con el fin de hacer uso de ellos

  Background:
    Given Que el cliente se encuentra en la pagina principal de la tienda zonafit


  Scenario: Medio de pago baloto
    When El cliente selecciona los producto y ingresa la informacion requerida dejando como medio de pago la opcion baloto
    Then El sistema debera mostrar la pagina de confirmacion de compra

