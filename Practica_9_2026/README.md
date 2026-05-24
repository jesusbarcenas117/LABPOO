En esta practica implemente un sistema de gestion de archivos para el dominio bancario usando las herramientas de I/O de Java.
Se leen datos desde un archivo datos.csv usando BufferedReader, que carga bonches de datos en memoria en vez de leer byte a byte
haciendo la lectura más eficiente, los datos se procesan y se pueden guardar como reporte en texto plano
para la persistencia de objetos se implementó serialización convirtiendo objetos Cuenta a bytes y guardándolos
en un archivo binario, esto permite recuperar el objeto exactamente igual después sin necesidad de parsearlo
el sistema genera backups automáticos con timestamp en el nombre del archivo garantizando que cada respaldo sea único y fechado
como formato alternativo al csv elegi json construido manualmente con StringBuilder, json es útil cuando los datos necesitan
integrarse con APIs REST, aplicaciones web o servicios externos, ya que es el estándar de comunicación entre sistemas modernos que
a diferencia del csv, no requiere procesamiento adicional para ser consumido por servicios externos