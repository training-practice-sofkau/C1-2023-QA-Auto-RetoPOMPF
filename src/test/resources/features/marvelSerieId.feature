Feature: Obtener una serie de Marvel por ID
  yo como usuario de la API de Marvel
  quiero solicito obtener una serie de Marvel por ID
  para poder visualizar la información de la serie

  @SeriePorIdExitosa
  Scenario Outline: Obtener una serie de Marvel por id con éxito
    Given que soy un usuario de la API de Marvel
    When solicito obtener la serie de Marvel por <id>
    Then la API responde la informacion correspondiente <id>
    Examples:
      | id      |
      | "26024" |
      | "26023" |
      | "26022" |


