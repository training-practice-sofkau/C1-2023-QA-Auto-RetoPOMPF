Feature: Acceso a la pagina
  yo como usuario de zona fit
  quiero ingresar a mi cuenta
  para comprar mis suplementos habituales

  Background:
    Given Estoy en la pagina principal de zona fit en el "navegador"

  Scenario: Log-In exitoso
    When Hago click en el boton acceder
    And Ingreso mi correo y contrasena
    Then Vuelve a la pagina principal y muestra mi nombre de usuario en boton donde estaba el acceso

  Scenario: Log-In fallido
    When Hago click en el boton acceder
    And Ingreso mi correo y contrasena incorrecta
    Then En la parte superior sale un mensaje de error con un boton de perdiste tu contrasena

  Scenario: Log-Out exitoso
    When Hago click en el boton con mi nombre de usuario
    And Hago click en cerrar sesion
    Then Vuelve a la pagina principal y muestra el boton de acceder