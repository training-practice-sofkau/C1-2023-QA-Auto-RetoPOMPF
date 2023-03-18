Feature: Acceso a chat de asesoría en linea

  Scenario: acceder al chat de asesoria desde el boton flotante
    Given que estoy en la pagina principal de zonafit
    When doy clic en el boton flotante ubicado en la parte derecha de la pantalla
    And selecciono la opcion Necesitas asesoria
    Then soy redirigido a la pagina para la asesoria