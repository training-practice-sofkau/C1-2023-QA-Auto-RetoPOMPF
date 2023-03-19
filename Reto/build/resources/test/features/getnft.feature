Feature: consultar la informacion de un nft
  yo como administrador de la pagina coingecko
  quiero realizar una peticion al servicio GET/nfts
  para obtener la informacion de un nft especifico

  Scenario: nft mostrado
    Given que accedo a la pagina de coingecko para usar el servicio GET nfts
    When envio una peticion para ver la informacion del nft con id meebits
    Then recibo un codigo ok de respuesta exitoso
    And muestra la informacion del nft

  Scenario: nft no encontrado
    Given que accedo a la pagina de coingecko para usar el servicio de GET nfts
    When envio una peticion para ver la informacion del nft con una id incorrecta
    Then recibo un codigo de respuesta no encontrado
    And muestra un mensaje que informa el nft no se encontro



