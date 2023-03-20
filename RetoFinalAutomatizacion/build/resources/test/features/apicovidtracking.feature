Feature: Listar información california
  yo como administrador de la pagina CovidTracking
  quiero obtener información del COVID de los estados de EEUU
  para conocer la situación actual resumida de cada estado

  Background:
    Given que el administrador esta en la pagina

  Scenario: Obtener informacion del estado de California
    When hace una solicitud a la API para el estado CA
    Then debera recibir una respuesta que contenga los datos de COVID para CA

  Scenario: Verificar mensaje error
    When hace una solicitud a la API incorrecta
    Then debera recibir una respuesta de error
