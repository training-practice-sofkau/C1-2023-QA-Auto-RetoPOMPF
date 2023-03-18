Feature: Registro de un usuario en ZonaFit

  Yo como cliente nuevo de la pagina de ZonaFit
  Quiero poder registrarme
  Para poder iniciar sesion en la plataforma y comprar productos

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  @RegistroExitoso
  Scenario: Registro de un nuevo usuario
    Given que el cliente se encuentra en la pagina de registro de ZonaFit
    When ingresa credenciales posteriormente presiona clic en el boton Registrarse
    Then mostrara un mensaje de confirmacion del registro