Feature: Ingreso a la pagina
  yo como usuario de zona fit
  quiero ingresar a mi cuenta
  para comprar mis suplementos habituales

  Scenario: Log-In exitoso
    Given Estoy en la pagina principal de zona fit en el "navegador"
    When Hago click en el boton acceder
    And Ingreso mi correo y contrasena
    Then Vuelve a la pagina principal y muestra mi nombre de usuario en boton donde estaba el acceso

  Scenario: Log-In fallido
    Given Estoy en la pagina principal de zona fit en el "navegador"
    When Hago click en el boton acceder
    And Ingreso mi correo y contrasena incorrecta
    Then En la parte superior sale un mensaje de error con un boton de perdiste tu contrasena