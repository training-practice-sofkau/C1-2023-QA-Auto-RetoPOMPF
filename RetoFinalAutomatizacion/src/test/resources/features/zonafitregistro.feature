Feature:Formulario de Registro
  yo como cliente de la tienda ZonaFit
  quiero registrarme en en el formulario de registro
  para poder loguerme en la web

  //cambie la palabra "navegador" por la palabra del navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

Background:
  Given que el cliente esta en la pagina principal desde el "chrome"
  When navega hasta la opcion del formulario de registro

  Scenario: Registro Exitoso
    And completa todos los campos requeridos
    Then debera redireccionarse a su perfil

  Scenario: Registro fallido
    And completa todos los campos con un password de confirmacion diferente
    Then debera observar un mensaje de error las contraseñas no coinciden
