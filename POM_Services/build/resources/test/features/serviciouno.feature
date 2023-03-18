Feature: Servicio de registros diarios
  yo estadista universitario
  quiero obtener los reportes diarios
  para poder hacer graficos del comportamiento de la pandemia

  Scenario: Lista recibida correctamente
    Given El reportero esta en la pagina
    When hace la peticion al servicio diario
    Then recibe una lista con los reportes diarios