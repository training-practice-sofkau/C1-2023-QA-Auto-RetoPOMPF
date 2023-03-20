Feature: Listar información diaria mas reciente
  yo como administrador de la pagina CovidTracking
  quiero obtener información diaria mas reciente del COVID de los estados de EEUU
  para conocer la situación actual resumida de cada estado

  Background:
    Given que el administrador se encuentra en la pagina

  Scenario: Obtener informacion diaria mas reciente del estado de California
    When realiza una solicitud a la API para el estado CA
    Then debera recibir una respuesta que contenga los datos diarios mas actuales de COVID para CA

  Scenario: Verificar mensaje error
    When envia una solicitud a la API incorrecta
    Then debera recibir una respuesta de error verdadera