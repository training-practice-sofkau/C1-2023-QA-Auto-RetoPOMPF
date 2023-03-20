Feature: Consulta de pruebas negativas de anticuerpos de COVID-19 en North Dakota

  Scenario: Obtener las negativeTestsAntibody para North Dakota
    Given el cliente esta configurado para conectarse a la API de CovidTracking
    When el cliente realiza una solicitud GET para North Dakota
    Then se debe recibir una respuesta con codigo de estado 200
    And la respuesta debe contener el campo negativeTestsAntibody