1. ¿Qué es la serialización y cuándo es útil en comparación con guardar
   texto plano?
    serialización es convertir un objeto Java a bytes para guardarlo en un archivo binario y recuperarlo,
    después exactamente igual funciona cuando necesitas guardar el estado completo de un objeto con todos sus tipos de 
    datos intactos 
2. ¿Por qué usamos =BufferedReader= en lugar de leer byte a byte? ¿Qué
   mejora en rendimiento ofrece?
    principalmente eficiencia y rapidez, leer byte a byte es lento, BufferedReader carga bonches de datos para ir dando
    escalonazos
3. ¿Qué riesgos tiene no cerrar un archivo después de usarlo? ¿Cómo los
   mitigaste?
    los riegos son los que ya conocia, que se corrompa el archivo, que pierda su informacion o que se bloquee de la nada
    a veces se pierden datos que se quedaron en el buffer y ya no queda el archivo original como estaba, implemente 
    Try-with-resources, java se encarga de cerrar el archivo 