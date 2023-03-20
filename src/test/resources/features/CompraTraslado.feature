Feature: Reservar opcion traslados
  Yo como usuario de la página web despegar
  Quiero dirigirme a la sección de  traslados
  Para poder reservar  un traslado


  Scenario: Reserva primer traslado disponible  mas economico
    Given el usuario está en la página principal y selecciona la opcion   de traslado mas economica usando "edge"
    When llena los campos requeridos para la opcion mas economica
    Then debe observar que la reserva del traslado se ha realizado exitosamente para la opcion mas ecnomica


 # Scenario: Reserva segundo traslado disponible   mas economico
  #  Given el usuario está en la página principal y selecciona la  segunda opcion de traslado mas economica
   # When seleccione la segunda opcion mas economica
    # Then debe observar que la reserva del traslado se ha realizado exitosamente para la segunda opcion mas economica
