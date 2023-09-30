package peliculas.datos;

import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

import java.util.List;

/**
 *
 * Contiene las operaciones a ejecutar en el
 * archivo película
 */
public interface IAccesoDatos {
    /**
     * Devuelve si el nombre del recurso existe.
     * @param nombreRecurso
     * @return
     * @throws AccesoDatosEx
     */
    public boolean existe(String nombreRecurso) throws AccesoDatosEx;

    /**
     * Devuelve el listado de películas almacenadas en el archivo
     * @param nombreRecurso
     * @return
     * @throws LecturaDatosEx
     */
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    /**
     * Añade una nueva película al listado
     * @param pelicula
     * @param nombreRecurso
     * @param anexar
     * @throws EscrituraDatosEx
     */
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    public void crearArchivo(String nombreRecurso) throws AccesoDatosEx;
    public void borrarArchivo(String nombreRecurso) throws AccesoDatosEx;
}
