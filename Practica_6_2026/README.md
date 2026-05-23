En esta práctica combiné clases abstractas e interfaces para modelar un sistema  con responsabilidades separadas
CuentaAbstracta define la base común de todas las cuentas, atributos nombre, numeroCuenta y saldo, el método abstracto consultarBalance()
y el Template Method generarReporte() que ya habia ocupado en la practica pasada.
3 interfaces con responsabilidades distintas:

Calculable para cálculos financieros
Transferible para movimiento de dinero entre cuentas
Notificable para comunicación con el titular

CuentaInversion no transfiere porque es un instrumento de largo plazo
CuentaCredito no transfiere porque solo acumula deuda
Solo CuentaAhorro tiene acceso completo.

Para correr el proyecto es necesario contar con un IDE compatible con java 11 o superior, compilar y posteriormente correr.
