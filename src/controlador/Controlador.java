package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.CategoriaDulce;
import modelo.Dulce;
import modelo.Modelo;
import vista.ActualizarVista;
import vista.BuscarVista;
import vista.DulceriaVista;
import vista.EliminarVista;
import vista.InsertarVista;
import vista.ListaVista;

public class Controlador implements ActionListener, MouseListener, ListSelectionListener {
    // Instancio las vistas y el modelo
    private DulceriaVista menuPrincipal;
    private InsertarVista menuInsertar;
    private ActualizarVista menuActualizar;
    private BuscarVista menuBuscar;
    private EliminarVista menuEliminar;
    private ListaVista menuLista;
    private Modelo model;

    // Constructor del controlador
    public Controlador(DulceriaVista menuPrincipal, InsertarVista menuInsertar, ActualizarVista menuActualizar,
            BuscarVista menuBuscar, EliminarVista menuEliminar, ListaVista menuLista, Modelo model) {
        this.menuPrincipal = menuPrincipal;
        this.menuInsertar = menuInsertar;
        this.menuActualizar = menuActualizar;
        this.menuBuscar = menuBuscar;
        this.menuEliminar = menuEliminar;
        this.menuLista = menuLista;
        this.model = model;

        // Agrego eveentos a los componentes
        // Lb Para cambiar de menu
        this.menuPrincipal.lbInsertar.addMouseListener(this);
        this.menuPrincipal.lbActualizar.addMouseListener(this);
        this.menuPrincipal.lbBuscar.addMouseListener(this);
        this.menuPrincipal.lbEliminar.addMouseListener(this);
        this.menuPrincipal.lbLista.addMouseListener(this);

        // Componentes de menuInsertar
        this.menuInsertar.btnAgregarDulce.addActionListener(this);
        
        // cmponente de menuEliminar
        this.menuEliminar.btnEliminarDulce.addActionListener(this); // botoneliminar
        this.menuEliminar.cbListaDulces.addActionListener(this);// jcombox eliminar 

        // Componentes de menuBuscar
        this.menuBuscar.btnBuscar.addActionListener(this);

        // Componenentes de menuActulizar
        this.menuActualizar.btnModificarDulce.addActionListener(this);

        // Componenentes del menuLista
        this.menuLista.lsLista.addListSelectionListener(this);
    }

    public void iniciar() {
        menuPrincipal.setTitle("Dulceria");
    }

    /* Agrego a los ComboBox y a los JList los items que corresponden a los nombres de los dulces
    que estan disponibles en el programa. Esta asigancion se hace usando el getNombresDulces del modelo
    */
    private void actualizarDulcesComboBoxesList(){
        menuActualizar.cbListaDulces.setModel(new javax.swing.DefaultComboBoxModel<>(model.getNombresDulces()));
        menuEliminar.cbListaDulces.setModel(new javax.swing.DefaultComboBoxModel<>(model.getNombresDulces()));
        menuLista.lsLista.setModel(new javax.swing.DefaultComboBoxModel<>(model.getNombresDulces()));
    }

    /*Funcion que permite cambiar de panel(menu). Le mando como argumetno el menu al que quiero cambiar
    y se encarga de asiganrle un tamaño, borrar lo que ya existe en el panel de contenido y agregar el panel
    nuevo correspondiente al menu
    */
    private void cambiarPanelMenu(JPanel p) {
        p.setSize(600,480);
        p.setLocation(0,0);
        menuPrincipal.contenidoPrincipal.removeAll();
        menuPrincipal.contenidoPrincipal.add(p, BorderLayout.CENTER);
        menuPrincipal.contenidoPrincipal.revalidate();
        menuPrincipal.contenidoPrincipal.repaint();
    }

