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
      | email             | name | phone     | navegador |
      | jaDSDSm@gmail.com | Jam  | 123456789 | chrome    |
      | JuSDSDS@gmail.com | Ju   | 987654321 | edge      |
      | ADSDSrl@gmail.com | Arl  | 555555555 | chrome    |