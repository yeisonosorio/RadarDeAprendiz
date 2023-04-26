Feature: Probar el servicio GET de la pagina de radar
  Como usuario de la pagina radar
  Quiero probar el servicio que muestra todos los radares
  Para verificar su funcionamiento

  Scenario:  Hacer peticion GET para ver todos los radares
    Given que el usuariio tiene acceso a los servicios API REST de la pagina Radar
    When el usuario envia una solicitud GET para ver todos los radares
    Then el usuario deberia recibir un codigo de estado 200
    And la respuesta JSON debe mostrar todos los radares