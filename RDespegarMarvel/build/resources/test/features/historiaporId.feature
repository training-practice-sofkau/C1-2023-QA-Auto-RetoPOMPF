Feature: Obtener lista de historias por Id
  yo como usuario de la API de marvel
  quiero listar historias de marvel por ID
  para poder visualizar la informacion de historia

  @EventosPorIddeComic
  Scenario: Obtener lista de historias por id
    Given que soy un usuario de la API de marvel
    When solicito obtener historias filtrados por id
    Then la API retornara la historia por id