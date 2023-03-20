Feature: Obtener la lista de series de marvel
  yo como usuario de la Api de Marvel
  quiero obtener la lista completa de las series de marvel
  para ver las series


  @ListaSeries
  Scenario: Obtener la lista de series de marvel
    Given soy usuario de la API de marvel
    When el ususario solicita tener las series de marvel
    Then deberia mostrar una lista con todas las series
