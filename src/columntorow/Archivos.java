/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package columntorow;

import java.io.*;

/**
 *
 * @author Miguel
 */
public class Archivos {
    
    public static int cantidadDePalabras(String nombreArchivo){
        File           archivo ;
        FileReader     fr      ;
        BufferedReader br      ;
        String         linea   ;
        int            i  =   0;
         
        try{
            archivo = new File( nombreArchivo );
            fr = new FileReader( archivo );
            br = new BufferedReader( fr );
            
            while( (linea = br.readLine())!= null)
                i++;            
            
            fr.close();
            br.close();

            return i;            
        }catch ( Exception e ){
            e.printStackTrace();
         }       
   
        return 0;
    }
    
    public static String[] leerArchivoDeTexto (String nombreArchivo){
        
        File           archivo ;
        FileReader     fr      ;
        BufferedReader br      ;
        String         linea   ;
        String         []lineas; 
        int            i  =   0;
         
        try{
            archivo = new File( nombreArchivo );
            fr = new FileReader( archivo );
            br = new BufferedReader( fr );
            
            while( (linea = br.readLine())!= null)
                i++;            
            fr.close();
            br.close();
            
            fr = new FileReader( archivo );
            br = new BufferedReader( fr );
                
            lineas = new String [i];
            i = 0;
            
            while( (linea = br.readLine())!=null )
                lineas[i++] = linea;
            
            fr.close();
            br.close();
            System.out.println(lineas.length);
            return lineas;            
        }catch ( Exception e ){
            e.printStackTrace();
         }       
        
        return null;
    }
    public static String leerArchivoTexto ( String nombreArchivo ){
        
        FileReader     fr      ;
        BufferedReader br      ;
        String         linea   ;
        String         cadena  ; 
         
        try{
            fr = new FileReader( nombreArchivo );
            br = new BufferedReader( fr );
            
            cadena = "";
            while( (linea = br.readLine())!= null )
                cadena = cadena.concat(linea+"\r\n");
            
            fr.close();
            br.close();
            return cadena;            
        }catch ( Exception e ){
            e.printStackTrace();
         }             
        return null;
    }
    
    public static boolean escribeArchivo( String nombreArchivo, String[] contenido ){
        File           ar;
        FileWriter     fr;
        BufferedWriter br;
        
        try{
            ar = new File( nombreArchivo );//creacion del objeto archivo
            fr = new FileWriter( ar );     //establece que el archvivo es de escritura
            br = new BufferedWriter( fr ); //abre un canal entre el archivo y la aplicación
            
            for(int i = 0; i<contenido.length-1; i++)
                if(contenido.length>=1)
                    if(contenido[contenido.length-1]!=null)
                        br.write(contenido[contenido.length-1]);
            
            
            br.close();
            fr.close();
            
            return true;   
            
        }catch(Exception e){
            e.printStackTrace();
         }
        
        return false;
    }
    public static boolean escribeArchivo( String nombreArchivo, String cadena ){
        File           ar;
        FileWriter     fr;
        BufferedWriter br;
        
        try{
            ar = new File( nombreArchivo );//creacion del objeto archivo
            fr = new FileWriter( ar );     //establece que el archvivo es de escritura
            br = new BufferedWriter( fr ); //abre un canal entre el archivo y la aplicación
            
            
            br.write(cadena);
                    
            br.close();
            fr.close();
            
            return true;   
            
        }catch(Exception e){
            e.printStackTrace();
         }
        
        return false;
    }
    public static BufferedWriter addLine(BufferedWriter br, String cadena){
        
        try{                   
            br.write(cadena+"\r\n");
            return br;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean saveFile(BufferedWriter br){
        
        try{
           
            br.close();     
            return true;
            
        }catch(Exception e){e.printStackTrace();}
        return false;
    }
        
    public static BufferedWriter newBuffer( String nomArch ) 
    {
        
        try{
            File ar = new File( nomArch );//creacion del objeto archivo
            FileWriter    fw = new FileWriter( ar );     //establece que el archvivo es de escritura
            BufferedWriter    bw = new BufferedWriter( fw ); //abre un canal entre el archivo y la aplicación
        
            return bw;        
        }catch( Exception e ){e.printStackTrace();}
        
        return null;       
    }
    public static void copyTxt( String fuente, String destino){
        try{
            String []cadena = leerArchivoDeTexto(fuente);
            escribeArchivo( fuente,destino );
        }catch(Exception e){ e.getMessage(); }
        
        
        
    }
}
