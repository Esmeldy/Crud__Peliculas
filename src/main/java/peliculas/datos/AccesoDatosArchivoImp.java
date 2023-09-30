package peliculas.datos;

import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosArchivoImp implements IAccesoDatos{
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculaList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            var linea = bufferedReader.readLine();

            while (linea != null){
                peliculaList.add(new Pelicula(linea));

                linea = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            throw new LecturaDatosEx("Error al acceder al archivo... "+e.getMessage());
        } catch (IOException e) {
            e.getStackTrace();
            throw new LecturaDatosEx("Excepción al intentar acceder al archivo... "+e.getMessage());
        }
        return peliculaList;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(archivo, anexar));
            printWriter.println(pelicula);

            System.out.println("Película "+pelicula+" agregada correctamente...");
            printWriter.close();
        } catch (IOException e) {
            e.getStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir en el archivo..."+e.getMessage());
        }


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
