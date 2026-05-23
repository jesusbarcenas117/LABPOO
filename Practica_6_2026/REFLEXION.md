1. ¿Cuándo preferirías una clase abstracta sobre una interfaz? ¿Y al revés?
   la clase abstracta solo con clases que comparten comportamientos y las
   interfaces cuando necesito asegurarme que ciertas clases tengan metodos exactos
2. ¿Una clase puede implementar varias interfaces? ¿Por qué Java permite
   eso pero no herencia múltiple de clases?
   por que si se pudiera la herencia multiple una clase hija puede venir de dos clases padre que ambas
   pudieran tener el mismo método pero con distintos usos y en este tipo de casos java no sabe como
   determinar cual usar
3. Si agregas un método nuevo a una de tus interfaces, ¿qué clases se ven
   afectadas? ¿Cómo lo resolverías con un método =default=?
   todas las clases que agreguen esa interfaz modificada se ven afectadas y por ende java obliga a esas
   clases agregar ese método nuevo, investigando veo que este método default es una forma de decirle
   a las clases que ese método es opcional de implementar, y si no lo implementan estas usan la version
   de la interfaz automáticamente