Feature: Comprar en linea
  Yo como cliente de la pagina de ZonaFit
  Quiero agregar varios productos a mi carrito de compras
  Para poder ahorrar tiempo y acceder a mas productos disponibles

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  @CompraExitosa
  Scenario: Compra Exitosa
    Given que el cliente se encuentra en la pagina principal con "chrome"
    When agrega varios productos al carrito
    And completa la informacion del formulario de facturacion
    Then mostrara un mensaje confirmando la compra