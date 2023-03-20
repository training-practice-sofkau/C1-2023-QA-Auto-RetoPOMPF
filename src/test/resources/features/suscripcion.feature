Feature: Suscripcion

  Background:
    Given que estoy en la pagina principal de zonafit.co

  Scenario Outline: suscribirme al newsletter
    When bajo hasta la parte inferior de la pagina
    And lleno el formulario de suscribirse con "<email>", "<name>" y "<phone>" y le doy clic al boton suscribirse
    Then observo un texto que dice Gracias por suscribirse en la misma pagina
    Examples:
      | email             | name | phone     |
      | jaDSDSm@gmail.com | Jam  | 123456789 |
      | JuSDSDS@gmail.com | Ju   | 987654321 |
      | ADSDSrl@gmail.com    | Arl  | 555555555 |
