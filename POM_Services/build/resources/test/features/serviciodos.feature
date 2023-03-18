Feature: Servicio de registros por estados
  yo estadista universitario
  quiero obtener los reportes por estados
  para poder informar correctamente las decisiones estatales

  Scenario: Lista recibida correctamente
    Given El reportero esta en la pagina
    When hace la peticion al servicio por estados
    Then recibe una lista con los reportes por estados