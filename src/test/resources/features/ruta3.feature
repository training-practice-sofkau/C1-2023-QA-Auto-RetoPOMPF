Feature: Subscripcion al NewsLetter en la pagina web de ZonaFit
  yo como cliente de ZonaFit
  quiero poder subscribirme a su NewsLetter
  para poder estar pendiente de sus noticias e informacion

  //Uso de Navegadores:
  //Google Chrome= google
  //Microsoft Edge= edge



  Background:
    Given que me encuentro en el  sitio web de ZonaFit con "google"
    When decido subscribirme al NewsLetter

  Scenario: Subscripcion exitosa
    And lleno todos los datos requeridos en el formulario
    Then deberia ver un mensaje de exito diciendo "¡Gracias por suscribirse!"

  Scenario: Subscripcion fallida
    And dejo un campo en blanco de los datos requeridos en el formulario
    Then deberia ver un mensaje de error indicando que la subscripcion no se pudo completar