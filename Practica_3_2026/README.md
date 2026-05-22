En esta práctica apliqué encapsulamiento a las clases Cuenta y Banco usando modificadores de acceso, el objetivo fue controlar cómo se acceden y modifican los atributos de cada clase
La clase Cuenta tiene todos sus atributos privados y solo se pueden leer o modificar a través de getters y setters. Los setters incluyen validaciones que rechazan valores inválidos como saldos negativos o nombres con números.
La clase Banco usa atributos protected para nombreBanco y cuentas, y private para DireccionFiscal, tiene una relación de composición con Cuenta a través de un ArrayList.
Reglas de validación implementadas

Saldo no puede ser negativo
una cuenta bancaria no puede abrirse ni modificarse con saldo menor a cero.
Nombre no puede contener números ni caracteres especiales — el nombre de un titular solo debe contener letras y espacios.

Para ejecutarlo necesitas tener un IDE valido y configurado con java 11 o superior, compilar Main.java y despues correr
el codigo.