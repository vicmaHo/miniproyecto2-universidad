# Miniproyecto2
# _Integrantes_
- Alex Garcia Castañeda - 2259517
- Yessica Fernanda Villa Nuñez - 2266301
- Victor Manuel Hernandez Ortiz - 2259520
**Link de trello - espacio de gestion del proyecto**
https://trello.com/invite/b/hrVSBSaz/ATTIacb94b328caa6d92368019233f995a4f59A340D2/miniproyecto-ii
# _Enunciado del miniproyecto_
Vamos a hacer la gestión de una tienda de dulces
La aplicación debe permitir las siguiente opciones:
1. Insertar nuevos dulces
2. Actualizar dulces
3. Eliminar dulces
4. Buscar dulces por nombre
5. Listar todas los dulces
Un dulce tiene un nombre y una categoría (dulce, ácido, sin azúcar). Aplicar los conceptos
vistos en clase y generar la interfaz gráfica para realizar esta gestión. La interfaz debe tener un
botón que al presionarlo, se mostrará un resumen de todos los dulces creados dentro de un
área de texto.
## _Descripcion geneal del funcionamiento del programa_

## _Descripcion del funcionamiento de las funciones principales_

### Insertar dulces
Este método recibe dos parámetros: nombreDulce, que es un String que representa el nombre del dulce a insertar, y categoría, que es un objeto de tipo CategoriaDulce que representa la categoría del dulce. Dependiendo de la opción seleccionada, se asigna la categoría correspondiente a la variable categoría. Las opciones posibles son "DULCE", "ACIDO" y "SINAZUCAR", que son valores definidos en la enum CategoriaDulce.  Se llama al método insertarDulces del objeto model, se le envian nombreDulce y categoria como argumentos para agregar el dulce al ArrayList de dulces. Se muestra un mensaje emergente utilizando JOptionPane.showMessageDialog. El mensaje indica que el dulce se ha agregado con éxito. Se realiza una limpieza en el menú para prepararlo para la próxima inserción.

### Buscar dulces por nombre
En este método se obtiene el texto ingresado en un campo de texto y se almacena en la variable buscar, se convierte la variable buscar a mayúsculas utilizando el método toUpperCase() con el fin de evitar conflictos en la búsqueda del dulce. Despues se llama al método buscarDulcesPorNombre del objeto model, se le pasa la variable buscar como argumento para realizar la búsqueda de dulces por nombre. Si el dulce a buscar existe en el arraylist este devuelve una cadena de texto con los datos del dulce, el cual se muestra en el textArea, si el dulce no existe sale un mensaje emergente de error, el cual indica que el dulce no existe, finalmente se realiza limpieza en el menú buscar. 
