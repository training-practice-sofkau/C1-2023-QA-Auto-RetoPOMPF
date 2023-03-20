Feature: Obtener comic por ID
  yo como usuario de la API de Marvel
  quiero solicito obtener una serie de Marvel por ID
  para poder visualizar la información de la serie


  Scenario: Obtener un comic  de Marvel por ID exitosamente
    Given que soy un usuario de la API de Marvel y estoy usando el servicio de obtener comic por id
    When solicito obtener un comic  de Marvel por ID
    Then la API deberia responder con el comic solicitado