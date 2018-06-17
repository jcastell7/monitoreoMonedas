/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.Inventario;


import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juan
 */

public class Copiar {
    
private JFileChooser escoger;
Window w;
int status;
FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
ImageIcon imagen;
    public Copiar() {
        escoger= new JFileChooser();
        escoger.setFileFilter(filtroImagen);
        w= new Window(null);
        imagen=CopiarImagen();
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    
    
    public static void cp(String archivoOrigen, String archivoDestino) throws IOException { 
        FileInputStream copiarDesde = null; 
        FileOutputStream copiarA = null; 
        
        try { 
            copiarDesde = new FileInputStream(archivoOrigen); 
            copiarA = new FileOutputStream(archivoDestino); 
            byte[] buffer = new byte[4096]; 
            int lecturaBytes; 
            
            while((lecturaBytes = copiarDesde.read(buffer)) != -1) 
                copiarA.write(buffer, 0, lecturaBytes);        
            System.out.println("El archivo se ha copiado correctamente."); 
        } finally { 
            if(copiarDesde != null) 
                try { 
                    copiarDesde.close(); 
                } catch (IOException IOE) { 
                    ; 
                } 
            if(copiarA != null) 
                try{ 
                    copiarA.close(); 
                } catch (IOException IOE) { 
                    ; 
                } 
        } 
    } 

public ImageIcon CopiarImagen (){
    status=escoger.showOpenDialog(null);
if(status == escoger.APPROVE_OPTION){
            try {                                              
                
                // TODO add your handling code here:
                String ruta= escoger.getSelectedFile().getAbsolutePath();
                ImageIcon imagen=new ImageIcon(ruta);
                String origen=ruta;
                String nombre =escoger.getSelectedFile().getName();
                File fichero = new File ("src/edu/cuc/Imagenes/imagenNueva.jpg");
                try {
                    // A partir del objeto File creamos el fichero físicamente
                    if (fichero.createNewFile())
                        System.out.println("El fichero se ha creado correctamente");
                    else
                        System.out.println("No ha podido ser creado el fichero");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                String Rutafinal="src/edu/cuc/Imagenes/imagenNueva.jpg";
                
                cp(origen, Rutafinal);
                File nuevo= new File("src/edu/cuc/Imagenes/"+nombre);
                fichero.renameTo(nuevo);
                fichero.delete();
                String rutaImagen= nuevo.getAbsolutePath();
                ImageIcon imagenEnArray = new ImageIcon(rutaImagen);
                return imagenEnArray;
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            
}
         
}else{
w.dispose();
}
    return null;

}


}