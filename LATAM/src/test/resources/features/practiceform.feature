Feature: Apartar vuelos para dos adultos y un ninnos
  Yo como un usuario interesado en viajar con mi familia en LATAM Airlines
  quiero escoger el detino del vuelo y registrar la informacion de mi familia
  para poder apartar un vuelo

  Scenario Outline: Registro exitoso
    Given  que el usuario esta en la pagina Web LATAM Airlines
    When escoge los destinos <ida> y <vuelta>
    And complementa los campos con la informacion de la familia
    Then debe observar un mensaje de bienvenida de la LATAM
    Examples:
      | ida         | vuelta      |
      |"medellin"   |"santa marta"|
      |"santa marta"|"medellin"   |
      |"medellin"   |"cartagena"  |
