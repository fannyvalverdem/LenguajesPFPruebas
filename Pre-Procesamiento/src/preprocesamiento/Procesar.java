/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocesamiento;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Procesar {

    public Procesar() {
    }
    
    public void procesarporvotos(ArrayList<Entrada> entradas,String nombre) throws IOException{
        entradas.sort((Entrada e1, Entrada e2)->e2.getVotos()-e1.getVotos());
        Archivo.modificarContenido(entradas,nombre+"votos.csv");
        
    }
    
    
    public void procesarporvistas(ArrayList<Entrada> entradas,String nombre) throws IOException{
        entradas.sort((Entrada e1, Entrada e2)->e2.getVistas()-e1.getVistas());
        Archivo.modificarContenido(entradas,nombre+"vistas.csv");
    }
    
    public void procesarporrespuestas(ArrayList<Entrada> entradas,String nombre) throws IOException{
        entradas.sort((Entrada e1, Entrada e2)->e2.getRespuestas()-e1.getRespuestas());
        Archivo.modificarContenido(entradas,nombre+"respuestas.csv");
    }
}
