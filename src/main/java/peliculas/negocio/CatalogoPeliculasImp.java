package peliculas.negocio;

import peliculas.datos.AccesoDatosArchivoImp;
import peliculas.datos.IAccesoDatos;
import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImp implements ICatalogoPeliculas{
    private IAccesoDatos accesoDatos;

    /**
     * En el constructor iniciamos la interfaz que queremos emplear
     * Con polimorfismo
     */
    public CatalogoPeliculasImp() {
        this.accesoDatos = new AccesoDatosArchivoImp();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = accesoDatos.existe(NOMBRE_RECURSO);
            accesoDatos.escribir(pelicula,NOMBRE_RECURSO,anexar);
            System.out.println("Película agregada correctamente..."+nombrePelicula);
        } catch (AccesoDatosEx e) {
            System.out.println("Excepción de acceso a datos..."+e.getStackTrace());
        }
    }

    @Override
    public void listarPelicula() {
        try {
            var peliculas = accesoDatos.listar(NOMBRE_RECURSO);
            if (peliculas != null){
                peliculas.forEach(System.out::println);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Excepción al listar las películas..." + e.getStackTrace());
        }
    }

    @Override
    public void buscarPelicula(String nombrePelicula) {
        try {
            String resultado = null;
            resultado = accesoDatos.buscar(NOMBRE_RECURSO, nombrePelicula);
            System.out.println("Resultado " +resultado);
        } catch (LecturaDatosEx e) {
            System.out.println("Excepción al buscar la película..."+e.getStackTrace());
        }
    }

    /**
     * Inicia un catálogo de películas.
     * Es decir un nuevo archivo de películas.
     */
    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (accesoDatos.existe(NOMBRE_RECURSO)){
                accesoDatos.borrarArchivo(NOMBRE_RECURSO);
            }

            accesoDatos.crearArchivo(NOMBRE_RECURSO);
        } catch (AccesoDatosEx e) {
            System.out.println("Excepción al crear catálogo de películas... "+e.getMessage());
        }
    }
}
