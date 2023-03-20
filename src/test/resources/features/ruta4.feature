Feature: Iniciar sesion en la pagina web de ZonaFit
  yo como cliente de ZonaFit
  quiero poder iniciar sesion en la pagina web
  para poder acceder a mi cuenta

  //Uso de Navegadores:
  //Google Chrome= google
  //Microsoft Edge= edge

  Scenario Outline: Iniciar sesion exitosamente con diferentes usuarios
    Given que estoy en la pagina de ZonaFit en "navegador"
    And doy click en el boton de acceder-registrarse
    When  ingreso el correo electronico <correo> y la contrasenna <contrasenna> y accedo
    Then deberia ser redirigido nuevamente a la pagina principal con mi sesion ya iniciada

    Examples:
      | correo                  | contrasenna |
      | "kojax16899@loongwin.com" | "7916"       |
      | "wolas13759@loongwin.com" | "1970"       |
      | "jaxoxe4265@necktai.com"  | "2002"       |