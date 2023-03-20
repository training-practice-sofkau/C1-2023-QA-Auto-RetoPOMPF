
Feature: Iniciar sesion en la pagina ZonaFit
          Yo como administrador de la pagina ZonaFit
          Quiero iniciar sesion con mi correo y contrasena
          para verificar que puedo acceder a mi cuenta de forma exitosa

  //Cambiar la palabra "navegador" por el navegador que desea usar
  //EJEMPLO:
  //Google Chrome = "chrome"
  //Microsoft Edge = "edge"

Scenario: Iniciar sesion en ZonaFit
  Given que estoy en la pagina principal de ZonaFit  desde "edge"
  When  hago click en el boton de "acceder/registrarse"
  And ingreso mi informacion personal valida en su campo correspondiente como direccion de correo electronico y contrasena
  And hago click en el botonn de "Acceder"
  Then deberia ser redirigido a la pagina principal y visualizar el "nombre" de usuario