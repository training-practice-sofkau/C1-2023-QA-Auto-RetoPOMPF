#Disney

Feature: Reserva de paquetes Disney en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme al modulo de disney
  para poder reservar un paquete  tematico disney

  Scenario: Solicitud de reserva paquete disney por cinco dias
    Given el usuario esta en la pagina despegar seccion Disney
    When el usuario elige la fecha de entrada y registra la informacion
    Then deberaa obtener un mensaje de confirmacion de la reserva

  Scenario: Solicitud de reserva paquete disney por siete dias
    Given el usuario esta en la pagina despegar modulo Disney
    When el usuario elige la fecha  y registra la informacion solicitada
    Then deberia mostrar un mensaje de confirmacion de la reserva