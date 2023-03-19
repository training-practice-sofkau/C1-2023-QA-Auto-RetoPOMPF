Feature: viaje exitoso
  yo como usuario de la web de latam
  quiero comprar tiquetes
  para realizar viajes

  Scenario Outline: viaje exitoso
    Given que estoy en la pagina principal de latam usando el <navegador>
    When realizo todo el flujo de compra para <cantidad> adultos saliendo desde <salida> hasta <llegada>
    Then confirmo la informacion antes de realizar la compra
    Examples:
    |cantidad|navegador|salida        |llegada      |
    |3       |"chrome" |"bogota, bog" |"cali, clo"  |
    |4       |"edge"   |"cali, clo"   |"bogota, bog"|