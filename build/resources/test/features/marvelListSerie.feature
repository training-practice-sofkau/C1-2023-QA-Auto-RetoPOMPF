Feature: Obtener todas las series de marvel
  yo como usuario de la Api de Marvel
  quiero obtener todas las series de marvel
  para poder visualizar las series


  @ListaSeries
  Scenario: Obtener todas las series de marvel con exito
    Given que soy un usuario de la API de marvel
    When el ususario solicito obtener todas las series de marvel
    Then la API responde una lista de todas las series de marvel.


  @ListaSeriesFallida
  Scenario: Error al obtener todas las series de Marvel
    Given que soy un usuario de la API de Marvel Universe
    When el usuario  obtiene todas las series de marvel
    Then la API responde error en la solicitud


