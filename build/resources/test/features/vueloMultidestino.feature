Feature: Completar datos para realizar una compra de un vuelo multidestino en Despegar.com.co
  Como usuario de la pagina web despegar.com.co
  Quiero  Quiero completar los datos necesarios
  Para reservar y comprar un vuelo multidestino

  Scenario: Completar datos y realizar la compra de un vuelo multidestino
    Given que estoy en la página de Despegar.com.co
    When busco y selecciono un vuelo demultidestino desde Armenia - Santa Marta - Medellin,para tres adultos
    And proporciono la información necesaria
    Then debo recibir un mensaje que indique que puedo pagar a traves de Efecty

  Scenario:  No hay vuelos disponibles en las rutas elegida en primera clase
    Given que estoy en la página principal de Despegar.com.co
    When busco y selecciono un vuelo de ida y vuelta desde Armenia a Santa Marta para 8 adultos
    Then debo ver un mensaje indicando que no se encontraron vuelos con asientos disponibles para su busqueda
