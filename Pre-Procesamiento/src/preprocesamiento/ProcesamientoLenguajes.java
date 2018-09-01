/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocesamiento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;


/**
 *
 * @author isabe
 */
public class ProcesamientoLenguajes{
    
    
    public static void main(String[] args) throws IOException, FileNotFoundException, JSONException {
        String csv[]={"activas.csv","android.csv","c#.csv","destacadas.csv","html.csv"
        ,"java.csv","javascript.csv","jquery.csv","mes.csv","php.csv","popular.csv","python.csv"
        ,"semana.csv"};
        String csv2[]={"activas.csv","android.csv","c#.csv","destacadas.csv","html.csv"
        ,"java.csv","javascript.csv","jquery.csv","mes.csv","php.csv","popular.csv","python.csv"
        ,"semana.csv"};
        
        for(String archivo: csv){
            ArrayList lec=Archivo.muestraContenido(archivo);
            
            String nombre=archivo.split(".csv")[0];
            //System.out.println(nombre);
            //Scraping/Shangai/Anios
            
            ArrayList<Entrada> tags=Archivo.separartag(lec, nombre);
            Procesar p=new Procesar();
            p.procesarporrespuestas(tags,nombre);
            p.procesarporvistas(tags,nombre);
            p.procesarporvotos(tags,nombre);
        }
    }
    
}
