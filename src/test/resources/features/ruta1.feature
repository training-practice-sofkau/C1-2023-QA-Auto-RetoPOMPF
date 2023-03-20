Feature: compra de suplementos  en ZonaFit
  yo como cliente de ZonaFit
  quiero poder comprar suplementos
  para mejorar mi entrenamiento

  //Uso de Navegadores:
  //Google Chrome= google
  //Microsoft Edge= edge

  Background:
    Given que estoy en el sitio web de ZonaFit con "navegador"
    When procedo a agregar al carrito los productos de mi interes

  Scenario:Realizar una compra exitosa
    And ingreso todos mis datos personales y selecciono el metodo de pago
    Then debo ver un mensaje de confirmacion de compra exitoso


