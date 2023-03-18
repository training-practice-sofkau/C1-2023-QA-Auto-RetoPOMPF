Feature: Flujo de compra
  yo como usuario de zona fit
  quiero hacer una compra
  para mantener mi dieta regulada

  Scenario: Compra por categoria
    Given Estoy en la pagina principal de zona fit en el "chrome"
    When Pongo el mouse sobre el boton categoria y escojo la opcion proteinas limpias
    And escojo los productos que deseo llevar y modifico su cantidad
    And Doy click en finalizar compra y hago el proceso hasta el pago
    Then Redirige a la pagina final en donde nos indica el numero de convenio