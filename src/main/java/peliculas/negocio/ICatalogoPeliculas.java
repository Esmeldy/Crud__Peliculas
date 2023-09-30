package peliculas.negocio;

public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    public void agregarPelicula(String nombrePelicula);
    public void listarPelicula();
    public void buscarPelicula(String nombrePelicula);
    public void iniciarCatalogoPeliculas();


}
