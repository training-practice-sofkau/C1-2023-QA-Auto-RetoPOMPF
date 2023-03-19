Feature: Inicio de sesión en la tienda web de ZonaFit

  Como usuario de la tienda web de ZonaFit,
  quiero poder iniciar sesión con mi correo electrónico y contraseña
  para acceder a mi cuenta y realizar compras.

  //Cambiar la palabra "navegador" por el navegador que desea usar
  //EJEMPLO:
  //Google Chrome = "chrome"
  //Microsoft Edge = "edge"

  Scenario Outline: Iniciar sesión con correo y contraseña

    Given que estoy en la pagina de inicio de sesion de ZonaFit desde "chrome"
    When ingreso mi correo electronico "<correo>" y mi contrasena "<contrasena>"
    And hago clic en el boton Iniciar sesion
    Then debo ser redirigido a mi cuenta de ZonaFit

    Examples:
      | correo                         | contrasena |
      | BobMarley@reggae.com          | azuca12345 |
      | bryan123@gmail.com            | bryan2329  |
      | homerosimpson@hotmail.com     | lisa4567   |
      | willsmith@gmail.com           | will9876   |
