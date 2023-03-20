Feature: Comprar en linea
  Yo como cliente de la pagina de ZonaFit
  Quiero agregar varios productos a mi carrito de compras
  Para poder ahorrar tiempo y acceder a mas productos disponibles

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  Background:
    Given que el cliente se encuentra en la pagina principal con "chrome"
    When agrega varios productos al carrito

  @CompraExitosa
  Scenario: Compra Exitosa
    And completa la informacion del formulario de facturacion
    Then mostrara un mensaje confirmando la compra

  @CompraNoExiosa
  Scenario: Compra no exitosa por campo con valor invalido
    And completa un campo con un dato invalido
    Then mostrara un mensaje de error indicando el campo obligatorio al ingresar un dato invalido