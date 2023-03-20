Feature: Obtener datos de COVID-19 de EE.UU.
  Como usuario
  Quiero obtener datos diarios de COVID-19 de EE.UU.
  Para tomar decisiones informadas sobre mi salud

  Scenario: Obtener datos de COVID-19 de EE.UU.
    Given que tengo la URL del servicio COVID-19 de EE.UU.
    When realizo una solicitud GET al servicio
    Then la respuesta debe ser exitosa
    And la respuesta debe contener datos diarios de COVID-19 de EE.UU.
