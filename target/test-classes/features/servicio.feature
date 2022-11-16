@Api
Feature: Apis

  @getListUser
  Scenario: Operador lista clientes
    #Given que el usuario accede a la API
    Given inicializo request
    When ejecuta la peticion "api/users?page=2"
    Then valida que la respuesta es 200

  @getUsuariosActivos
  Scenario: Lista de Usuarios Activos
    Given inicializo request
    When ejecuta la peticion "api/unknown/1"
    Then valida que la respuesta es 200

  @postUser
  Scenario: Crear un usuario no registrado
    Given que el usuario accede a la API
    And inicializo request
    And inserto los valores del cliente con nombre "Alexis" y trabajo "QA"
    And ejecuta la creacion "api/users"
    Then valida que la respuesta es 201
    And valida el "name" sea "Alexis"
    And valida el "job" sea "QA"
