Feature: Obtener datos de COVID-19 en los Estados Unidos
  Como usuario de la API de COVID Tracking Project
  Quiero poder obtener los datos diarios de COVID-19 en los Estados Unidos

  Scenario: Obtener los datos diarios de COVID-19 en los Estados Unidos
    Given que tengo la URL del servicio "https://api.covidtracking.com/v1/us/daily.json"
    When envio una solicitud GET al servicio
    Then el codigo de respuesta debe ser 200
    And la respuesta debe contener un JSON con la informacion de los datos diarios de COVID-19 en los Estados Unidos
