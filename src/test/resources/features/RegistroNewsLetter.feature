Feature: Registro en el newsletter de ZonaFit
  Yo como administrador de la pagina ZonaFit
  Quiero registrarme en el Newsletter de la pagina
  para verificar que puedo recibir noticias, eventos y descuentos de la pagina zonafit de forma exitosa

  //Cambiar la palabra "navegador" por el navegador que desea usar
  //EJEMPLO:
  //Google Chrome = "chrome"
  //Microsoft Edge = "edge"

  Scenario: Un usuario se registra en el newsletter de ZonaFit para recibir actualizaciones y promociones de la tienda de suplementos

    Given que el administador se encuentra en la pagina de inicio de ZonaFit desde "chrome"
    When el usuario hace scroll hacia el final de la pagina de inicio
    And se le solicita que ingrese en el campo correspondiente su direccion de correo electronico, su nombre completo y su celular.
    And hace clic en el boton "Suscribete"
    Then el sistema deberia mostrar el siguiente mensaje "¡Gracias por suscribirse!"

