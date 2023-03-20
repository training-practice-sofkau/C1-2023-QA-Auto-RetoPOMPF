Feature: Obtener listas de historias filtrada
  yo como usuario de la Api de Marvel
  quiero obtener una lista de historias de marvel
  para poder revisar las historias


  @ListaSeries
  Scenario: Obtener lista de historias por id de marvel exitosa
    Given soy usuario la API de marvel
    When el ususario envio una peticion para la lista de historias
    Then deberia mostrar una lista de historias filtrada por id
