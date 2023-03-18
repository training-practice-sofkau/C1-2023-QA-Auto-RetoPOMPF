Feature: Cambio de contrasena
  yo como usuario de zona fit
  quiero cambiar mi contrasena
  para mantener mi cuenta segura

  Scenario Outline: Cambio de contrasena
    Given Estoy en la pagina principal de zona fit en el "navegador"
    When Hago click en el boton con mi nombre de usuario
    And doy click en detalles de cuenta
    And ingreso la clave anterior <claveAnterior> y la clave nueva <clave> y guardo los cambios
    Then Se recarga la pagina y sale un mensaje de que la informacion se cambio

    Examples:
    |claveAnterior | clave |
    | "Test.prueba00" | "Prueba.test00" |
    | "Prueba.test00" | "Clave.nueva123" |
    | "Clave.nueva123" | "Prueba.test00" |