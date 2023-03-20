Feature: Busqueda y reservar de un tiquete en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo


  Scenario Outline: Compra exitosa de un vuelo
    Given el usuario esta en la pagina principal de despegar en la opcion vuelos con el vavegador  "Chrome"
    When el usuario selecciona el lugar de origen-destino, opcion ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, y clase de tiquete, opcion buscar
    And el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos nombre <nombre>, apellido <apellido>, documento <documento>
    Then el usuario debera observar un mensaje reserva exitosa de sus tiquetes
    Examples:
      | nombre   | apellido | documento   |
      | "Juan"   | "Perez"  | "101010101" |
      | "Yeison" | "Torre"  | "101010101" |
      | "David"  | "Alta"   | "101010101" |

