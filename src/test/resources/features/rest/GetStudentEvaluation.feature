Feature: Probar el servicio GET de la pagina de radar
  Como usuario de la pagina radar
  Quiero probar el servicio que muestra todos las evaluaciones de estudiantes
  Para verificar su funcionamiento

  Scenario Outline:  Hacer peticion GET para ver todos las evaluaciones de estudiantes
    Given que el usuario tienne acceso a los servicios API REST de la pagina Radar
    When el usuario envia una solicitud GET para ver las evaluaciones de estudiantes por su id "<id>"
    Then el usuario debe recibir un codigo de estado 200
    And la respuesta JSON debe mostrar las evaluaciones de estudiantes
    Examples:
      | id                       |
      | 644978fff786c5becdea48d7 |