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
5. Listar todos los dulces

Un dulce tiene un nombre y una categoría (dulce, ácido, sin azúcar). Aplicar los conceptos
vistos en clase y generar la interfaz gráfica para realizar esta gestión. La interfaz debe tener un
botón que al presionarlo, se mostrará un resumen de todos los dulces creados dentro de un
área de texto.
## _Descripcion geneal del funcionamiento del programa_
Este programa ofrece una variedad de funciones que permiten gestionar de forma básica una tienda de dulces. Incluye características como la inserción de nuevos dulces, su modificación, búsqueda, eliminación y la capacidad de mostrar una lista completa de los dulces disponibles. La interfaz gráfica de usuario (GUI) es un componente fundamental, ya que proporciona diversos elementos interactivos. Estos componentes desempeñan un papel crucial en la interacción del usuario, ya que su uso activa los eventos necesarios para el correcto funcionamiento del programa.

## _Descripcion del funcionamiento de los menús del programa_
### Insertar dulces
Este método recibe dos parámetros: nombreDulce, que es un String que representa el nombre del dulce a insertar, y categoría, que es un objeto de tipo CategoriaDulce que representa la categoría del dulce. Dependiendo de la opción seleccionada, se asigna la categoría correspondiente a la variable categoría. Las opciones posibles son "DULCE", "ACIDO" y "SINAZUCAR", que son valores definidos en la enum CategoriaDulce.  Se llama al método insertarDulces del objeto model, se le envian nombreDulce y categoria como argumentos para agregar el dulce al ArrayList de dulces. Se muestra un mensaje emergente utilizando JOptionPane.showMessageDialog. El mensaje indica que el dulce se ha agregado con éxito. Se realiza una limpieza en el menú para prepararlo para la próxima inserción.
### Actualizar Dulces
El menú de actualización de dulces se encarga de interactuar con la lista de dulces del modelo de datos para realizar cambios en los atributos de los dulces existentes. Para llevar a cabo esta funcionalidad, se utilizan varios elementos:
- Un combobox que muestra los nombres de los dulces existentes. El nombre del dulce seleccionado se almacena en una variable.
- Un campo de texto donde se ingresa el nuevo nombre del dulce. El valor ingresado se guarda en otra variable.
- Un conjunto de radio buttons que permite seleccionar la nueva categoría del dulce. La categoría seleccionada se almacena en una variable separada.

Una vez que se han obtenido los valores necesarios, se realiza un recorrido por la lista de dulces del modelo. Durante este recorrido, se busca el dulce que se desea modificar mediante la comparación de nombres. Una vez encontrado, se utilizan los métodos "set" correspondientes para modificar los atributos del dulce con los nuevos valores proporcionados.

Al finalizar el proceso de modificación, se realizan algunas tareas adicionales, como borrar la selección de los radio buttons, restablecer el texto predeterminado en el campo de texto y actualizar las listas que muestran los nombres de los dulces, asegurando así una interfaz coherente y actualizada.
### Buscar dulces por nombre
En este método se obtiene el texto ingresado en un campo de texto y se almacena en la variable buscar, se convierte la variable buscar a mayúsculas utilizando el método toUpperCase() con el fin de evitar conflictos en la búsqueda del dulce. Despues se llama al método buscarDulcesPorNombre del objeto model, se le pasa la variable buscar como argumento para realizar la búsqueda de dulces por nombre. Si el dulce a buscar existe en el arraylist este devuelve una cadena de texto con los datos del dulce, el cual se muestra en el textArea, si el dulce no existe sale un mensaje emergente de error, el cual indica que el dulce no existe, finalmente se realiza limpieza en el menú buscar. 

### Eliminar Dulces
....
### Lista de dulces 
El menú de Lista de dulces muestra una lista de nombres de dulces junto con sus respectivas categorías. Para manejar los eventos de este menú, se utiliza un ListSelectionEvent que se activa cada vez que se selecciona un elemento de la lista, la cual está implementada utilizando un JList.
Cuando se selecciona un nombre de dulce en el JList, se almacena dicho nombre en una variable. A continuación, se recorre la lista de dulces perteneciente al modelo y se compara el nombre del dulce seleccionado con los nombres de cada dulce en la lista. Una vez se encuentra se utiliza el método setText en el campo de texto correspondiente. Este método establece en el campo de texto la categoría del dulce seleccionado, utilizando un método personalizado definido en el enum "CategoriaDulce". Este método retorna un string con un formato más legible y amigable para el usuario.
De esta manera, cada vez que se selecciona un nombre de dulce en el JList, se muestra automáticamente su categoría correspondiente en el campo de texto.