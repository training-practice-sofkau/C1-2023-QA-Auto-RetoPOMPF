Feature: Suscripcion
  yo como cliente de ZonaFit
  quiero realizar la suscripción al newsletter
  para recibir novedades


  //cambie la palabra "navegador" por la palabra det navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

  Scenario Outline: suscribirme al newsletter
    Given que estoy en la pagina principal del "<navegador>"
    When bajo hasta la parte inferior de la pagina
    And lleno el formulario de suscribirse con "<email>", "<name>" y "<phone>" y le doy clic al boton suscribirse
    Then observo un texto que dice Gracias por suscribirse en la misma pagina
    Examples:
      | email               | name    | phone     | navegador |
      | Juanisimo@gmail.com | Juaneis | 123456789 | chrome    |
      | Jamesimo@gmail.com  | jeims   | 987654321 | edge      |
      | Arleysimo@gmail.com | Arleis  | 555555555 | chrome    |