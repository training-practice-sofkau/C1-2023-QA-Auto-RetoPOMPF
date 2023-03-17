Feature: Obtener el historial de datos de mercado de una criptomoneda mediante API CoinGecko

  Como usuario de la API de CoinGecko
  Quiero obtener el historial de precios,market cap y volumen de una criptomoneda
  Para poder mostrarlo en mi aplicación

  Scenario: Obtener los datos de mercado con un id de criptmoneda valido
    Given Tengo los parametros validos id, vs_currency y days
    When hago una petición GET al endpoint con los parametros
    Then la respuesta debe ser un código de estado 200 OK
    And el cuerpo de la respuesta debe incluir un objeto json con los datos de la criptomoneda

  Scenario: Obtener los datos de mercado con un id de criptomoneda inexistente
    Given que tengo un id de criptomoneda inexistente
    When hago una petición GET al endpoint con el id inexistente
    Then la respuesta debe ser un código de estado 404 Not Found
    And el cuerpo de la respuesta debe incluir un objeto json con un mensaje de error adecuado