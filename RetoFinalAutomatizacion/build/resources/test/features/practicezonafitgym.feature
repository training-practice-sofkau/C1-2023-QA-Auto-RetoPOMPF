Feature:
  yo como cliente de la tienda ZonaFit
  quiero comprar elementos de gym en casa a traves de la pagina web
  para ahorrar tiempo y comodidad

  //cambie la palabra "navegador" por la palabra del navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

  Scenario: Compra Exitosa
    Given que el cliente se encuentra en la pagina principal desde el navegador "chrome"
    When agrega productos de la categoria gym en casa al carrito
    And completa la informacion necesaria de envio y facturacion
    Then debera recibir un mensaje de confirmacion de la compra

