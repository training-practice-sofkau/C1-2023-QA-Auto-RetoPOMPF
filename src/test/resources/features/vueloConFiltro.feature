Feature: Filtrar vuelos segun necesidad
  Como un usuario que desea reservar un vuelo
  Quiero filtrar los resultados de búsqueda
  Para encontrar las opciones de vuelo que mejor se adapten a mis necesidades

  Scenario: Filtrar vuelos para que se adapte a mis preferencias
    Given que estoy en la pagina de Despegar.com.co
    When busco y selecciono un vuelo de ida y vuelta desde Pereira a Santa Marta para tres adultos
    And Selecciono la aerolinea con la que deseo viajar
    Then los resultados de búsqueda muestran opciones de vuelo que cumplen con mis criterios de aerolínea

  Scenario: Encontrar vuelos con cualquier fecha más barata
    Given que estoy en la pagina de Despegar.com.co
    When busco y selecciono un vuelo de ida y vuelta desde Armenia a Santa Marta para 6 adultos en cualquier fecha mas barata en un mes determinado
    And filtro por el numero de escalas
    Then los resultados de búsqueda muestran opciones de vuelo que cumplen con mis criterios filtro


