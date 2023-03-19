Feature: Consultar historias id
  yo como usuario de los servicios de marvel
  quiero realizar peticiones
  para poder obtener informacion de las historias de marvel

  @first
  Scenario Outline: Consulta exitosa
    Given tengo la id <id> de una historia
    When envio una peticion con la id de la historia
    Then debo obtener una respuesta con la historia con es id
    Examples:
      | id      |
      | "31445" |
      | "26024" |
      | "18454" |

  @first
  Scenario Outline: Consulta fallida
    Given tengo la id <id> de una historia invalida
    When envio una peticion con la id invalida de la historia
    Then debo obtener un mensaje de error de historia no encontrada
    Examples:
      | id  |
      | "1" |
      | "2" |
      | "3" |