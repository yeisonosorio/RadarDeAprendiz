#encoding:UTF-8
#Author: Yeison Ferney Osorio Buitrago


Feature: Registrar usuario en la pagina radar
  yo como usuario de la pagina
  quiero registrarme en la pagina de radar
  para poder usar sus servicios


  Scenario Outline: Registro exitoso
    Given el usuario esta en el registro de la pagina de radar de sofka
    When el usuario envia las credenciales <nombre> <email> <password>
    Then el usuario deberia un  mensaje que falta activar su usuario
    Examples:
      | nombre          | email                 | password   |
      | "yeison ferney" | "111yeison@gmail.com" | "123456"   |
      | "juan perez"    | "111juan@gmail.com"   | "holahola" |
      | "yuli lopez"    | "111yuli@gmail.com"   | "password" |

  Scenario Outline: Campos nombre vacio
    Given el usuario esta en la pagina de registro
    When el usuario envia las credenciales con campos <email> <password>
    Then el usuario vera reflejarse un <mensaje>
    Examples:
      | email              | password    | mensaje                    |
      | "email1@gmail.com" | "password1" | "* El Nombre es requerido" |
      | "email2@gmail.com" | "password2" | "* El Nombre es requerido" |
      | "email3@gmail.com" | "password3" | "* El Nombre es requerido" |

  Scenario Outline: Email vacio
    Given el usuario esta en la pagina del registro
    When el usuario envia las credenciales con los campos <nombre> <password>
    Then el usuario vera un <mensaje>
    Examples:
      | nombre      | password    | mensaje                   |
      | "Usuario 1" | "password1" | "* El Email es requerido" |
      | "Usuario 2" | "password2" | "* El Email es requerido" |
      | "Usuario 3" | "password3" | "* El Email es requerido" |

  Scenario Outline: Password vacio
    Given el usuario esta en la pagina de registro de radar
    When el usuario envia las credenciales del campo <nombre> <email>
    Then el usuario podra ver un <mensaje>
    Examples:
      | nombre      | email              | mensaje                      |
      | "Usuario 1" | "email1@gmail.com" | "* El password es requerido" |
      | "Usuario 2" | "email2@gmail.com" | "* El password es requerido" |
      | "Usuario 3" | "email3@gmail.com" | "* El password es requerido" |
