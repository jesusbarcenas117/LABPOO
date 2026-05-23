Se implementó una jerarquía de excepciones personalizadas para el sistema bancario

BancoException padre de todas las excepciones del dominio
SaldoInsuficienteException incluye saldo actual y monto intentado como contexto adicional
LimiteCreditoException se lanza cuando un cargo supera el límite de crédito
CuentaNoEncontradaException se lanza cuando el número de cuenta no existe

SaldoInsuficienteException incluye el saldo actual, el monto intentado y un timestamp en el log
En un sistema real esto permite diagnosticar exactamente qué operación falló, con qué valores y a qué hora.

Para correr el proyecto es necesario contar con un IDE compatible con java 11 o superior, compilar y correr, asimismo favor de revisar
el archivo de logs para revisar las pruebas
