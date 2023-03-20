Feature: Obtener informacion de compañias publicas
  yo como usuario de la pagina web CoinGecko
  quiero obtener informacion sobre compañias publicas inmersas en el mercado de criptomonedas
  para realizar un analisis y seguimiento de los movimientos, de Bitcoin y Ethereum de estas empresas en el mercado

  Background:
    Given el usuario ingresa a la pagina web de coingecko

  Scenario: id valido
    When realiza una peticion GET con un id valido
    Then retorna un codigo status OK
    And se lista la informacion de las empresas publicas

    Scenario: id invalido
      When realiza una peticion Get ingresando un id invalido
      Then retorna un codigo de Status Not Found
