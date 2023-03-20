Feature: Obtener los datos de hospitalizaciones diarias en Estados Unidos
  Como usuario
  Quiero obtener los datos de hospitalizaciones diarias en Estados Unidos
  Para conocer la evolución de la pandemia

  Scenario: Obtener los datos de hospitalizaciones diarias exitosamente
    Given que el usuario tiene acceso al servicio de COVID Tracking API
    When el usuario solicita los datos de hospitalizaciones diarias en Estados Unidos
    Then el servicio responde con un codigo de respuesta 200
    And el servicio responde con datos de hospitalizaciones diarias validos
