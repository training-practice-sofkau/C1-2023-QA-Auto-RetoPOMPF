Feature: Reservar opcion Disney
  Yo como usuario de la página web despegar
  Quiero dirigirme a la sección de  Disney
  For poder reservar  un plan de Disney


  Scenario: Reserva entrada cuatro dias
    Given el usuario está en la página principal y selecciona la opcion de plan cuatro dias
    When seleccione su tipo de entrada y llena los datos en el plan de cuatro dias
    Then debe observar que la reserva se ha realizado exitosamente para el plan de cuatro dias


  Scenario: Reserva entrada cinco días
    Given el usuario esta en la página principal y selecciona la opcion de plan cinco dias
    When seleccione su tipo de entrada y llena los datos en el plan de cinco dias
    Then debe observar que la reserva se ha realizado exitosamente par el plan de cinco dias