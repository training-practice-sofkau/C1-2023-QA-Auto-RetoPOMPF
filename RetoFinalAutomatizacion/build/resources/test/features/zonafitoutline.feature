Feature: Suscripción newsletter
  yo como cliente de la tienda ZonaFit
  quiero suscribirme en el formulario newsletter
  para recibir información sobre los suplementos de la tienda

  //cambie la palabra "navegador" por la palabra del navegador que desea usar
  //Google Chrome = "chrome"
  //Microsoft Edge = "Edge"

  Scenario Outline: Suscripcion exitosa
    Given que el cliente se encuentra en la pagina principal desde el "chrome"
    When navega hasta el formulario de suscribete a nuestro newsletter
    And completa los campos con email <email>, nombre <nombre> y telefono <telefono>
    Then debe observar un mensaje de gracias por suscribirse


    Examples:
      | nombre   | email             | telefono     |
      | "Miguel" | "jesus@gmail.com" | "3101234567" |
      | "Jesus"  | "jesus@gmail.com" | "3121234567" |
      | "Mafer"  | "mafer@gmail.com" | "3181234567" |