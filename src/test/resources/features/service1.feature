Feature: US Current Hospitalizations


Given usuario quiero verificar el número de hospitalizaciones actuales por COVID-19 en los Estados Unidos.

Scenario: Obtener el número de hospitalizaciones actuales
Given que estoy en el sitio web de COVID Tracking Project
When una petición GET al servicio "US Current Hospitalizations"
Then la respuesta debería tener un código de estado 200
And el número de hospitalizaciones actuales debería ser un número positivo
