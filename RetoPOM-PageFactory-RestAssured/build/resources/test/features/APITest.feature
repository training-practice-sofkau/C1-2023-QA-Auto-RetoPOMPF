Feature: Obtener las criptomonedas más populares en Coingecko

  Yo como usuario de Coingecko
  Quiero obtener una lista de las criptomonedas mas populares
  Para estar actualizado con las tendencias del mercado

  Scenario: Limitar la cantidad de resultados en la lista de criptomonedas populares
    Given que tengo acceso al listado de criptomonedas populares en Coingecko
    When verifico el listado de las criptos mas populares
    And obtengo una codigo de respuesta exitoso
    Then puedo ver unicamente el nombre y el simbolo de las nueve criptomonedas populares


  Scenario Outline: Obtener informacion detallada de una criptomoneda popular
    Given que tengo acceso a un listado de criptomonedas en Coingecko
    When hago una peticion con el "<id>" de una criptomoneda
    Then obtengo un codigo de respuesta exitoso
    And la respuesta contiene la informacion detallada de la criptomoneda y su valor en USD
    Examples:
      | id              |
      | radiant-capital |
      | hop-protocol    |
      | camelot-token   |
      | optimism        |