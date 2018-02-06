## Consigna
Se solicita implementar un sistema para la gestión de tarjetas de puntos de un supermercado. El sistema deberá registrar las cuentas de puntos de los clientes, los movimientos de puntos de cada cuenta (ganancia de puntos y uso de los puntos) y las organizaciones con la que el supermercado tiene convenios y promociones especiales.

Se le ha entregado el siguiente diseño parcial que se debe respetar:
[![Diagrama de clases](https://i.imgur.com/FUpxzKp.png)](https://imgur.com/FUpxzKp)


## Especificación a implementar

|  | Descripción |
| ------ | ------ |
| Operación | comprarPuntos(idCuenta:Integrr, monto:Integer):Integer |
| Descripción | Crea una nueva instancia de Movimiento y la asocia a la cuenta cuyo atributo id = idCuenta. El valor del atributo puntos es calculado de la siguiente forma: el monto dividido el costo por punto de la cuenta. Si la c    uenta es Común, el costo por punto de la cuenta es el valor del atributo costoPorPunto. Si la cuenta es de tipo Convenio, es el valor del atributo con el mismo nombre en la instancia de Organización asociada. El valor retornado     es el valor del atributo puntos de la nueva instancia. Si el monto es menor que el costo por punto, no se crea el movimiento y se lanza una excepción. |

## Consignas
1. Implementar las clases.
2. Implementar la operación especificada anteriormente y todas aquellas operaciones necesarias para su implementación
