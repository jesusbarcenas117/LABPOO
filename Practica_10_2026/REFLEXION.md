1. ¿Qué es una race condition? Describe un escenario concreto de tu código
   donde podría ocurrir
    es cuando dos hilos acceden al mismo recurso al mismo tiempo y el resultado depende de quien 
    llego primero, en el codigo se soluciona con synchronized, si no se hace de esta manera
    dos cajeros pueden hacer un retiro digamos al mismo tiempo, y ambos actualizan el saldo, pero si no estan sincronizados
    entregan valores erroneos
2. ¿Por qué =synchronized= resuelve el problema? ¿Qué desventaja de
   rendimiento tiene?
    a bueno, pues lo de arriba, cuando un hilo tiene un proceso los demas tienen que esperar, si muchos hilos
    esperan un turno pues no estan ejerciendo ningun trabajo entonces ahi no es optimizado por que esta consumiendo los 
    recursos de los hilos y tampoco es completamente rapido
    
3. ¿Qué diferencia hay entre =Thread.sleep()= y =Object.wait()=? ¿Cuándo
   usarías cada uno?
    sleep pausa el hilo de manera definida, por un tiempo exacto, y wait lo pausa de manera indefinida
    y espera el aviso de notify para despertar el hilo, en este caso el el consumidor espera hasta que 
    el productor agregue algo al buffer
    