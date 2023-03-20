Feature: Reservar un vuelo
  Yo como usuario de la pagina web despegar
  Quiero dirigirme a la seccion de compras de vuelo
  Para poder reservar un vuelo

  Scenario: Reserva exitosa de un vuelo
    Given el usuario esta en la pagina principal y selecciona la opcion de vuelos usando  "Edge"
    When seleccione su destino y llena el formulario
    Then debe observar que el vuelo se ha reservado exitosamente





    #  Examples:
      # | nombre | apellido   | pais             | cedula     |
     #  | Pepe   | Mojica     | Colombia         |   1000     |
      # | Bart   | Simpson    | Venezuela        |   2000     |
      # | Goku   | Son        |  Colombia        |   3000     |


  #Scenario: No hay vuelos disponibles
   # Given el usuario esta en la pagina principal y selecciona la opcion de vuelos usando "Chrome"
    #When seleccione su destino para el cual no hay vuelos disponibles
    #Then debe observar un mensaje en el que se informe que no hay vuelos disponibles