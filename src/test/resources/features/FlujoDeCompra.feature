Feature: Seleccion y Compra de productos
  Yo como administrador de la pagina ZonaFit
  Quiero Seleccionar y comprar productos
  Para verificar el flujo de compra de la pagina web

  //Cambiar la palabra "navegador" por el navegador que desea usar
  //EJEMPLO:
  //Google Chrome = "chrome"
  //Microsoft Edge = "edge"

  Scenario: Seleccionar y Comprar productos
    Given estoy en la pagina principal de ZonaFit usando "chrome"
    When selecciono y anado productos al carrito de compras
    And ingreso mis datos personales y el metodo de pago
    Then debo ver un mensaje de confirmacion de compra exitosa.