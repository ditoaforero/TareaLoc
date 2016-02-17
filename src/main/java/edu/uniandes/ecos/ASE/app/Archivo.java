/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dito
 */
public class Archivo {

    /*
    Metodo: Retorna el contenido de un archivo en un LinkedList
     */
    public LinkedList retornarContenidoArchivoLinkedList(String ruta) {
        // Se crea una linkedlist auxilar 
        LinkedList ll = null;
        // Se valida si existe el archivo
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            return ll;
        }
        ll = new LinkedList();
//        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
//            String line;
//            // Se recorre el archivo y se va llenando el LinkedList
//            while ((line = br.readLine()) != null) {
//                ll.add(line);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;
            // Se recorre el archivo y se va llenando el LinkedList
            while ((line = br.readLine()) != null) {
                ll.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ll;
    }

    /*
    Metodo: Verifica la existencia de un archivo en una ruta especificada
     */
    public boolean verificarExistenciaArchivo(String ruta) {
        return new File(ruta).exists();
    }

    /*
    Metodo: Metodo que retorna el contenido de un archivo
     */
    public ArrayList retornarContenidoArchivoArrayList(String ruta) {
        // Se crea una linkedlist auxilar 
        ArrayList al = null;
        // Se valida si existe el archivo
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            return al;
        }
        al = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta)); 
            String line;
            // Se recorre el archivo y se va llenando el LinkedList
            while ((line = br.readLine()) != null) {
                al.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }


}
