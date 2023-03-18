Feature: Listar mercados por id
  yo como usuario de la pagina web CoinGecko
  quiero obtener informacion sobre los servicios de intercambio de criptomonedas disponibles en la plataforma
  para realizar un analisis y seguimiento del volumen de intercambio de criptomonedas en esos mercados

  Scenario: Servicio de intercambios existente
    Given el usuario accede al servicio Get exchanges de coingeko
    When realiza una peticion al servicio, ingresando un id de mercado intercambio valido
    Then retorna un codigo de status OK
    And lista la informacion del meracado de criptomonedas elegido


  Scenario: Servicio de intercambio inexistente
    Given el usuario ingresa al servicio Get exchanges de coingeko
    When realiza una peticion al servicio ingresando un id invalido
    Then Retorna un codigo de estatus Not Found

