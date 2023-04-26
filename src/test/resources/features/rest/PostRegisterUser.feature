Feature: Registrar usuarios
  Como usuario de la pagina radar
  Quiero probar el servicio que resgistra usuarios en la pagina
  Para verificar su funcionamiento

  Scenario Outline: Registrar usuarios en la pagina de Radar
    Given el usuario esta en la pagina para crear usuarios
    When cuando el usuario envia solicitud con userId <uid> email <email>  name <name> estadoActivado <activate> y role <role>
    Then la pagina retornara un estatus con codigo <codigo> y con userId <uid> email <email>  name <name> estadoActivado <activate> y role <role>
    Examples:
      | uid | email              | name     | activate | role    | codigo |
      | "1" | "homero@gmail.com" | "Homero" | "true"   | "lider" | 200    |
      | "4" | "lisa@gmail.com"   | "Lisa"   | "true"   | "lider" | 200    |
      | "8" | "bart@gmail.com"   | "Bart"   | "true"   | "lider" | 200    |
      | "5" | "marge@gmail.com"  | "Marge"  | "true"   | "lider" | 200    |