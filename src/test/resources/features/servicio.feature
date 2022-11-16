@Api
Feature: Apis

  @getListUser
  Scenario: Operador lista clientes
    Given inicializo request
    When ejecuta la peticion "api/users?page=2"
    Then valida que la respuesta es 200

  @getUsuariosActivos
  Scenario: Lista de Usuarios Activos
    Given inicializo request
    When ejecuta la peticion "api/unknown/1"
    Then valida que la respuesta es 200

  @postUser
  Scenario: Crear mascota no registrada
    Given inicializo request
    And inserto los valores de la mascota nombre "labrador" ,  photoUrls "labrador" y status"available"
    And ejecuta la creacion "/v2/pet"
    Then valida que la respuesta es 201
    And valida el "name" sea "labrador"
    And valida el "photoUrls" sea "labrador"
    And valida el "status" sea "available"
    When obtengo el id pokemon 9223372016900012000
    And verifico el ability id
    And verifico su base_experience
    Then valida que la respuesta es 200
