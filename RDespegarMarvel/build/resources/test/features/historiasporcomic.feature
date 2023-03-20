Feature: Obtener lista de historias de marvel por ID de comic
      yo como usuario de la API de marvel
      quiero listar una historia de marvel por ID
      para poder visualizar la informacion de historias

  @HistoriaPorIdComic
  Scenario: Obtener lista de historias filtradas por id de comic
    Given que soy un usuario de historias de la API de marvel
    When solicito obtener historias filtradas por comic
    Then la API retorna la historia por id de comic

