Instrucciones para compilar el proyecto:
  1. Abrir proyecto con NetBeans.
  2. Compilar proyecto con el botón "Build new project".
  3. El archivo ejecutable .JAR se habrá generado en dist/Compiladores2020.jar junto a las librerías de CUP (dist/lib).
  
 Instrucciones para utilizar el programa:
  Se debe ejecutar el archivo Compiladoress2020.jar desde la consola usando la siguiente sintaxis:
  java -jar Compiladores.jar <PROGRAMA> <TOKENS> <TABLA_SIMBOLOS> <ARBOL> <ERRORES>
    1. <PROGRAMA>: Ruta absoluta al fichero con el código fuente
    2. <TOKENS>: Ruta absoluta al fichero donde se guardará el listado de TOKENS (si no existe, se creará un nuevo fichero).
    3. <TABLA_SIMBOLOS>: Ruta absoluta al fichero donde se guardará la tabla de símbolos (si no existe, se creará un nuevo fichero).
    4. <ARBOL>: Ruta absoluta al fichero donde se guardará el árbol sintáctico (si no existe, se creará un nuevo fichero).
    5. <ERRORES>: Ruta absoluta al fichero donde se guardará el listado de errores (si no existe, se creará un nuevo fichero).
