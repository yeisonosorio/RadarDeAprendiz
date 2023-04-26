Feature: Probar el servicio GET de la pagina de radar
  Como usuario de la pagina radar
  Quiero probar el servicio que muestra todos los training League
  Para verificar su funcionamiento

  Scenario:  Hacer peticion GET para ver todos los training League
    Given que el usuario tiene acceso a los servicios API REST de la pagina Radar
    When el usuario envia una solicitud GET para ver todos los training League
    Then se debe recibir un codigo de estado 200
    And la respuesta JSON debe mostrar los training League