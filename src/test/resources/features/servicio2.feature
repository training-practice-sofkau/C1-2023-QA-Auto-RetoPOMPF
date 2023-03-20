Feature: Obtener los datos de COVID-19 de un estado y una fecha específicos
  Como usuario de la API de COVID Tracking Project
  Quiero poder obtener los datos de COVID-19 de un estado y una fecha específicos
  Para poder analizar la situación de dicho estado en una fecha determinada

  Scenario: Obtener los datos de COVID-19 de California el 1 de mayo de 2020
    Given que hago una peticion GET a "https://api.covidtracking.com/v1/states/ca/20200501.json"
    When la peticion es exitosa
    Then el codigo de respuesta es 200
    And el cuerpo de la respuesta contiene la informacion de COVID19 del estado de California el 1demayode2020
