Feature: Completar datos para realizar una compra de un vuelo en Despegar.com.co
  Como usuario de la pagina web despegar.com.co
  Quiero  Quiero completar los datos necesarios
  Para reservar y comprar un vuelo

  Scenario: Completar datos realizar la compra de un vuelo
    Given que estoy en la pagina de Despegar.com.co en navegador 'Chrome'
    When busco, selecciono un vuelo de ida y vuelta desde origen a destino, fechas para dos adultos y un menor
    And proporciono la informacion necesaria
    Then debo recibir un mensaje que indique que puedo pagar a traves de PSE

  Scenario:  No hay vuelos disponibles en la ruta deseada en primera clase
    Given que estoy en la pagina principal de Despegar.com.co en el navegador 'Edge'
    When busco y selecciono un vuelo de ida y vuelta desde origen a destino para tres adultos
    Then veo un mensaje indicando que No hay vuelos disponibles en las rutas elegida en primera clase
