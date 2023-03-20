Feature: Reservar  asistencia de vuelo
  Yo como usuario de la página web despegar
  quiero ir a la página de asistencia de asistencias
  para reservar una asistencia

  Scenario: reserva de asistencia nacional para 4 personas
    Given que necesito asistencia  para 4 personas
    When seleccione asistencia nacional
    Then debo obtener un mensaje de reserva de asistencia exitosa

  Scenario: reserva de asistencia nacional para 5 personas
    Given que el usuario se encuentra en la página de asistencia
    When que necesito asistencia  para 4 personas
    Then debe observar un mensaje de reserva de asistencia exitosa
