Feature: Obtener lista de eventos de marvel por ID de historia
  yo como usuario de la API de marvel
  quiero listar eventos de marvel por ID de historia
  para poder visualizar la informacion de eventos

  @EventosPorIddeComic
  Scenario: Obtener lista de eventos filtradas por id de historia
    Given que soy un usuario de los  eventos de la API de marvel
    When solicito obtener eventos filtrados por historia
    Then la API retorna el evento por id de comic