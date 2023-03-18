Feature: Inicio de sesión
  yo como cliente de la tienda ZonaFit
  quiero iniciar sesión en mi cuenta
  para ingresar a mi perfil y ver mi listado de pedidos

  //cambie la palabra "navegador" por la palabra del navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

  Background:
    Given que el cliente esta en la pagina principal desde el "chrome"
    When navega hasta la opcion de inicio de sesion

  Scenario: Login Exitoso
    And ingresa las credenciales correctas
    Then debera redireccionarse a su perfil

  Scenario: password incorrecto
    And ingresa las credenciales con una password incorrecto
    Then debera observar un mensaje de error
