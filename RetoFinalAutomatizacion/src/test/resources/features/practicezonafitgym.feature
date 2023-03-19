Feature:
  yo como cliente de la tienda ZonaFit
  quiero comprar enaks a traves de la pagina web
  para ahorrar tiempo y comodidad

  //cambie la palabra "navegador" por la palabra del navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

  Background:
    Given que el usuario se encuentra la pagina principal desde el "chrome"
    When agrega productos de la categoria snacks al carrito

  Scenario: Compra de Snacks Exitosa
    And completa la informacion necesaria de envio y facturacion
    Then debera recibir un mensaje de confirmacion de la compra


  Scenario: Compra de Snacks con informacion insuficiente
    But ingresa informacion imcompleta
    Then debera recibir un mensaje pidiendo la informacion requerida


