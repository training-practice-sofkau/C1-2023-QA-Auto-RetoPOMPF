Feature: Obtener cómics de un personaje de Marvel
  Como administrador de la API de Marvel
  Quiero obtener los comics de un personaje de Marveñ
  Para ver su informacion

  Scenario: Obtener comics de un personaje específico
    Given que tengo acceso a la API de Marvel con credenciales validas
    And he obtenido el ID un personaje de Marvel
    When realizo una solicitud de la informacion especifica
    Then la respuesta deberia incluir una lista de comics