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
      | nombre          | email              | password   |
      | "yeison ferney" | "yeison@gmail.com" | "123456"   |
      | "juan perez"    | "juan@gmail.com"   | "holahola" |
      | "yuli lopez"    | "yuli@gmail.com"   | "password" |

