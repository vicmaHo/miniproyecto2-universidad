package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

        // TODO: agregar listeners a los componenentes de cada menu
        // Agrego eveentos a los componentes
        // Lb Para cambiar de menu
        this.menuPrincipal.lbInsertar.addMouseListener(this);
        this.menuPrincipal.lbActualizar.addMouseListener(this);
        this.menuPrincipal.lbBuscar.addMouseListener(this);
        this.menuPrincipal.lbEliminar.addMouseListener(this);
        this.menuPrincipal.lbLista.addMouseListener(this);

        // Componentes de menuInsertar
        this.menuInsertar.btnAgregarDulce.addActionListener(this);


        // Componenentes de menuActulizar
        this.menuActualizar.btnModificarDulce.addActionListener(this);

        // pruebas de otros componentesS
        this.menuLista.jList1.addListSelectionListener(this);
    }

    public void iniciar() {
        menuPrincipal.setTitle("Dulceria");
    }

    private void actualizarDulcesComboBoxesList(){
        String[] dulcesDisponibles = model.getNombresDulces().toArray(new String[model.getNombresDulces().size()]);
        menuActualizar.cbListaDulces.setModel(new javax.swing.DefaultComboBoxModel<>(dulcesDisponibles));
        menuEliminar.cbListaDulces.setModel(new javax.swing.DefaultComboBoxModel<>(dulcesDisponibles));
        menuLista.jList1.setModel(new javax.swing.DefaultComboBoxModel<>(dulcesDisponibles));
    }

    // Funcion que permite cambiar JPanel del contenido de la interfaz principal
    private void cambiarPanelMenu(JPanel p) {
        p.setSize(600,480);
        p.setLocation(0,0);
        menuPrincipal.contenidoPrincipal.removeAll();
        menuPrincipal.contenidoPrincipal.add(p, BorderLayout.CENTER);
        menuPrincipal.contenidoPrincipal.revalidate();
        menuPrincipal.contenidoPrincipal.repaint();
    }

    // Eventos para cambiar el menu
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menuPrincipal.lbInsertar) {
            cambiarPanelMenu(menuInsertar);
        } else if (e.getSource() == menuPrincipal.lbActualizar) {
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuActualizar);
        }else if (e.getSource() == menuPrincipal.lbBuscar){
            cambiarPanelMenu(menuBuscar);
        }else if (e.getSource() == menuPrincipal.lbEliminar){
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuEliminar);
        }else if(e.getSource() == menuPrincipal.lbLista){
            actualizarDulcesComboBoxesList();
            cambiarPanelMenu(menuLista);
        }
    }

    // Metodos de MouseListener
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

    // Listener de eventos para botones etc
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: implementar detectores y funcionalidades de cada boton u otros componente
        if (e.getSource() == menuInsertar.btnAgregarDulce){
            String nombreDulce = menuInsertar.txtNombre.getText();
            CategoriaDulce categoria = null;
            if (menuInsertar.rbDulce.isSelected()){
                categoria = CategoriaDulce.DULCE;
            }else if(menuInsertar.rbAcido.isSelected()){
                categoria = CategoriaDulce.ACIDO;
            }else if (menuInsertar.rbSinAzucar.isSelected()){
                categoria = CategoriaDulce.SINAZUCAR;
            }
            menuInsertar.btnGroupCategorias.clearSelection();
            menuInsertar.txtNombre.setText("Nombre del dulce");
            model.insertarDulces(nombreDulce, categoria);
            JOptionPane.showMessageDialog(null, "¡Dulce agregado con éxito!", "Menu Insertar", JOptionPane.INFORMATION_MESSAGE);

        }
        if (e.getSource() == menuActualizar.btnModificarDulce){
            String nombreDulce = menuActualizar.cbListaDulces.getSelectedItem().toString();
            String nombreNuevo = menuActualizar.txtNombre.getText();
            // Obtengo la categoria
            CategoriaDulce categoriaNueva = null;
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
        }

    }

    // Funcionalidad de eventos para la JList
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            System.out.println("Elemento seleccionado");
        }
    }
}
