1. ¿Qué ventaja concreta te dio la herencia en este ejercicio? ¿Qué código
   evitaste repetir?
    los atributos de la clase padre no los tuve que repetir, asi como sus getters y setters
2. ¿Cuándo es apropiado usar =super()= y cuándo no es necesario?
    es obligatorio cuando quieres jalar los atributos de una clase padre, pero para los metodos es opcional
3. ¿Qué pasa si una clase hija no sobrescribe un método de la clase padre?
   ¿Cuál versión se ejecuta?
    ejecuta la version de la clase padre, jala la ultima version que la modifica depende como se inicialize el objeto