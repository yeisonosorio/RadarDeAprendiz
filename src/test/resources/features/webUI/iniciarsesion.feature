#encoding:UTF-8
#Author: Yeison Ferney Osorio Buitrago


Feature: Iniciar sesion en la pagina radar
  yo como usuario de la pagina
  quiero iniciar sesion para poder usar la pagina
  para poder usar sus servicios

  Scenario Outline: iniciar sesion exitoso
    Given el usuario esta en el inicio de sesion
    When el usuario envia las credenciales <email> <password>
    Then el usuario debe poder ingresar al home de la pagina
    Examples:
      | email              | password   |
      | "yeison@gmail.com" | "holahola" |
      | "juan@gmail.com"   | "123456"   |
      | "111yuli@gmail.com"   | "password" |

  Scenario Outline: Credenciales invalidas
    Given el usuario esta en el inicio de sesion de la pagina
    When el usuario envia credenciales invalidas, como <email> <password_mal>
    Then el usuario debe ver un <mensaje> de error de inicio de sesion
    Examples:
      | email                | password_mal | mensaje |
      | "jota@gmail.com"     | "******"     | "Error" |
      | "perez@gmail.com"    | "1234356"    | "Error" |
      | "tormenta@gmail.com" | "pas2sword"  | "Error" |


  Scenario Outline: Validacion de campos obligatorios password
    Given el usuario esta en el inicio de radar
    When el usuario envia credenciales incompletas con solo el <email>
    Then el usuario debe ver un <mensaje> campo password  obligatorio
    Examples:
      | email              | mensaje                      |
      | "yeison@gmail.com" | "* El password es requerido" |
      | "juan@gmail.com"   | "* El password es requerido" |
      | "yuli@gmail.com"   | "* El password es requerido" |


  Scenario Outline: Validacinn de campos obligatorios email
    Given el usuario esta en el inicio de sesion de la pagina de radar
    When el usuario envia credenciales incompleta con solo el <password>
    Then el usuario debe ver un <mensaje> email es un campo obligatorio
    Examples:
      | password   | mensaje                   |
      | "holahola" | "* El Email es requerido" |
      | "123456"   | "* El Email es requerido" |
      | "password" | "* El Email es requerido" |

