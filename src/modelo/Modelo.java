package modelo;

import java.util.ArrayList;

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
    public Dulce buscarDulcesPorNombre(String nombreDulce){
        for (Dulce dulce : dulces){
            if(dulce.getNombreDulce().equals(nombreDulce)){
                return dulce;
            }
        }
        return null;
    }

    // Metodo que permite listar todos los dulce
    public void listarDulces(){
        for (Dulce dulce : dulces){
            dulce.mostrarInformacion();
        }
    }

}
