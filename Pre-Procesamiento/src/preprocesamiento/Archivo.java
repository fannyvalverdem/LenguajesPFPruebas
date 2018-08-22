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
                //System.out.println(cadena);
            }
        }
        return lectura;
    }
    
    // Método eliminar archivo
    public static void eliminaArchivo(String nombreArchivo) {

        File fichero = new File(nombreArchivo);
        
        fichero.delete();
    }
    
    // Método modificar contenido
    public static void modificarContenido(ArrayList<Entrada> nombreArrayList, String nombreArchivo)throws FileNotFoundException, IOException {
        eliminaArchivo(nombreArchivo);  // Uso de método eliminar archivo
        String cadena;
        File directorio = new File("Procesado");
        directorio.mkdir();
        try (FileWriter fichero = new FileWriter("Procesado/"+nombreArchivo)) {
            for (Entrada linea : nombreArrayList) {
                cadena=linea.getPreguntas()+"--"+linea.getRespuestas()+"--"+linea.getVotos()+"--"+linea.getVistas();
                fichero.write(cadena + "\r\n");
            }
        }

    }
    
    public static ArrayList<Entrada> separartag(ArrayList<String> lista,String tag){
        ArrayList<Entrada> lista2=new ArrayList<>();
        int cont=0;
        for(Object linea:lista){
            String cadena=String.valueOf(linea);
            cont++;
            //System.out.println(cont);
            if(cadena.length()!=0){
                String[] cad=cadena.split("--");
                String preguntas=cad[0];
                int respuestas,votos,vistas;
                if(cad[1].split(" ")[1].endsWith("k")){
                    respuestas=Integer.parseInt(cad[1].split(" ")[1].split("k")[0])*1000;
                }
                else if(cad[1].split(" ")[1].endsWith("m")){
                    respuestas=Integer.parseInt(cad[1].split(" ")[1].split("k")[0])*1000000;
                }
                else{
                    respuestas=Integer.parseInt(cad[1].split(" ")[1]);
                }
                
                if(cad[2].split(" ")[1].endsWith("k")){
                    votos=Integer.parseInt(cad[2].split(" ")[1].split("k")[0])*1000;
                }
                else if(cad[2].split(" ")[1].endsWith("m")){
                    votos=Integer.parseInt(cad[2].split(" ")[1].split("k")[0])*1000000;
                }
                else{
                    votos=Integer.parseInt(cad[2].split(" ")[1]);    
                }
                
                if(cad[3].split(" ")[1].endsWith("k")){
                    vistas=Integer.parseInt(cad[3].split(" ")[1].split("k")[0])*1000;
                }
                else if(cad[3].split(" ")[1].endsWith("m")){
                    vistas=Integer.parseInt(cad[3].split(" ")[1].split("k")[0])*1000000;
                }
                else{
                    vistas=Integer.parseInt(cad[3].split(" ")[1]);
                }
                
                Entrada autos2=new Entrada(tag,preguntas,respuestas,votos,vistas);
                lista2.add(autos2);
                }
            }
        return lista2;
    
    }

}
