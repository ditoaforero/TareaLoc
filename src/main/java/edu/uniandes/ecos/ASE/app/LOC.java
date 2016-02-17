/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

/**
 * Clase encargada de realizar el procesamiento de las lineas para identificar
 * como se debe contar dicha linea
 *
 * @author Dito
 */
public class LOC {

    private int numeroLineas = 0;
    /*Numero de lineas contados*/
    private int numeroClases = 0;
    /*Número de clases contados*/
    private int numeroMetodos = 0;
    /*Numero de metodos contados*/
    // Bloque de comentarios de prueba //
    /**
     * 
     */
    //Prueba de variables
    /*
    prueba -> este debe contar
    */

    private final String METODO = "^Metodo: ";
    private final String LINEA = ";$";
    private final String CLASE = " class ";

    private final String OPERACION01 = "\\)$";
    private final String OPERACION02 = "\\}$";
    private final String OPERACION03 = "\\{$";

    private final String COMENTARIO01 = "^\\*";
    private final String COMENTARIO02 = "^\\/\\*";
    private final String COMENTARIO03 = "^\\/\\/";
    private final String COMENTARIO04 = "^\\/\\/";
    private final String COMENTARIO05 = "^\\*\\/";

    /*
    Metodo: Retorna el numero de lineas contadas
     */
    public int getNumeroLineas() {
        return numeroLineas;
    }

    /*
    Metodo: Modfiica el numero de lineas contadas
     */
    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    /*
    Metodo: Retorna el numero de lineas contadas
     */
    public int getNumeroClases() {
        return numeroClases;
    }

    /*
    Metodo: Modifica el numero de clases contadas
     */
    public void setNumeroClases(int numeroClases) {
        this.numeroClases = numeroClases;
    }

    /*
    Metodo: Retorna el número de metodos contados
     */
    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    /*
    Metodo: Modifica el numero de metodos contados
     */
    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }

    /*
    Metodo: Metodo encargado de aumentar el número de lineas segun el tipo de validación
     */
    public void contarLineas(String linea) {

        linea = linea.trim();
        procesarLinea(linea);

    }

    /*
    Metodo: Metodo encargado de procesar la linea
     */
    private void procesarLinea(String linea) {

        if (ExpresionRegular.verificarExpresionRegular(COMENTARIO01, linea)) {
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(COMENTARIO02, linea)) {
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(COMENTARIO03, linea)) {
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(COMENTARIO04, linea)) {
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(COMENTARIO05, linea)) {
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(METODO, linea)) {
            numeroMetodos++;
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(LINEA, linea)) {
            numeroLineas++;
            return;
        }
        if (ExpresionRegular.verificarExpresionRegular(OPERACION01, linea)) {
            numeroLineas++;
        }
        if (ExpresionRegular.verificarExpresionRegular(OPERACION02, linea)) {
            numeroLineas++;
        }
        if (ExpresionRegular.verificarExpresionRegular(OPERACION03, linea)) {
            numeroLineas++;
        }

        if (ExpresionRegular.verificarExpresionRegular(CLASE, linea)) {
            numeroClases++;
        }
    }

}
