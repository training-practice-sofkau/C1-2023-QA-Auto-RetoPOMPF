Feature: Obtener  listado de comics de Marvel
  yo como usuario de la Api de Marvel
  quiero obtener todos los comics  de marvel
  Para visualizar los comics de Marvel


  Scenario: Obtener todos los comics de Marvel de forma exitosa
    Given que soy el usuario de la API de marvel
    When  se splicita el listado de comics de marvel
    Then se deberian visualizar todos los comics de marvel


  #Scenario: Error al obtener todas las series de Marvel
   # Given que soy un usuario de la API de Marvel Universe
    #When el usuario  obtiene todas las series de marvel
    #Then la API responde error en la solicitud