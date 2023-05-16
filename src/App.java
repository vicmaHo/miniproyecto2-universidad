import controlador.Controlador;
import modelo.Modelo;
import vista.ActualizarVista;
import vista.BuscarVista;
import vista.DulceriaVista;
import vista.EliminarVista;
import vista.InsertarVista;
import vista.ListaVista;

public class App {
    public static void main(String[] args) throws Exception {
        DulceriaVista menuPrincipal = new DulceriaVista();
        InsertarVista menuInsertar = new InsertarVista();
        ActualizarVista menuActualizar = new ActualizarVista();
        BuscarVista menuBuscar = new BuscarVista();
        EliminarVista menuEliminar = new EliminarVista();
        ListaVista menuLista = new ListaVista();
        Modelo modelo = new Modelo();

        Controlador controlador = new Controlador(menuPrincipal, menuInsertar, menuActualizar, menuBuscar,
                menuEliminar, menuLista, modelo);

        controlador.iniciar();
        modelo.listarDulces();
        menuPrincipal.setVisible(true);

    }
}
