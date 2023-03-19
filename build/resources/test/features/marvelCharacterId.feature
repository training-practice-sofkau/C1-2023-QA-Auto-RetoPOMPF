Feature: Obtener informacion de un personaje de Marvel
  Como administrador de la API de Marvel
  Quiero buscar un persona por Id
  Para ver su informacion

  Scenario: Consultar informacion de un personaje de Marvel
    Given que tengo acceso a la API de Marvel con credencial valida
    When realizo una solicitud de la informacion
    Then deberia recibir una respuesta con informacion detallada del personaje
