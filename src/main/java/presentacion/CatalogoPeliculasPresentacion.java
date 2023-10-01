package presentacion;

import peliculas.negocio.CatalogoPeliculasImp;
import peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        ICatalogoPeliculas catalogoPeliculasImp = new CatalogoPeliculasImp();

        while (option != 0){
            System.out.println("""
               *******************************************
               *******************************************     
                    Selecione una opción:
                    1. Iniciar Catálogo
                    2. Añadir Película al Catálogo
                    3. Buscar Película al Catálogo
                    4. Listar Películas del Catálogo
                    0. Salir  
                    
               ********************************************
               ********************************************          
                    """);
            option = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (option){
                case 1:
                    catalogoPeliculasImp.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la película");
                    String pelicula = sc.nextLine();
                    catalogoPeliculasImp.agregarPelicula(pelicula);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la película a buscar");
                    String buscar = sc.nextLine();
                    catalogoPeliculasImp.buscarPelicula(buscar);
                    break;
                case 4:
                    catalogoPeliculasImp.listarPelicula();
                    break;
                case 0:
                    System.out.println("Hasta pronto...");
            }
        }
    }


}
