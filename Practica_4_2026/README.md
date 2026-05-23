En esta práctica implementé una jerarquía de herencia de 3 niveles usando un dominio bancario.
Clase padre: Cuenta contiene los atributos base de cualquier cuenta como nombre, domicilio y número de cuenta con validación regex.
Nivel 2: CuentaDebito y CuentaCredito heredan de Cuenta y agregan atributos y comportamiento propios.
Nivel 3: CuentaNomina y CuentaInversion heredan de CuentaDebito. CuentaHipotecaria hereda de CuentaCredito.
Cada clase hija sobrescribe consultarBalance() y procesarTransaccion() usando @Override, y usa super() para llamar al constructor y métodos del padre.
La clase Banco gestiona una lista ArrayList<Cuenta> que acepta cualquier tipo de cuenta gracias al polimorfismo.


Para ejecutar es necesario tener un IDE compatible con java 11 o superior, compilar Main y correrlo.
En este caso le veo puras ventajas para usar en el caso de los Bancos, no veo razon por la cual no usar herencia si todos comparten
datos