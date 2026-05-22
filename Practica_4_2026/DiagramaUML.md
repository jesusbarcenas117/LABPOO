@startuml

class Cuenta {
- nombre : String
- domicilio : String
- numeroCuenta : String
+ getNombre() : String
+ setNombre(String)
+ getDomicilio() : String
+ setDomicilio(String)
+ getNumeroCuenta() : String
+ consultarBalance()
+ procesarTransaccion()
}

class CuentaDebito {
# saldoAFavor : double
+ procesarTransaccion()
+ consultarBalance()
}

class CuentaCredito {
# saldoDeuda : double
# limiteCredito : double
+ procesarTransaccion()
+ consultarBalance()
+ calcularInteresMensual()
}

class CuentaNomina {
- nominaEmpresa : Banco
+ procesarTransaccion()
+ consultarBalance()
}

class CuentaInversion {
- rendimiento : double
+ consultarRendimiento()
+ procesarTransaccion()
}

class CuentaHipotecaria {
- tiempoDeuda : int
- direccionHipoteca : String
+ agregarHipoteca(String)
+ consultarDetalles()
}

Cuenta <|-- CuentaDebito
Cuenta <|-- CuentaCredito
CuentaDebito <|-- CuentaNomina
CuentaDebito <|-- CuentaInversion
CuentaCredito <|-- CuentaHipotecaria

@enduml