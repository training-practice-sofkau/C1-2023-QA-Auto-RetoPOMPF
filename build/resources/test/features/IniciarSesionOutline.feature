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
    When  hago click enn el boton de "acceder/registrarse"
    And ingreso mi correo electronico "<correo>" y mi contrasena "<contrasena>"
    And hago click enn el boton dee "Acceder"
    Then deberia ser redirigido nuevamente a la pagina principal y visualizar el "nombre" de usuario

    Examples:
      | correo                         | contrasena |
      | BobMarley@reggae.com          | azuca12345 |
      | bryan123@gmail.com            | bryan2329  |
      | homerosimpson@hotmail.com     | lisa4567   |
      | willsmith@gmail.com           | will9876   |
