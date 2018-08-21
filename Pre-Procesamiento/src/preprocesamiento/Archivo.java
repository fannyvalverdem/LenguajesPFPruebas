/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocesamiento;



import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Archivo {
    
    // Método mostrar Contenido
    public static ArrayList muestraContenido(String archivo) throws FileNotFoundException, IOException {
        ArrayList lectura = new ArrayList();
        String cadena;
        FileReader f = new FileReader("Scraping/"+archivo);     
        try (BufferedReader b = new BufferedReader(f)) {        // Uso de FileReader y Bufferred para leer archivo
            while((cadena = b.readLine())!=null) {
                lectura.add(cadena);
            }
        }
        return lectura;
    }
    
    // Método agregar contenido
    public static void agregarContenido(String nombreArchivo,String SCadena) throws FileNotFoundException, IOException {
        // Uso de FileReader y Bufferred para agregar información al archivo
        try (BufferedWriter out = new BufferedWriter(new FileWriter("Procesado/"+nombreArchivo, true))) { 
            out.write("\n"+SCadena);
        }  
        System.out.println("Se agrego exitosamente.");
    }
    
    // Método eliminar archivo
    public static void eliminaArchivo(String nombreArchivo) {

        File fichero = new File(nombreArchivo);
        
        fichero.delete();
    }
    
    // Método modificar contenido
    public static void modificarContenido(ArrayList nombreArrayList, String nombreArchivo)throws FileNotFoundException, IOException {
        eliminaArchivo(nombreArchivo);  // Uso de método eliminar archivo

        try (FileWriter fichero = new FileWriter(nombreArchivo)) {
            for (Object linea : nombreArrayList) {
                fichero.write(linea + "\r\n");
            }
        }

    }
    
    public static ArrayList<Entrada> separartag(ArrayList<String> lista,String tag){
        ArrayList<Entrada> lista2=new ArrayList<>();
        for(Object linea:lista){
            String cadena=String.valueOf(linea);
            String[] cad=cadena.split("\\|");
            Entrada autos2=new Entrada(tag,cad[0],Integer.parseInt(cad[1]),Integer.parseInt(cad[2]),Integer.parseInt(cad[3]));
            lista2.add(autos2);
            
            }
        return lista2;
    
    }

}
