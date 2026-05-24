en esta practica implemente una interfaz grafica con javafx para gestionar clientes de un gimnasio llamado gympos.
la ventana principal muestra una tabla con 20 clientes precargados con nombre, apellido, email, telefono y 
tipo de membresia. desde ahi se pueden agregar, editar y eliminar clientes usando un formulario modal que 
valida que nombre y email no esten vacios antes de guardar, los datos se persisten usando serializacion y por 
cada operacion guarda automaticamente en un archivo clientes.dat y se cargan al iniciar la app.
el filtrado interactivo se implemento con filterelist de javafx, que envuelve la lista observable de 
clientes. se enlaza con el campo de busqueda usando textproperty().addlistener() cada vez que el usuario
escribe, el predicado del filtro se actualiza y la tabla se refresca automaticamente sin necesidad de recargar nada.
el css externo define colores, tipografia y estilos de la tabla y los botones