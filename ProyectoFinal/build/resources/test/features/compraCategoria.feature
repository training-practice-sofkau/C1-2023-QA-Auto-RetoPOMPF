Feature: Productos de la categoria aminoacidos
  Yo como cliente de la página de ZonaFit
  Quiero agregar productos de la categoria de aminoacidos al carrito de compras
  Para poder realizar una compra en linea para ahorrar tiempo y acceder a mas productos disponibles

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  @CategoriaAminoacidos
  Scenario: Compra exitosa con productos de la categoria de aminoacidos
    Given que el cliente esta en la pagina de inicio con "edge"
    When agrega varios productos al carrito de la categoria de aminoacidos
    And completa los datos del formulario de facturacion
    Then mostrara un mensaje de confirmacion de la compra