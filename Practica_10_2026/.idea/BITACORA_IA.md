"esto es uso de hilos ya lo vi en algoritmia y optimizacion, repartir un hilo para cada tarea en funcion de reducir las cargas de trabajo"
"explicame que hace cada clase exactamente, entiendo la idea pero no la implementacion"
"cual es la diferencia entre cajero y cliente y consumidor y productor"


mismo funcionamiento que en otros lenguajes, el problema que fue un dolor de cabeza fue asentar el runable y sobretodo la
logica de crear quien crea y consume los procesos, dando como resultado que si el productor genera mas rápido de lo que el 
consumidor procesa, el buffer se llena y el productor espera. Si el consumidor procesa más rápido de lo que el productor genera,
el buffer se vacía y el consumidor espera #ayuda me duele el lobulo frontal