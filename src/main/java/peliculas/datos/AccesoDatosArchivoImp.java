package peliculas.datos;

import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

import java.io.File;
import java.util.List;

public class AccesoDatosArchivoImp implements IAccesoDatos{
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        return null;
    }

    @Override
    public void crearArchivo(String nombreRecurso) throws AccesoDatosEx {

    }

    @Override
    public void borrarArchivo(String nombreRecurso) throws AccesoDatosEx {

    }
}
