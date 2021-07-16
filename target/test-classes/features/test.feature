#Author: kjosiro@gmail.com

@tag
Feature: Tranferencia de fondos
  Quiero realizar una tranferencia entre cuentas

  @tag1
  Scenario Outline:  Tranferencia de fondos entre cuentas
    Given Ingresar al sitio
    When Hace click sobre el boton sign up
    And Ingresa el usuario "<user>"
    And Ingresa la clave "<password>"
    And Selecciona la opcion Tranfer Funds
    And Selecciona from account "<fromAccount>"
    And Ingresa to account "<toAccount>"
    And Ingresa el monto a transferir "<amount>"
    And hace click sobre boton transferir
    Then Se observa la tranferencia exitosa

    Examples: 
      |  user  | password | fromAccount |   toAccount      |  amount |
      | Jsmith | Demo1234 |   800003    | 4539082039396288 | 2000000 |
