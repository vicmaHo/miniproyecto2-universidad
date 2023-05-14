package modelo;


public class Dulce {
    // Atributos
    private String nombreDulce;
    private categoriaDulce categoria;

    // Constructores
    public Dulce(String nombreDulce, categoriaDulce categoria){
        this.nombreDulce = nombreDulce;
        this.categoria = categoria;
    }

    // Setters y Getters
    public String getNombreDulce() {
        return nombreDulce;
    }


    public void setNombreDulce(String nombreDulce) {
        this.nombreDulce = nombreDulce;
    }


    public categoriaDulce getCategoriaDulce() {
        return categoria;
    }


    public void setCategoriaDulce(categoriaDulce categoria) {
        this.categoria = categoria;
    }

    public void mostrarInformacion(){
        System.out.printf("----------\n" +
                            "Nombre del dulce: %s\n" +
                            "Categoria del dulce: %s\n" ,nombreDulce, categoria);
    }

}
