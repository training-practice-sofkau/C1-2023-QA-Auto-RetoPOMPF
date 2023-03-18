Feature: Inicio de sesion
  Yo como cliente registrado en la pagina de ZonaFit
  Quiero poder iniciar sesion en mi cuenta
  Para poder ingresar a mi informacion personal y realizar compras

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  @LoginExitoso
  Scenario Outline: Iniciar sesion en la pagina de ZonaFit
    Given que el cliente se encuentra en la pagina de inicio de sesion de ZonaFit con "navegador"
    When ingresa el correo electronico <correo> y la contrasena <contrasena> posteriormente presiona el boton Iniciar Sesion
    Then mostrara su informacion personal y realizar compras

    Examples:
      | correo                | contrasena  |
      | "ejemplo@correo.com"  | "1234abcd"  |
      | "usuario@ejemplo.com" | "qwerty123" |