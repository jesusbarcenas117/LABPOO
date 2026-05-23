1. ¿Qué es una excepción personalizada y por qué crearlas?
    es una clase que hereda de Exception y representa un error específico, las creamos porque las excepciones de Java (NullPointerException, IOException) son genéricas 
    no dicen nada sobre el contexto del negocio. Con SaldoInsuficienteException sabemos exactamente qué pasó y podemos cargar información relevante como el saldo actual
    y el monto intentado.
2. ¿Qué es throws y qué es throw?  
    throws declara que un método puede lanzar esa excepción, es una advertencia al que lo llame, throw  lanza la excepción en ese momento
3. ¿Qué es try-with-resources?
    Es un try que cierra automáticamente recursos como archivos al terminar, sin necesidad de llamar close() manualmente. Evita que un archivo quede abierto si ocurre un error.