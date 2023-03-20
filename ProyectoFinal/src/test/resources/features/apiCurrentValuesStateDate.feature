Feature: Consultar datos de un estado por fecha
  Yo como administrador de la API COVID Tracking
  Quiero obtener los datos sobre COVID-19 de un estado y fecha en especifico
  Para poder conocer el estado de la propagacion del COVID-19

  @ObtenerDatosExitoso
  Scenario: Obtener datos de un estado del norte para el segundo trimestre del año 2020
    Given que el administrador ingresa el estado y fecha
    When envia una solicitud valida tipo GET a la API
    Then debera recibir una respuesta con un estado ok