Feature: Obtener datos de COVID-19
  Yo como usuario
  Quiero obtener datos actualizados de COVID-19
  Para estar informado sobre la situacion de la pandemia

  Scenario: Obtener datos de COVID-19 por estado
    Given que el usuario hace una solicitud GET a la API de datos COVID-19
    When la solicitud se realiza para obtener los datos de COVID-19 por estado
    Then se debe devolver una respuesta exitosa con los datos de COVID-19 por estado
