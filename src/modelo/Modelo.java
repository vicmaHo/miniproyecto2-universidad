package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Modelo {
    // Array de los dulces
    private ArrayList<Dulce> dulces = new ArrayList<Dulce>();
    
    // Constructor de dulces por defecto
    public Modelo(){
        Dulce dulce1 = new Dulce("Chocobreak", CategoriaDulce.DULCE);
        dulces.add(dulce1);

        Dulce dulce2 = new Dulce("Revolcon", CategoriaDulce.ACIDO);
        dulces.add(dulce2);

        Dulce dulce3 = new Dulce("Tosh", CategoriaDulce.SINAZUCAR);
        dulces.add(dulce3);

        Dulce dulce4 = new Dulce("Frunas", CategoriaDulce.DULCE);
        dulces.add(dulce4);

        Dulce dulce5 = new Dulce("BomBomBum", CategoriaDulce.DULCE);
        dulces.add(dulce5);

        Dulce dulce6 = new Dulce("Splot", CategoriaDulce.ACIDO);
        dulces.add(dulce6);

        Dulce dulce7 = new Dulce("Pirulito", CategoriaDulce.ACIDO);
        dulces.add(dulce7);
    }

    // Metodo que permite agregar dulces
    public void insertarDulces(String nombreDulce, CategoriaDulce categoria){
        Dulce dulce = new Dulce(nombreDulce, categoria);
        dulces.add(dulce);
    }

    // Metodo que permite actualizar dulces
    public void actualizarDulces(int indice, String nombreDulce, CategoriaDulce categoria){
        Dulce dulce = dulces.get(indice);
        dulce.setNombreDulce(nombreDulce);
        dulce.setCategoriaDulce(categoria);   
    }

    //Metodo que permite eliminar dulces
    public void eliminarDulces(int indice){
        dulces.remove(indice);
    }

    //Metodo que permite buscar dulces por nombre
    public String buscarDulcesPorNombre(String nombreDulce){
        String datos = ""; // Variable para almacenar los datos del dulce encontrado
        boolean existeDulce = false; // Variable para verificar si se encuentra el dulce
        for (Dulce dulce : dulces){ 
            // Se convierte el nombre del dulce en mayusculas y se verifica si es igual al nombre del dulce a buscar en el arraylist
            if(dulce.getNombreDulce().toUpperCase().equals(nombreDulce)){
                // Si se encuentra el dulce, se asignan los datos y se marca como encontrado
                datos = "Nombre Dulce: " + dulce.getNombreDulce() + "\nCategoria: " + dulce.getCategoriaDulce();
                existeDulce = true;
                break; // Salir del bucle una vez que se encuentra el dulce
            }
        }
        if(!existeDulce){
            // Mostrar un cuadro de diálogo de error si no se encuentra el dulce
            JOptionPane.showMessageDialog(null, "El dulce " + nombreDulce + " no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        return datos; // Devolver los datos del dulce encontrado
    }
    

    // Metodo que permite listar todos los dulce
    public void listarDulces(){
        for (Dulce dulce : dulces){
            dulce.mostrarInformacion();
        }
    }

    // Obtener el arraylist de los dulces
    public ArrayList<Dulce> getDulces(){
        return dulces;
    }

    // Crear una lista de Los nombres de los dulces y retornarla
    public ArrayList<String> getNombresDulces(){
        ArrayList<String> nombresDulces = new ArrayList<String>();
        for (Dulce dulce : dulces) {
            nombresDulces.add(dulce.getNombreDulce());
        }
        return nombresDulces;
    }
}
