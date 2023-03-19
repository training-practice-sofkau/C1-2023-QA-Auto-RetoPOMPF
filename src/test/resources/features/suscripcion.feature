Feature: Suscripcion

  Background:
    Given que estoy en la pagina principal de zonafit.co

  Scenario Outline: suscribirme al newsletter
    When bajo hasta la parte inferior de la pagina
    And lleno el formulario de suscribirse con "<email>", "<name>" y "<phone>" y le doy clic al boton suscribirse
    Then observo un texto que dice ¡Gracias por suscribirse! en la misma pagina
    Examples:
      | email           | name  | phone     |
      | james@gmail.com | James | 123456789 |
      | Juan@gmail.com  | Juan  | 987654321 |
      | Arley@gmail.com | Arley | 555555555 |
