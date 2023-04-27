Feature: Crear Training  League
  yo como coach de la pagina de radar de sofka
  quiero crear una training League
  para poder registrar mis aprendices en las ligas


  Scenario Outline: Crear Training League exitoso
    Given el coach  esta en el login de la pagina de radar
    When el coach envia las credenciales <email> <password> para poder ingresar
    And procede a crear un Training envia <titulo> <ciclo>
    Then el coach debe poder ver un <mensaje> de Training creado
    Examples:
      | email              | password   | titulo            | ciclo | mensaje                                |
      | "yeison@gmail.com" | "holahola" | "JAVA DESDE 0"    | "C1"  | "JAVA DESDE 0 created to cicle: C1"    |
      | "yeison@gmail.com" | "holahola" | "NODE DESDE 0"    | "C2"  | "NODE DESDE 0 created to cicle: C2"    |
      | "yeison@gmail.com" | "holahola" | "C DESDE 0"       | "C1"  | "C DESDE 0 created to cicle: C1"       |
      | "yeison@gmail.com" | "holahola" | "ANGULAR DESDE 0" | "C3"  | "ANGULAR DESDE 0 created to cicle: C3" |

  Scenario Outline: Crear Training League repetidos
    Given el coach esta en el login de la pagina  radar de sofka
    When el coach envia las credenciales <email> <password>
    And procede a crear un Training repetidos envia <titulo> <ciclo>
    Then el coach debe ver un <mensaje> de error indicando que no se pudo crear el Training
    Examples:
      | email              | password   | titulo            | ciclo | mensaje                                           |
      | "yeison@gmail.com" | "holahola" | "JAVA DESDE 0"    | "C1"  | "Failed: Only Caoch can Create a Training League" |
      | "yeison@gmail.com" | "holahola" | "NODE DESDE 0"    | "C2"  | "Failed: Only Caoch can Create a Training League" |
      | "yeison@gmail.com" | "holahola" | "C DESDE 0"       | "C1"  | "Failed: Only Caoch can Create a Training League" |
      | "yeison@gmail.com" | "holahola" | "ANGULAR DESDE 0" | "C3"  | "Failed: Only Caoch can Create a Training League" |


  Scenario Outline: Crear Training League con caracteres especiales
    Given el coach esta en el login del sistema de radar de sofka
    When el coach envia las credenciales <email> con el <password>
    And procede a enviar los datos del Training League <titulo> <ciclo>
    Then el coach debe ver un <mensaje> de error indicando que no se permiten caracteres
    Examples:
      | email              | password   | titulo         | ciclo | mensaje                                                                                                                                                               |
      | "yeison@gmail.com" | "holahola" | "[]]]]}"       | "C1"  | "* El titulo no debe contener caracteres especiales, ademas solo puede contar con un espacio entre caracteres, se debe evitar el uso de espacios al comienzo y final" |
      | "yeison@gmail.com" | "holahola" | "////////"     | "C2"  | "* El titulo no debe contener caracteres especiales, ademas solo puede contar con un espacio entre caracteres, se debe evitar el uso de espacios al comienzo y final" |
      | "yeison@gmail.com" | "holahola" | "++**********" | "C1"  | "* El titulo no debe contener caracteres especiales, ademas solo puede contar con un espacio entre caracteres, se debe evitar el uso de espacios al comienzo y final" |


  Scenario Outline: Crear Training League con el Titulo vacio
    Given el coach esta en el login de la pagina de radar de sofka training
    When el coach envia las credenciales <email>, <password> correctas
    And procede a enviar los datos del Training League  <ciclo>
    Then el coach debe ver un <mensaje> de error
    Examples:
      | email              | password   | ciclo | mensaje                         |
      | "yeison@gmail.com" | "holahola" | "C1"  | "* El titulo no puede ir vacio" |
      | "yeison@gmail.com" | "holahola" | "C2"  | "* El titulo no puede ir vacio" |
      | "yeison@gmail.com" | "holahola" | "C1"  | "* El titulo no puede ir vacio" |


  Scenario Outline: Crear Training League con el Ciclo vacio
    Given el coach esta en el login de el sistema de radar
    When el coach envia las credenciales  correcta <email>, <password>
    And procede a enviar los datos del Training League solo <titulo>
    Then el coach debe ver un <mensaje>
    Examples:
      | email              | password   | titulo                | mensaje                        |
      | "yeison@gmail.com" | "holahola" | "JAVA AVANZADO"       | "* El Ciclo no puede ir vacio" |
      | "yeison@gmail.com" | "holahola" | "NODE JS AVANZADO"    | "* El Ciclo no puede ir vacio" |
      | "yeison@gmail.com" | "holahola" | "C AVANZADO"          | "* El Ciclo no puede ir vacio" |
      | "yeison@gmail.com" | "holahola" | "JAVASCRIPT AVANZADO" | "* El Ciclo no puede ir vacio" |


