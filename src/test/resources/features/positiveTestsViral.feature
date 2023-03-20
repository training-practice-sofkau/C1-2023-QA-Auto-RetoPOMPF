Feature: COVID-19 API Service

  Scenario: Obtener positiveTestsViral de North Dakota
    Given El endpoint del servicio COVID-19 API es "https://api.covidtracking.com"
    When Realizo una solicitud GET para el estado "North Dakota"
    Then Deberia recibir una respuesta con el numero de positiveTestsViral