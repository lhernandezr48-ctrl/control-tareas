# Tarea Control de Parqueo

## Datos del estudiante

**Nombre:** Lilian Gabriela Hernandez Rodriguez
**Carné:** 9941-25-27807

## Descripción de la solución

El programa permite registrar varios vehículos que utilizan un parqueo y calcular el pago correspondiente según el tipo de vehículo y el tiempo que permaneció estacionado.

El sistema solicita la placa, tipo de vehículo, hora de entrada, hora de salida y si el conductor perdió el ticket. También valida los datos ingresados para evitar valores incorrectos.

El programa calcula la tarifa por hora, el subtotal, el descuento del 15% cuando el vehículo permanece más de 8 horas y el recargo de Q50.00 cuando se pierde el ticket.

Al finalizar, muestra un resumen general de la jornada con la cantidad de vehículos registrados por tipo, tickets perdidos, total recaudado y el vehículo que realizó el pago más alto.

## Métodos creados

### obtenerTarifa(int tipoVehiculo)

Determina la tarifa por hora dependiendo del tipo de vehículo:

* Motocicleta: Q5.00
* Automóvil: Q8.00
* Pickup o camioneta: Q12.00

### obtenerNombreVehiculo(int tipoVehiculo)

Devuelve el nombre correspondiente al tipo de vehículo seleccionado.

### calcularDescuento(double subtotal, int horas)

Calcula un descuento del 15% sobre el subtotal cuando el vehículo permanece más de 8 horas.

### calcularPago(int horas, double tarifa)

Calcula el pago cuando el conductor no perdió el ticket.

### calcularPago(int horas, double tarifa, double recargo)

Calcula el pago cuando existe un recargo por ticket perdido.

### mostrarComprobante(...)

Muestra el comprobante individual de cada vehículo, incluyendo placa, tipo, tiempo estacionado, horas cobradas, tarifa, subtotal, descuento, recargo y total.

## Sobrecarga de métodos

La sobrecarga se aplicó utilizando dos métodos llamados `calcularPago`.

El primer método recibe dos parámetros:

`calcularPago(int horas, double tarifa)`

El segundo recibe tres parámetros:

`calcularPago(int horas, double tarifa, double recargo)`

Ambos métodos tienen el mismo nombre, pero diferente cantidad de parámetros. Esto permite calcular el pago dependiendo de si existe o no un recargo por ticket perdido.

## Casos de prueba utilizados

### Caso 1: Ejecución normal

Se registró un vehículo sin descuento y sin ticket perdido para comprobar el cálculo básico del pago.

### Caso 2: Descuento y ticket perdido

Se utilizó un vehículo con más de 8 horas estacionado y con ticket perdido para comprobar que se aplicara correctamente el descuento del 15% y posteriormente el recargo de Q50.00.

### Caso 3: Validación de datos

Se ingresaron datos incorrectos, como un tipo de vehículo fuera del rango permitido, para comprobar que el programa rechazara el dato y solicitara nuevamente la información.

También se probaron valores inválidos para las horas y para la respuesta del ticket.

### Caso 4: Cruce de medianoche

Se utilizó una hora de entrada de 22:30 y una hora de salida de 02:10 del día siguiente.

El resultado obtenido fue:

* Tiempo estacionado: 3 horas y 40 minutos.
* Horas cobradas: 4 horas.

## Reto opcional

**Sí se realizó el reto opcional.**

El programa permite ingresar la hora y los minutos de entrada y salida, valida las horas entre 0 y 23 y los minutos entre 0 y 59.

También calcula correctamente el tiempo cuando el vehículo sale al día siguiente y cobra como una hora completa cualquier fracción de hora.

## Conclusión

El programa permite controlar los pagos de los vehículos de un parqueo de manera organizada. Se utilizaron variables, operadores, estructuras condicionales, ciclos, métodos, parámetros, valores de retorno, acumuladores, contadores y sobrecarga de métodos.
