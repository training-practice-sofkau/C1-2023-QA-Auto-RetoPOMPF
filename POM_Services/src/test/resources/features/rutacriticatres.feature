Feature: Cambio de contrasena
  yo como usuario de zona fit
  quiero cambiar mi contrasena
  para mantener mi cuenta segura
  Background:
    Given Estoy en la pagina principal de zona fit en el "chrome"

  Scenario: Cambio de contrasena
    Given Estoy con mi sesion iniciada
    When Hago click en el boton con mi nombre de usuario
    And doy click en detalles de cuenta
    And hago el proceso de cambio de clave y guardo los cambios
    Then Se recarga la pagina y sale un mensaje de que la informacion se cambio