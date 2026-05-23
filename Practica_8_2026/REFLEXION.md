1. ¿Por qué usaste cada estructura de colección para cada tipo de dato?
   ¿Qué pasaría si usaras =ArrayList= para todo?
   las 4 estructuras de datos son clasicas, lista, cola, hashmap y conjunto
   vienen bien mas que nada por que por ejemplo, la lista esta bien para guardar las cuentas completas y pues, si necesitamos
   algo de ellas, la podemos recorrer completa pero en este caso utilizo buscar para buscar por clave valor, con un hashmap
   asi que la lista solo guarda info importante, la cola ahorra memoria al solo meter elementos detras en este caso
   el set fue un poco de relleno para saber de donde vienen mis clientes y lo meti solo por la propiedad de que los conjuntos no usan indices
   y tampoco se pueden repetir, entonces asi no importa cuantos registros hubieran con la misma ubicacion, solo se guardaria la primera vez
   que apareciera, //disculpe que lo pegara, es que lo anote en bitacora y es lo mismo. Si solo se usara un 
    arreglo comun, no notariamos diferencia con pocos datos, pero ya el tiempo de ejecucion con muchisimos mas usuarios estaria por las 
    nubes
2. ¿Qué diferencia hay entre =Comparable= y =Comparator=? ¿Cuándo usarías cada uno?
   Comparable se usa para ordenar objetos dentro de la clase, Comparator lo creas fuera de la clase y almenos yo entendi
   que se usa cuando tienes diferentes criterios de ordenamiento
3. Explica con tus palabras qué hace una operación Stream. ¿Por qué es más legible que un bucle =for=?
   es casi lo mismo pero mas flexible, el Stream puede hacer cadena de operaciones sobre la coleccion de datos, ademas es mas legible por que 
   le damos los parametros exactos de que queremos
   es mucho mas explico que hacer una logica de for gigante, supongo que para grandes volumenes de datos es mejor usar Stream