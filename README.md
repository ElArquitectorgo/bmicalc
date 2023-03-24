![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

![Alt text](https://github.com/ElArquitectorgo/bmicalc/blob/main/doc/gui.png)

![Alt text](https://github.com/ElArquitectorgo/bmicalc/blob/main/doc/prueba.drawio.png)

# User stories
User story 1

As a user 
I want to compute the IMC of a given height and weigth 
so that I can know the result

Scenario: Computing the IMC of 70 cm and 1.70 kg
Given I have an IMC calculator
When I compute the IMC of 70 and 1.70
Then The system returns 24.22

User story 2

As a user 
I want to know my health CATEGORY given an imc
so that I can know my level of health

Scenario: Computing the CATEGORY of 25
Given I have an imc CATEGORY calculator
When I compute the CATEGORY of 25
Then The system returns overweight

User story 3

As a user 
I want to know if i have ABDOMINALOBESITY given a waistCircumference and gender
so that I can know if I need to do something

Scenario: Computing the ABDOMINALOBESITY of 95 cm and M
Given I have an ABDOMINALOBESITY calculator
When I compute the ABDOMINALOBESITY of 95 and M
Then The system returns true

# Especificación caso de uso
## Caso de uso: solicitar ayuda.
**Actor primario:** cliente.  
**Objetivo:** que el cliente reciba la ayuda o indicaciones necesarias a seguir para mejorar su salud en función de la categoría en la que se encuentre su IMC.  
**Scope:** aplicación móvil.  
**Nivel:** objetivo del usuario.  
**Stakeholders:**
1. Cliente: quiere mejorar su salud
2. Desarrollador: desarrolla la aplicación

**Precondición:** el cliente proporciona su peso y altura.  
**Garantías mínimas:** se muestra al menos un consejo para ayudar al cliente.  
**Trigger:** seleccionar botón “solicitar ayuda”.  
**Escenario principal:**
1. El cliente calcula su IMC (Calcular IMC)
2. El cliente busca la categoría a la que pertenece su IMC (Consultar categoría)
3. Se muestra información por pantalla con consejos nutricionales y/o deportivos acorde a la categoría del IMC indicado.

**Escenario alternativo:**
1. El usuario está en la categoría saludable y no se muestra ninguna recomendación.

# Tests
- underweightCategoryTest: comprueba con valores en rango que el resultado es correcto.
- underweightNegativeCategoryTest: comprueba que con valores negativos se lanza una excepción.
- normalCategoryTest: comprueba con valores en rango que el resultado es correcto.
- overweightCategoryTest: comprueba con valores en rango que el resultado es correcto.
- obeseCategoryTest: comprueba con valores en rango que el resultado es correcto.

- positiveMaleAbdominalObesityTest: comprueba que para valores por encima de 90 el resultado es positivo en hombres.
- negativeMaleAbdominalObesity: comprueba que para valores por debajo de 90 el resultado es negativo en hombres.
- positiveFemaleAbdominalObesityTest: comprueba que para valores por encima de 80 el resultado es positivo en mujeres.
- negativeFemaleAbdominalObesity: comprueba que para valores por debajo de 80 el resultado es negativo en mujeres.
- zeroAbdominalTest: comprueba que se lanza una excepción con una circunferencia igual a 0.
- negativeInputAbdominalTest: comprueba que se lanza una excepción con una circunferencia menor que 0.
- wrongGenderAbdominalTest: comprueba que se lanza una excepción con un género mal indicado.

- bmiTest: comprueba que la ecuación se realiza de forma correcta.
- bmiNegativeMassTest: comprueba que se lanza una excepción con masa negativa.
- bmiNegativeHeightTest: comprueba que se lanza una excepción con altura negativa.
- bmiHeightEqualsToZeroTest: comprueba que en caso de dividir por cero se lanza una excepción.
- bmiIrrealTest: comprueba que se lanza una excepción con una relación de peso altura irreal.