Feature: compra de suplementos  en ZonaFit
  yo como cliente de ZonaFit
  quiero poder comprar suplementos
  para mejorar mi entrenamiento

  //Uso de Navegadores:
  //Google Chrome= google
  //Microsoft Edge= edge

  Background:
    Given que estoy en el sitio web de ZonaFit con "google"
    When procedo a agregar al carrito los productos de mi interes

  Scenario:Realizar una compra exitosa
    And ingreso todos mis datos personales y selecciono el metodo de pago
    Then debo ver un mensaje de confirmacion de compra exitoso

  Scenario:Realizar una compra fallida debido a datos personales faltantes
    And dejo un campo en blanco en la informacion requerida
    Then debo ver un mensaje indicando el error

