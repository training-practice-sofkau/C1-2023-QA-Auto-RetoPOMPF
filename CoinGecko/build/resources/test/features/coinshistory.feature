Feature: Obtener el historial de una criptomoneda
  Yo como usuario de la API
  Quiero hacer una peticion GET
  Para ver el historial de la criptomoneda

  Scenario Outline: Peticion exitosa
    Given que el usuario esta en la API coingecko
    When manda una peticion GET con <id> y <date> validos
    Then debe observar <symbol> de la criptomoneda y <status>
    Examples:
      |       id        |      date     | symbol | status |
      | "01coin"        | "01-01-2023"  | "zoc"  |   200  |
      | "0chain"        | "02-01-2023"  | "zcn"  |   200  |
      | "0vix-protocol" | "03-01-2023"  | "vix"  |   200  |


  Scenario: Peticion fallida
    Given que el usuario esta en la API Coingecko
    When manda una peticion GET con id valido y date incompleto
    Then debe observar un mensaje de error y un status 400 bad request
