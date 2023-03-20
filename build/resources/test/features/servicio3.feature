Feature: Obtener datos del estado de CA
  Como usuario de API Tracking Project
  Quiero poder obtener los datos de COVID-19 de un estado
  Para poder analizar y estar al tanto de la situación de dicho estado

  Scenario: Obtener todos los datos del estado de CA
    Given que el usuario tiene acceso a la API
    When se envia una solicitud GET a "https://api.covidtracking.com/v1/states/ca/current.json"
    Then la respuesta deberia tener un codigo de estado 200
    And la respuesta deberia contener los datos del estado de CA