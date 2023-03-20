Feature: Obtener datos diarios de COVID en Estados Unidos
  Yo como administrador de la pagina covidtracking
  Quiero obtener los datos diarios de COVID en Estados Unidos
  Para poder estar informado y hacer un censo sobre la situación actual

Scenario: Obtener los datos diarios de COVID en Estados Unidos
  Given que el administrador esta en la pagina
  And   desea obtener los datos diarios de COVIDen Estados Unidos
  When  hace una peticion GET al servicio
  Then el sistema devuelve un JSON con los datos diarios de COVIDen Estados Unidos