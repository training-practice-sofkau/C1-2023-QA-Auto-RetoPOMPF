Feature: viaje exitoso
  yo como usuario de la web de latam
  quiero comprar tiquetes
  para realizar viajes

  Scenario Outline: viaje exitoso
    Given que estoy en la pagina principal de latam usando el <navegador>
    When realizo todo el flujo de compra para <cantidad> adultos saliendo desde <salida> hasta <llegada> y seleccionando la <categoria>
    Then selecciono pago con tarjeta de credito y recibo un mensaje de confirmacion
    Examples:
    |cantidad|navegador|salida        |llegada        |categoria          |
    |3       |"chrome" |"bogota, bog" |"cali, clo"    |"economy premium"  |
    |4       |"edge"   |"cali, clo"   |"bogota, bog"  |"economy"          |
    |5       |"chrome" |"cali, clo"   |"medellin, mde"|"economy"          |