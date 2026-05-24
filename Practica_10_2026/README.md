en esta practica simule un banco con multiples cajeros y clientes operando al mismo tiempo usando hilos en java.
el problema concreto que resuelve la concurrencia es que en un banco real muchos cajeros atienden clientes al mismo
tiempo sobre las mismas cuentas, sin control, dos cajeros podrian retirar dinero simultaneamente y el saldo quedaria mal calculado.
se usaron dos formas de crear hilos. cajero extiende thread directamente y arranca con start(). cliente implementa runnable y
es administrado por un executorservice que administra un pool de 3 hilos y les asigna tareas automaticamente.
el acceso al saldo de la cuenta esta protegido con synchronized, lo que garantiza que solo un hilo a la vez puede 
modificarlo. sin esto dos hilos podrian leer el mismo saldo, modificarlo por separado y escribir un resultado incorrecto.
eso se llama race condition,tambien se implemento el patron productor-consumidor con un buffer compartido
los productores generan transacciones y los consumidores las procesan. si el buffer esta lleno el productor espera
con wait() y si esta vacio el consumidor espera. notify() despierta al hilo correspondiente cuando la condicion cambia.