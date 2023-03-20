
Feature: Registro de nuevo Usuario en la pagina ZonaFit
  Yo como administrador de la pagina ZonaFit
  Quiero registrarme con mi correo y contrasena
  para verificar que puedo registrarme en la pagina de forma exitosa

  //Cambiar la palabra "navegador" por el navegador que desea usar
  //EJEMPLO:
  //Google Chrome = "chrome"
  //Microsoft Edge = "edge"

Scenario: Registrarse en ZonaFit
  Given que estoy en la pagina de registro de ZonaFit desde "chrome"
  When  hago clic en el boton de "acceder/registrarse"
  And ingreso mi informacion personal valida en su campo correspondiente como direccion de correo electronico, contrasena y confirmar contrasena.
  And hago clic en el boton de "registrarse"
  Then debo recibir un mensaje de confirmacion de "registro exitoso"