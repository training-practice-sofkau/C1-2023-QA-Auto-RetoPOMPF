Feature: Conexion con Facebook para ver publicaciones y comentarios de la pagina web ZonaFit
  Yo como cliente de ZonaFit
  Quiero poder ver su cuenta de Facebook
  Para poder ver sus publicaciones, avisos y/o comentarios

  //Uso de Navegadores:
  //Google Chrome= google
  //Microsoft Edge= edge


  Scenario:  Ver publicaciones y comentarios en Facebook desde ZonaFit
    Given que estoy en la pagina web de ZonaFit en "navegador"
    When selecciono la opcion de Facebook
    And me redirecciona a la pagina de facebook de ZonaFit
    Then puedo ver las publicaciones y videos de ZonaFit en su propia pagina

