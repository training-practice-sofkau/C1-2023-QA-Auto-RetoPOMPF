Feature: Suscripcion

  Background:
    Given que estoy en la pagina principal de zonafit.co

  Scenario: suscribirme al newsletter
    When bajo hasta la parte inferior de la pagina
    And lleno el formulario de suscribirse con mis datos y le doy clic al boton suscribirse
    Then observo un texto que dice gracias por suscribirte en la misma pagina

  Scenario: suscripcion fallida al newsletter
    When bajo hasta la parte inferior de la pagina
    And lleno el formulario de suscribirse con mis datos y le doy clic al boton suscribirse
    Then observo un texto que dice correo electronico no es valido