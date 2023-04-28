Feature: Activar cuentas de usuarios
  yo como administrador de la pagina
  quiero activar la cuenta de los usuarios de la pagina
  para que puedan usar sus servicios

  Scenario Outline: activar cuentas
    Given el admin esta en el login de la pagina de radar
    When el admin envia las credenciales <email> <password>
    Then el admin debe poder ingresar a la pagina y activar las cuentas de los usuarios
    Examples:
      | email                | password |
      | "yeisonQA@gmail.com" | "123456" |