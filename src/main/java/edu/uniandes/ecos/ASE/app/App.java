package edu.uniandes.ecos.ASE.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    /*
    Metodo: Metodo principal de ejecución
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor ingresa la ruta de la carpeta a recorrer: ");
        String ruta = scanner.next();
        LOC loc = new LOC();
        Archivo procesarArchivo = new Archivo();
        String linea;
        ListaArchivos listadoArchivos = new ListaArchivos();
        //final File raiz = new File("C:\\Users\\Dito\\Documents\\NetBeansProjects\\Tarea01-Estadistica");
        //final File raiz = new File("C:\\Users\\Dito\\Documents\\NetBeansProjects\\LOC-MVN");
        final File raiz = new File(ruta);
        final String expresionRegular = "\\.java$";

        listadoArchivos.obtenerArchivosExpRegular(raiz, expresionRegular);

        //Se realiza el conteo de lineas
        System.out.println("======================================");
        System.out.println("Se imprime el listado de archivos a procesar:");
        List<String> archivo = listadoArchivos.getListadoArchivos();
        for (int i = 0; i < archivo.size(); i++) {
            System.out.println(archivo.get(i));
            ArrayList lineas = procesarArchivo.retornarContenidoArchivoArrayList(archivo.get(i));
            for (int j = 0; j < lineas.size(); j++) {
                linea = (String) lineas.get(j);
                loc.contarLineas(linea);
            }
        }
        System.out.println("======================================");
        //Se imprime el conteo
        System.out.println("El número de clases en total es:" + loc.getNumeroClases());
        System.out.println("El número de metodos en total es:" + loc.getNumeroMetodos());
        System.out.println("El número de lineas en total es:" + loc.getNumeroLineas());
        System.out.println("======================================");
    }
}
