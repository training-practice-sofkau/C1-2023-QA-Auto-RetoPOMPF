Feature:consultar la informacion de un intercambio derivado
  yo como administrador de la pagina coingecko
  quiero realizar una peticion al servicio GET/derivate/exchange
  para obtener la informacion de un intercambio derivado especifico

  Scenario Outline: consulta exitosa
    Given que accedo a la pagina de coingecko para usar el servicio GET derivate exchange
    When envio una peticion para ver la informacion del nft con id <id>
    Then recibo un codigo doscientos de respuesta exitosa
    And muestra la informacion del intercambio derivado
    Examples:
      | id                     |
      | "binance_futures"      |
      | "deepcoin_derivatives" |
      | "binance"              |

