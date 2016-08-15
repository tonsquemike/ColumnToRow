/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package columntorow;

import Funciones.MyListArgs;
import Funciones.MySintaxis;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author miguel
 */
public class principal {
    String             IN  ;
    String            OUT  ;
    String         output  ;
    String            DIR  ;
    String    docFileName  ;
    int                 i  ;   
    BufferedWriter     bw  ;
    BufferedReader    brL  ;
    
    String          NORMA  = ""  ;    
    String  []NORMA_LINES  = null;
    int       NORMA_INDEX  = 0   ;
    
    int         actualDoc  = 0   ;
    int          countDoc  = 0   ;
    
    principal(String[]args)
    {
        String        ConfigFile = "";
        MyListArgs         Param     ;
        BufferedImage      image     ;

        Param      = new MyListArgs(args)                  ;
        ConfigFile = Param.ValueArgsAsString("-CONFIG", "");

        if (!ConfigFile.equals(""))
        {
            Param.AddArgsFromFile(ConfigFile);
        }

        String Sintaxis   = "-IN:str -OUT:str";
        MySintaxis Review = new MySintaxis(Sintaxis, Param);

        IN                = Param.ValueArgsAsString ( "-IN"   , "" );
        OUT               = Param.ValueArgsAsString ( "-OUT"  , "" );
        //DIR               = Param.ValueArgsAsString ( "-DIR"  , "" );
        i                 = 0;
        
        File tmp = new File(OUT);
        if(tmp.isDirectory() & !OUT.endsWith(".*"))
        {
            tmp.mkdirs();
        }    
        
        //abrir buffer de escritura      
        //bw = Archivos.newBuffer(OUT);    
               
        try
        {
            brL = new BufferedReader(new FileReader(NORMA));
        }catch(Exception e){}  

        if(new File(IN).isDirectory())
        {
            //System.out.println("DIR");
            DIR = IN;
        }
    }
    public boolean process()
    {
        System.out.println("process 22");
        boolean           bnd = false;
        float             tmp =     0;
        int           counter =     0;
        int     globalCounter =     0;     
        
        String         []temp =  null;
        String         salida =  null;
        String          value =  null;         
        File            files =  null;
        
                
        String columnValue = "";
        if(!DIR.equals("") & i == 0)
        {
            files = new File(DIR);
            temp  = files.list();
            IN    = DIR+File.separator+temp[0];
            i++;
        }
        
        try
        {       
            salida = "";
            if(!IN.endsWith(".DS_Store") & !IN.endsWith(".thumbs") & !new File(IN).getName().startsWith("._"))
            {
                if(!this.NORMA.equals(""))
                {
                    try{
                        value = brL.readLine();
                    }catch(Exception e){}
                    //System.out.println("****VALUE = "+value);
                }
                System.out.println("-IN1 "+IN);
               // System.out.println("INGGG");
                BufferedReader br = new BufferedReader(new FileReader(IN));
                
                String  line;
                String out = "";
                //String salida = "";
                while ((line = br.readLine()) != null) 
                {
                    
                    try{
                        out = line.substring(0, line.indexOf(" "));
                    }catch(Exception e)
                    {
                        out = line;
                    }
                    
                    //System.out.println("line = "+out);
                    salida += out+",";
                }
                
                //System.out.println("salida = "+salida);
                //salida = salida.substring(0, salida.length()-2);
                
                output = salida.substring(0, salida.length()-1);
                
                //int variables = counter;
                //output   = String.valueOf(counter);
                //System.out.println("-IN "+IN);
                //System.out.println("output = "+output);

                try
                {
                    Archivos.escribeArchivo(OUT+File.separator+new File(IN).getName(), output);

                }catch(Exception e){}
            }
        }catch(Exception e){}
       
        if(!DIR.equals(""))
        {
            files = new File(DIR);
            temp  = files.list();     
            
            
            while(i < temp.length) 
            {
                IN = DIR+File.separator+temp[i];
                //System.out.println("i = "+i);
                //System.out.println("-IN = "+IN);
                i++;
                process();
            }
        }
        /*try
        {
            Archivos.saveFile(bw);
        }catch(Exception e){}*/
        
        return bnd;
    }
    
}
