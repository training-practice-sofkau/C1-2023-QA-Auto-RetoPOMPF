Feature: Obtener una serie de Marvel por ID
  yo como usuario de la API de Marvel
  quiero solicito obtener una serie de Marvel por ID
  para poder visualizar la información de la serie

  @SeriePorIdExitosa
  Scenario: Obtener una serie de Marvel por ID con éxito
    Given que soy un usuario de la API de Marvel
    And tengo el ID de la serie de Marvel
    When solicito obtener la serie de Marvel por ID
    Then la API responde la informacion correspondiente


  @SeriePorIdFallida
  Scenario: Error al obtener una serie de Marvel por ID
    Given que soy un usuario de la API de Marvel con credenciales incorrectas
    And tengo el ID de una serie de Marvel
    When solicito obtener la serie de Marvel por el ID
    Then la API responde error al obtener la informacion

