Feature: Formulario suscripcion a newsletter
  Yo como cliente de la pagina de ZonaFit
  Quiero poder suscribirme al newsletter
  Para poder recibir noticias, eventos o promociones relevantes

  /**
  Google Chrome = "chrome"
  Microsoft Edge = "edge"
  */

  @NewsletterExitoso
  Scenario: Suscribirse al newsletter exitosamente
    Given que el cliente esta en la pagina principal con "edge"
    When ingresa credenciales posteriormente envia el formulario
    Then mostrara un mensaje de confirmacion indicando que ha sido suscrito al newsletter