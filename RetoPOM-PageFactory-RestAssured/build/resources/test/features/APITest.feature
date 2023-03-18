Feature: Obtener las criptomonedas más populares en Coingecko

  Yo como usuario de Coingecko
  Quiero obtener una lista de las criptomonedas mas populares
  Para estar actualizado con las tendencias del mercado

  Scenario: Limitar la cantidad de resultados en la lista de criptomonedas populares
    Given que tengo acceso al listado de criptomonedas populares en Coingecko
    When hago una peticion GET al servicio REST
    And quiero validar la lista de criptomonedas verificando las 5 criptos mas populares
    Then la respuesta deberia ser exitosa




  Scenario: Obtener informacion detallada de una criptomoneda popular
    Given un listado de criptomonedas populares en Coingecko
    And tengo el ID de una criptomoneda especifica
    When hago una peticion GET con el {id} ID de una criptomoneda
    Then la respuesta deberia ser exitosa
    And la respuesta contiene la informacion detallada de la criptomoneda