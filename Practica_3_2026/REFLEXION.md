1. ¿Por qué marcamos atributos como =private=? ¿Qué riesgo evitamos?
r= para que nadie pueda modificar nuestros atributos sin pasar por nuestras
validaciones
2. ¿Cuál es la diferencia entre =private=, =protected= y =public=? Ilustra
   con un ejemplo de tu código.
r=private solo puede acceder la propia clase y otros a traves de setters
protected solo la clase y las subclases y public cualquiera

por ejemplo en los atributos de banco, nombreBanco  y la lista de cuentas
pueden ser tocadas por Banco y clases que extiendan de banco con sus metodos
y sus atributos, y por otro lado en Cuenta, domicilio y nombre solo se pueden 
acceder desde esta clase
3. ¿Qué validación incluiste en un setter? ¿Qué pasa si el valor recibido
   es inválido?
r= que el saldo en saldo y deuda no pueden ser negativos y en nombre 
no se pueden meter caracteres especiales, lo valide utilizando regex, 
cuando no pasa la validacion de los setter no pasa, se marca error y el valor
no se actualiza
