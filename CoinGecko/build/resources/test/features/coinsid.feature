Feature: Obtener la informacion de una criptomoneda
  Yo como usuario de una API
  quiero hacer una peticion GET
  para ver la informacion de una criptomoneda

  Scenario Outline: Peticion exitosa
    Given que el usuario esta en la API coingecko
    When manda una peticion GET con <id> validos
    Then debe observar el <name> de la criptomoneda y un <status>
    Examples:
      | id                |name               | status |
      | "01coin"          | "01coin"          |200     |
      | "0chain"          |  "Zus"            |200     |
      | "0vix-protocol"   |  "0VIX Protocol"  |200     |

  Scenario: Peticion fallida
    Given que el usuario esta en la API coningecko
    When manda una peticion GET con id invalidos
    Then debe observar un mensaje de error y un status 404 not found