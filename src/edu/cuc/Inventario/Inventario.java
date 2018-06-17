/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.Inventario;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Inventario {

    public void llenarMonedas(JTable tabla, ArrayList<Moneda> monedas) {
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        this.vaciarTabla(tabla);
        int cantFilas = monedas.size();
        dt.setRowCount(cantFilas);
        for (int i = 0; i < cantFilas; i++) {
            dt.setValueAt(i + 1, i, 0);
            dt.setValueAt(monedas.get(i).getValorYUnidad(), i, 1);
            dt.setValueAt(monedas.get(i).getCaracteristicas(), i, 2);
            dt.setValueAt(monedas.get(i).getCeca(), i, 3);
            dt.setValueAt(monedas.get(i).getPaisDeCreacion(), i, 4);
            dt.setValueAt(monedas.get(i).getPeso(), i, 5);
            dt.setValueAt(monedas.get(i).getAño(), i, 6);
            dt.setValueAt(monedas.get(i).getTipoDeMetal(), i, 7);
            dt.setValueAt(monedas.get(i).getEstado(), i, 8);
            dt.setValueAt(monedas.get(i).getRareza(), i, 9);
            dt.setValueAt(monedas.get(i).getPrecioDeCompra(), i, 10);
            dt.setValueAt(monedas.get(i).getPrecioDeVenta(), i, 11);
            dt.setValueAt(monedas.get(i).getCodigo(), i, 12);
            dt.setValueAt(monedas.get(i).getUbicacion(), i, 13);
            dt.setValueAt(monedas.get(i).getNota(), i, 14);
            dt.setValueAt(monedas.get(i).getError(), i, 15);
            dt.setValueAt(monedas.get(i).isVendida(), i, 16);
        }

    }

    public void vaciarTabla(JTable tabla) {
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < dt.getRowCount(); i++) {
            dt.removeRow(i);

        }
    }

    public void guardar(ObjectOutputStream salida, Moneda m) {
        try {
            salida.writeObject(m);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Moneda> traermoneda(String ruta) {
        ArrayList<Moneda> monedas = new ArrayList();
        ObjectInputStream entrada;
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            Moneda m;
            while ((m = (Moneda) entrada.readObject()) != null) {
                monedas.add(m);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return monedas;
    }

    public void volcado(ObjectOutputStream salida, ArrayList<Moneda> monedas) {
        for (int i = 0; i < monedas.size(); i++) {
            try {
                salida.writeObject(monedas.get(i));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int cantidadMonedas(String ruta) {
        return this.traermoneda(ruta).size();
    }

    public void busquedaPais(JTable tabla, ArrayList<Moneda> monedas, String Pais)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getPaisDeCreacion().equalsIgnoreCase(Pais)) {
                respuesta.add(monedas.get(i));
            }
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaCeca(JTable tabla, ArrayList<Moneda> monedas, String cecaABuscar)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getCeca().equalsIgnoreCase(cecaABuscar)) {
                respuesta.add(monedas.get(i));
            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaFecha(JTable tabla, ArrayList<Moneda> monedas, String fechaABuscar) throws Exception{

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getAño().equalsIgnoreCase(fechaABuscar)) {
                
               respuesta.add(monedas.get(i));
            }
        } if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaPeso(JTable tabla, ArrayList<Moneda> monedas, double pesoABuscar) throws Exception{
        ArrayList<Moneda>respuesta=new ArrayList<>();
        int cantFilas = monedas.size();
        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getPeso() == pesoABuscar) {
                respuesta.add(monedas.get(i));
                
            }
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedametal(JTable tabla, ArrayList<Moneda> monedas, String metalABuscar)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getTipoDeMetal().equalsIgnoreCase(metalABuscar)) {
                respuesta.add(monedas.get(i));
            }
        } if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaValor(JTable tabla, ArrayList<Moneda> monedas, String valorABuscar)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getValorYUnidad().equalsIgnoreCase(valorABuscar)) {
                respuesta.add(monedas.get(i));
               
            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaRareza(JTable tabla, ArrayList<Moneda> monedas, String rarezaABuscar)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getRareza().equalsIgnoreCase(rarezaABuscar)) {
                respuesta.add(monedas.get(i));

            }  
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaCodigo(JTable tabla, ArrayList<Moneda> monedas, double codigoABuscar)throws Exception {

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).getCodigo() == codigoABuscar) {
                respuesta.add(monedas.get(i));
                
            }
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaVendidas(JTable tabla, ArrayList<Moneda> monedas, boolean vendidas)throws Exception {
        vendidas = true;

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).isVendida() == vendidas) {
                respuesta.add(monedas.get(i));

            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaNoVendidas(JTable tabla, ArrayList<Moneda> monedas, boolean vendidas) throws Exception{
        vendidas = false;

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (monedas.get(i).isVendida() == vendidas) {
                respuesta.add(monedas.get(i));

            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaPrecio(JTable tabla, ArrayList<Moneda> monedas, int precioA, int precioB)throws Exception {
        int precioDeVenta;

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            precioDeVenta = monedas.get(i).getPrecioDeVenta();
            if (precioA <= precioDeVenta && precioDeVenta <= precioB) {
                respuesta.add(monedas.get(i));

            }
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public void busquedaPrecioCompra(JTable tabla, ArrayList<Moneda> monedas, int precioA, int precioB)throws Exception {
        int precioDeCompra;

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            precioDeCompra = monedas.get(i).getPrecioDeCompra();
            if (precioA <= precioDeCompra && precioDeCompra <= precioB) {
                respuesta.add(monedas.get(i));
            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public boolean tieneError(ArrayList<Moneda> monedas) {
        boolean tieneError = false;
        for (int i = 0; i < monedas.size(); i++) {
            if (monedas.get(i).getError() != null || !"".equals(monedas.get(i).getError())) {
                tieneError = true;
            }
        }
        return tieneError;
    }

    public void busquedaErrores(JTable tabla, ArrayList<Moneda> monedas, String error)throws Exception {
        boolean tieneError = tieneError(monedas);

        ArrayList<Moneda>respuesta=new ArrayList<>();

        int cantFilas = monedas.size();

        for (int i = 0; i < cantFilas; i++) {
            if (tieneError && monedas.get(i).getError().equalsIgnoreCase(error)) {
                 respuesta.add(monedas.get(i));
               
            } 
        }if (respuesta.isEmpty()) {
                throw new Exception( "No se encontro ninguna moneda con este criterio de busqueda en el sistema.");
            }
            llenarMonedas(tabla, respuesta);
    }

    public boolean traducirSiNo(String SiNo) throws Exception{
        if (SiNo.equalsIgnoreCase("-----")) {
                throw new Exception("Debe escoger si ha vendido o no la moneda.");
            }
        if (SiNo.equalsIgnoreCase("si")) {
            return true;
        }else{
        return false;
        }
    }
       public void borrarDato(int opcion, int posicion, String ruta, String rutaJugadores, JTable tabla, ObjectOutputStream salida) throws Exception {
        posicion = tabla.getSelectedRow();
        ArrayList<Moneda> monedas = traermoneda(ruta);
        if (monedas.isEmpty()) {
            throw new Exception("No hay ninguna moneda seleccionado");
        }
        if (posicion > monedas.size() || posicion < 0) {
            throw new Exception("No hay ninguna Moneda seleccionado");
        }
        if (opcion == 0) {
            //1. Paso

            //2. Paso
            monedas.remove(posicion);
            //3. Paso
            try {
                salida = new ObjectOutputStream(new FileOutputStream(ruta));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //4. Paso
            volcado(salida, monedas);
            monedas=traermoneda(ruta);
            //5. Paso
            llenarMonedas(tabla,monedas);

        }

    }

    public int convertirStringAInt(JTextField contenedor) throws Exception {
        String palabra = contenedor.getText().trim();
        if (palabra.isEmpty()) {
            throw new Exception("No puede dejar el valor de precio de compra vacio.");
        }
        return Integer.parseInt(palabra);
    }
    
    public double ConvertirStringADouble(JTextField contenedor){
    String palabra= contenedor.getText().trim();
        if (palabra.isEmpty()) {
            return -1;
        }
        return Double.parseDouble(palabra);
    }
    
    public void MostrarImagenes (JLabel imagen, ArrayList<ImageIcon> imagenes, int contador){
        ImageIcon imagenAMostrar= imagenes.get(contador);
imagen.setIcon(new ImageIcon(imagenAMostrar.getImage().getScaledInstance(650,576,Image.SCALE_SMOOTH)));
        
    
    }
    
    public boolean validarCodigo(String ruta, double codigo){
    ArrayList<Moneda> monedas= traermoneda(ruta);
        for (int i = 0; i < monedas.size(); i++) {
            Moneda get = monedas.get(i);
            if (get.getCodigo() == codigo) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String CantidadVendidas(ArrayList<Moneda> monedas) {
        int contador = 0;
        String respuesta;
        for (int i = 0; i < monedas.size(); i++) {
            Moneda moneda = monedas.get(i);
            if (moneda.isVendida()) {
                contador++;
            }
        }
        if (contador!=0) {
            respuesta = "La cantidad de monedas vendidas hasta el momento es: " + contador + ".";
        }else{
        respuesta="No hay monedas vendidas hasta el momento.";
        }
        return respuesta;
    }

    public String CantidadErrores(ArrayList<Moneda> monedas) {
        int contador = 0;
        String respuesta;
        for (int i = 0; i < monedas.size(); i++) {
            Moneda moneda = monedas.get(i);
            if (monedas.get(i).getError() != null || !"".equals(monedas.get(i).getError())) {
                contador++;
            }
        }if (contador!=0) {
            respuesta= "La cantidad de monedas con error registradas en el sistema es de: "+contador+".";
        }else{
        respuesta="No hay monedas con error registradas en el sistema.";
        }
        
        return respuesta;
    }

    public String PesoDeMetal(ArrayList<Moneda> monedas, String tipoMetal){
    double peso=0;
    String respuesta;
        for (int i = 0; i < monedas.size(); i++) {
            Moneda moneda = monedas.get(i);
            if (moneda.getTipoDeMetal().equalsIgnoreCase(tipoMetal)) {
                peso+=moneda.getPeso();
            }
        }
        if (peso!=0) {
            respuesta="El peso total de este metal es: "+peso+".";
        }else{
        respuesta="No hay monedas con este tipo de metal tefistradas en el sistema.";
        
        }
        
        return respuesta;
    
    }
    
    
}
