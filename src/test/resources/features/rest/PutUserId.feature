Feature: Actualizacion Exitosa de usuarios
  Como usuario de la pagina Radar
  Quiero realizar una actualizacion a los usuarios actuales del sistema
  Para verificar el correcto funcionamiento del servicio

  @ActualizarComentarios
  Scenario Outline: Actualizacion exitosa de usuarios
    Given que el usuario se encuentra en la pagina de radar de aprendices
    When el usuario envia una solicitud PUT con el id "<id>" el uid "<uid>" el email "<email>" el name "<name>" el estadoActivado "<activate>" y el role "<role>"
    Then el usuario visualiza los usuarios actualizados
    Examples:
      | id                       | uid  | email                 | name          | activate | role    | codigo |
      | 64485e0a08039d97d917e2fc | 1234 | yulis2323@hotmail.com | yuliss        | true     | student | 200    |
      | 6447d67bf992bad2ff2f5b90 | 4321 | rodrigo123@gmail.com  | rodrigo crack | true     | coach   | 200    |