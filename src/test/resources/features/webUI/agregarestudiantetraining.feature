Feature: Agregar estudiante al Training  League
  yo como coach de la pagina de radar de sofka
  quiero agregar a una estudiante al training League
  para poder registrar mis aprendices en las ligas


  Scenario Outline: Agregar Estudiante al Training League exitoso
    Given el coach  esta en el login de la pagina de radar para ingresar
    When el coach envia las credenciales <email> <password> para  ingresar
    And procede a agregar al estudiante a un training
    Then el coach debe poder ver un <mensaje> de estudiante agregado creado
    Examples:
      | email              | password   | mensaje                            |
      | "yeison@gmail.com" | "holahola" | "Success add: student@student.com" |


  Scenario Outline: Agregar Estudiante al Training League fallido
    Given el coach  esta en el login de la pagina
    When el coach envia las credenciales correctas   <email> <password> para  ingresar
    And procede a agregar al estudiante a un training league
    Then el coach debe poder ver un <mensaje> de error
    Examples:
      | email              | password   | mensaje                            |
      | "yeison@gmail.com" | "holahola" | "Failed add: student@student.com" |