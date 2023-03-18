Feature: Obtener la lista de NFTs de CoinGecko

  Como usuario interesado en los NFTs,
  Quiero obtener una lista de los NFTs disponibles en CoinGecko
  Para poder conocer los NFTs populares y estar al día con las últimas tendencias


  Scenario: Obtener la lista de NFTs disponibles
    Given que tengo acceso a la API de CoinGecko
    When hago una peticion GET al endpoint que lista NFTS
    Then la respuesta debe ser un codigo de estado doscientos OKK
    And el cuerpo de la respuesta debe incluir un objeto JSON con la lista de NFTs disponiblesy su informacion

  Scenario Outline: Obtener la lista de NFTs filtrado por el id de la blockchain
    Given que tengo acceso a la API de CoinGecko y tengo el id de la blockchain a filtrar
    When hago una peticion GET al endpoint que lista con el parametro de "<id>" para filtrar
    Then la respuesta debe ser un codigo de estado doscientos OK
    And el cuerpo de la respuesta debe incluir un objeto json que contenga los nfts filtrados
    Examples:
      | id                  |
      | ethereum            |
      | binance-smart-chain |
      | polygon-pos         |
