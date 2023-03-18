Feature: Cambio de contrasena
  yo como usuario de zona fit
  quiero cambiar mi contrasena
  para mantener mi cuenta segura

  Scenario: Cambio de contrasena
    Given Estoy en la pagina principal de zona fit en el "chrome"
    When Hago click en el boton con mi nombre de usuario
    And doy click en detalles de cuenta
    And hago el proceso de cambio de clave y guardo los cambios
    Then Se recarga la pagina y sale un mensaje de que la informacion se cambio