    // Eventos para cambiar el menu, usando un mouseClicked como listener para los Labels correspondientes a cada menu
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menuPrincipal.lbInsertar) {
            cambiarPanelMenu(menuInsertar);
        } else if (e.getSource() == menuPrincipal.lbActualizar) {
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuActualizar);
        }else if (e.getSource() == menuPrincipal.lbBuscar){
            cambiarPanelMenu(menuBuscar);
            menuBuscar.jTextArea1.setText("");
            menuBuscar.txtNombre.setText("Nombre del dulce");
        }else if (e.getSource() == menuPrincipal.lbEliminar){
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuEliminar);
        }else if(e.getSource() == menuPrincipal.lbLista){
            menuLista.lsLista.clearSelection();
            menuLista.txtCategoria.setText("");
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuLista);
        }
    }
    // Metodos de MouseListener (Otros metodos que no son implementados)
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    // Listener de los eventos correspondientes a los botones y al combobox
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuInsertar.btnAgregarDulce){
            String nombreDulce = menuInsertar.txtNombre.getText(); // Se obtiene el nombre del dulce desde el campo de texto
            // la categoria sera dulce por defecto por si el usuario no selecciona alguna casilla
            CategoriaDulce categoria = CategoriaDulce.DULCE;
            // Se Verifica qué opción de categoría está seleccionada y asignar la categoría correspondiente
            if (menuInsertar.rbDulce.isSelected()){
                categoria = CategoriaDulce.DULCE;
            }else if(menuInsertar.rbAcido.isSelected()){
                categoria = CategoriaDulce.ACIDO;
            }else if (menuInsertar.rbSinAzucar.isSelected()){
                categoria = CategoriaDulce.SINAZUCAR;
            }
            model.insertarDulces(nombreDulce, categoria); // Se envia nombre del dulce y la categoría para agregarlo al arraylist
            JOptionPane.showMessageDialog(null, "¡Dulce agregado con éxito!", "Menu Insertar", JOptionPane.INFORMATION_MESSAGE);
            // Devuelvo el menu a sus valores por defecto
            menuInsertar.btnGroupCategorias.clearSelection();
            menuInsertar.txtNombre.setText("Nombre del dulce");
        }
        
        /*Evento del menu modificar dulce: Se crean dos variables String, una recibe el nombre del dulce
        el cual viene del item que este seleccionado del combobox y otra recibe el nombreNuevo a traves del textfield
        posteriomente se comprueba cual de las categorias es la seleccionada y se asigna a una variable. Despues
        se recorre la lista de dulces verificando cual coincide con el nombre, y a traves de sus metodos set
        se modifican sus atributos. Por ultimo se borra la seleccion del combobox y se reestablece el textfield
        se actualizan todas las listas de dulces y se muestra un mensaje.
         */
        if (e.getSource() == menuActualizar.btnModificarDulce){
            String nombreDulce = menuActualizar.cbListaDulces.getSelectedItem().toString();
            String nombreNuevo = menuActualizar.txtNombre.getText();
            // Obtengo la categoria
            // por defecto sera dulce, en caso de que el usuario no seleccione alguna categoria
            // con el fin de que no se rompa el programa
            CategoriaDulce categoriaNueva = CategoriaDulce.DULCE;
            if (menuActualizar.rbDulce.isSelected()){
                categoriaNueva = CategoriaDulce.DULCE;
            }else if(menuActualizar.rbAcido.isSelected()){
                categoriaNueva = CategoriaDulce.ACIDO;
            }else if (menuActualizar.rbSinAzucar.isSelected()){
                categoriaNueva = CategoriaDulce.SINAZUCAR;
            }
            // Recorro la lsita de dulces para modificarlo
            for (Dulce dulce : model.getDulces()) {
                if (dulce.getNombreDulce().equals(nombreDulce)){
                    dulce.setNombreDulce(nombreNuevo);
                    dulce.setCategoriaDulce(categoriaNueva);
                }
            }
            // Devuelvo el menu a sus valores por defecto y actualizo las listas de dulces
            menuActualizar.btnGroupCategoria.clearSelection();
            menuActualizar.txtNombre.setText("Nombre del dulce");
            actualizarDulcesComboBoxesList();
            JOptionPane.showMessageDialog(menuPrincipal, String.format("Dulce %s ha sido modificado por %s",nombreDulce, nombreNuevo), "Modificación", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == menuBuscar.btnBuscar){
            String buscar = menuBuscar.txtNombre.getText();
            buscar = buscar.toUpperCase(); //Se convierte en mayusculas la variable buscar 
            //Se envia en el textArea los datos que retorna el metodo buscarDulcesPorNombre 
            menuBuscar.jTextArea1.setText(model.buscarDulcesPorNombre(buscar)); 
        
            // Restablecer el texto del campo de texto txtNombre a "Nombre del dulce"
            menuBuscar.txtNombre.setText("Nombre del dulce");
        }

         /*Evento del menu eliminar dulce: lo primera condicion es detectar el boton eliminar, este primero va a 
         asegurarse de que haya un elemento seleccionado en el jcombox, el cual se guarda en un string llamado
         nombreDulce,justo debajo se mostrara la informacion de ese dulce, despues se verificara que verdaderamente haya algo que seleccionar, 
         si lo hay se procedera a eliminar ese elemento seleccionado y limpiar el apartado de informacion del dulces, y por ultimo
         se actualizara la el jcombox de los dulces quitando el dulces elimnado, dado caso que no haya ningun dulce que eliminar
         al verificar se mostrar una ventana que dira que no hay dulces que eliminar.
         */
        if (e.getSource() == menuEliminar.btnEliminarDulce){
            // se detecta el dulce seleccionado en el jcombox
            String nombreDulce = (String) menuEliminar.cbListaDulces.getSelectedItem(); 

            // se verifica si hay un dulce seleccionado y se procede a eliminar
            if (nombreDulce != null) {
                model.eliminarDulces(nombreDulce);
                menuEliminar.txtInformacion.setText("");
                JOptionPane.showMessageDialog(menuPrincipal, String.format("Dulce %s ha sido eliminado", nombreDulce), "Eliminación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(menuPrincipal, "No hay dulces para eliminar", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
            } 

            // se actualiza el jcombox con los dulces restantes
            actualizarDulcesComboBoxesList();
        }
        
        // Detecta si se selecciono algo en el jcombox del menu elimnar una vez detectado muestra la informacion del ducle en el panel de abajo
        if (e.getSource() == menuEliminar.cbListaDulces) {
            String nombreDulce = menuEliminar.cbListaDulces.getSelectedItem().toString();
            String informacion = model.mostrarInformacionDulce(nombreDulce);
            menuEliminar.txtInformacion.setText(informacion);
        }
    }

    // Listener para el JList del menu Lista
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /*Creo una variable String a la cual se le asigna posteriormente el valor seleccionado
        cuando se hace click en algun elemento del JList, posteriormente verifica el valor correspondiente a ese
        elemento, iterando en la list de dulces y comparando con el nombre. Cuando encuentra el objeto
        de tipo Dulce correspondiente, asigna el String que se encuentra en su categoria a el campo de texto
        con el fin de mostar la categoria del dulce seleccionado.
         */
        if(!e.getValueIsAdjusting()){ // verifico que la seleccion de un elemento solo sea un evento
            // System.out.println(menuLista.lsLista.getSelectedValue());
            String nombreDulceSeleccionado = ""; // Inicializo la variable con una cadena vacia
            if(!menuLista.lsLista.isSelectionEmpty()){ // En caso de que la liste no este selccionada no hara nada
                nombreDulceSeleccionado = menuLista.lsLista.getSelectedValue(); // si esta seleccionada agrega el valor a la variable
            }
            // Recorremos la lista de dulces para comprobar cual es el dulce seleccionado
            // y de este dulce extraemos su categoria y lo mostramos en el campo de texto
            for (Dulce dulce : model.getDulces()) {
                if(nombreDulceSeleccionado.equals(dulce.getNombreDulce())){
                    menuLista.txtCategoria.setText(dulce.getCategoriaDulce().getElementoFormateado());
                }
            }
        }
    }
}
