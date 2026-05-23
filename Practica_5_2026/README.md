En esta práctica implementé polimorfismo usando interfaces, clases abstractas y herencia en un dominio bancario
interfaz Calculable define el contrato de calcularInteres() y calcularComision() que todas las cuentas concretas deben implementar
clase abstracta CuentaAbstracta — define los atributos base y el método abstracto consultarBalance() que cada hijo implementa a su manera. Incluye el método concreto mostrarTitular()
clases concretas CuentaAhorro, CuentaCredito y CuentaInversion extienden CuentaAbstracta e implementan Calculable. Cada una tiene 3 sobrecargas de su método principal
arreglo polimórfico en Main se declara un arreglo de tipo CuentaAbstracta que contiene los 3 tipos diferentes y los procesa con un ciclo
casting e instanceof se demuestra cómo verificar el tipo de un objeto antes de castearlo para acceder a métodos específicos de cada clase concreta

Para correr este proyecto es necesario contar con un IDE compatible con java 11 o superior, compilar Main y luego correrlo
en este caso mi template method fue generarReporte(), manda a llamar al metodo abstracto de la clase, este mismo se usa a la hora de imprimir la lista de cuentas abstractas
genera el reporte mostrando el titular y la funcion consultarBalance() es la que cambia depende que clase sea el objeto que la esta mandando a llamar.
