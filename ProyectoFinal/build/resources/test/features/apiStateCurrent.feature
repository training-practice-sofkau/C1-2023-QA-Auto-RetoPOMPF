Feature: Consultar informacion general por cada uno de los estados
  Yo como administrador de la API COVID Tracking
  Quiero obtener los datos sobre COVID-19 agrupados por estado
  Para poder conocer el estado de propagacion del COVID-19 en cada estado

  @ObtenerDatosExitoso
  Scenario: Obtener datos agrupados por estado hasta la fecha
    Given que el administrador invoca a la API
    When envia una solicitud valida tipo GET en la API
    Then debera recibir una respuesta con estado ok