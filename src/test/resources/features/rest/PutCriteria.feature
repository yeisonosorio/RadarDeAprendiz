Feature: Actualizacion de criteria
  Como usuario de la pagina Radar
  Quiero realizar una actualizacion a las criterias
  Para verificar el correcto funcionamiento del servicio

  @ActualizarComentarios
  Scenario Outline: Actualizacion exitosa de las criterias
    Given que el usuario se encuentraa en la pagina de radar
    When el usuario envia una solicitud PUT con el id "<id>" el area "<area>" el name "<name>" el descriptor "<descriptor>" el minQualiRequired "<minQualiRequired>"
    Then el usuario visualiza las criterias actualizados
    Examples:
      | id                       | area        | name                     | descriptor  | minQualiRequired |
      | 6447380df992bad2ff2f5ac4 | practice    | Best practice/Clean code | Clean codee | 3                |
      | 644738bcf992bad2ff2f5ac8 | Server-Side | Server-Side/Java         | Javac       | 4                |