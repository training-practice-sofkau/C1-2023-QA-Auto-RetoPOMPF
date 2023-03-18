Feature: Reservar paquete disney
  Yo como usuario de la pagina web despegar
  quiero ir a la pagina de paquetes de disney
  para reservar un  paquete de disney

  Scenario: reserva paquete para tres días
    Given que necesito un paquete para 2 adultos y 2 menores
    When seleccione fecha y la informacion
     Then debo observar la reserva generada con exito

  Scenario: reserva paquete para 6 días
    Given que necesito un paquete para 2 adultos y 1 menor
    When seleccione fecha y la informacion requerida
    Then debo obtener la reserva generada con exito
