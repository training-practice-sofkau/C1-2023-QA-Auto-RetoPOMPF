Feature: Busqueda y reservar de un tiquete en despegar
  yo como usuario de la pagina web despegar
  quiero dirigirme a la sección de compras de vuelo
  para poder reservar un vuelo


  @ViajeCucutaBogota
  Scenario Outline:Origen Cucuta Destino Bogota exitosa de un vuelo
    Given el usuario esta en la pagina principal de despegar en la opcion vuelos
    When  el usuario selecciona el lugar de origen-destino,  opcion ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, y clase de tiquete, opcion buscar
    And el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos  nombre <nombre>, apellido <apellido>,  pais de resisencia <pais>, documento <documento> fecha de nacimiento dia<dia> mes<mes> anio<anio> genero<genero>
    Then el usuario debera observar un mensaje reserva exitosa
    Examples:
      | nombre | apellido | pais     | documento | dia | mes | anio | genero    |
      | Juan   | Perez    | Colombia | 101010101 | 12  | 03  | 1990 | Masculino |
   #   | Maria  | Garcia    | Mexico    | 202020202 | 23  | 07  | 1985 | Femenino  |
    #  | Pedro  | Rodriguez | Argentina | 303030303 | 05  | 11  | 1998 | Masculino |
     # | Ana    | Gomez     | Chile    | 404040404 | 30  | 01  | 1992 | Femenino  |
      #| Luis   | Hernandez | Colombia | 505050505 | 15  | 09  | 1988 | Masculino |

  @ViajeCali
  Scenario: Destino Medellin exitosa de un vuelo
    Given el usuario esta en la pagina principal de despegar.com opcion vuelos "Edge"
    When  el usuario elije un lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar
    And el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos
    Then el usuario debera ver un mensaje reserva exitosa

  @ReservaFallida
  Scenario: Reserva fallida de un vuelo primera clase
    Given el usuario se encuentra en la pagina principal  de despegar
    When el usuario elije el lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar
    Then el usuario debera observar un mensaje no hay vuelos disponibles

  @ReservaConEscala
  Scenario: Reserva un vuelo con escala
    Given el usuario se encuetra en la pagina principal de despegar.com "Chrome"
    When   el usuario selecciona  lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar
    And el usuario elije el vuelo, indica el equipaje, elije la opcion con escala, realiza el checkout con sus datos
    Then debera observar un mensaje vuelo reservado con escala




