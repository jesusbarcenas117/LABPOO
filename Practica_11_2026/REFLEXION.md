1. ¿Qué es el hilo de la UI (JavaFX Application Thread) y por qué no debes
   hacer operaciones pesadas en él?
    es el hilo principal de javafx, dibuja y hace los cambios de la interfaz
    , si hago operaciones pesadas ahi como cargar archivos masivos, truena
    y al tronar la ventana se congela por ende noresponde
2. ¿Qué es un =EventHandler=? ¿Cómo conecta la acción del usuario con la
   lógica de tu programa?
    es la conexion entre la accion del usuario y mi codigo
    describo el evento y EventHandler escucha y ejecuta el codigo asignado
    
3. ¿Qué diferencia hay entre un =Stage=, una =Scene= y un =Node= en JavaFX?
    es lo mismo que en html si no mal recuerdo pero con diferentes palabras, bueno stage no
    stage es la ventana del sistema
    scene es el body, el contenido dentro de la ventana
    y node es cualquier elemento visual dentro de scene
