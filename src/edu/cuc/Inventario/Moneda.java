package edu.cuc.Inventario;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Moneda implements java.io.Serializable {

    private ArrayList<ImageIcon> fotos;
    private String valorYUnidad;
    private String caracteristicas;
    private String ceca;
    private String paisDeCreacion;
    private double peso;
    private String año;
    private String tipoDeMetal;
    private String estado;
    private String rareza;
    private int precioDeVenta;
    private int precioDeCompra;
    private double codigo;
    private String ubicacion;
    private String nota;
    private String error;
    private boolean vendida;

    public Moneda(String valorYUnidad, String caracteristicas, String ceca, String paisDeCreacion, double peso, String año, String tipoDeMetal, String estado, String rareza, int precioDeCompra, double codigo, String ubicacion, String nota, String error,boolean vendida) throws Exception {

        if (valorYUnidad.isEmpty()) {
            throw new Exception("Debe ingresar el valor con y la unidad de la moneda.");
        }
        if (caracteristicas.isEmpty()) {
            caracteristicas="No hay caracteristicas especificas para esta moneda.";
        }
        if (ceca.isEmpty()) {
            throw new Exception("Debe ingresar la ceca de la moneda.");
        }
        if (paisDeCreacion.isEmpty()) {
            throw new Exception("Debe ingresar el pais en el que la moneda fue creada");
        }
        if (peso == 0) {
            throw new Exception("Debe ingresar el peso de la moneda.");
        }
        if (año.isEmpty()) {
            throw new Exception("Debe ingresar el año de creacion de la moneda.");
        }
        if (tipoDeMetal.isEmpty()) {
            throw new Exception("Debe ingresar el tipo de metal que tiene la moneda.");
        }
        if (estado.isEmpty()||estado.equalsIgnoreCase("--------------")) {
            throw new Exception("Debe ingresar el estado que tiene la moneda.");
        }
        if (rareza.isEmpty()||rareza.equalsIgnoreCase("--------------")) {
            throw new Exception("Debe ingresar la rareza de la moneda.");
        }
        if (precioDeCompra == 0) {
            throw new Exception("Debe ingresar el precio por el que fue comprada la moneda.");
        }
        if (codigo == 0) {
            throw new Exception("Debe ingresar darle un codigo a la moneda a ingresar.");
        }
        if (ubicacion.isEmpty()) {
            throw new Exception("Debe ingresar la ubicacion de la moneda en el almacen.");
        }
        if (nota.isEmpty()) {
            nota = "No hay una nota para esta moneda";
        }
        if (error.isEmpty()) {
            error = "Esta moneda no tiene errores.";
        }
        this.fotos = new ArrayList<>();
        this.valorYUnidad = valorYUnidad;
        this.caracteristicas = caracteristicas;
        this.ceca = ceca;
        this.paisDeCreacion = paisDeCreacion;
        this.peso = peso;
        this.año = año;
        this.tipoDeMetal = tipoDeMetal;
        this.estado = estado;
        this.rareza = rareza;
        this.precioDeCompra = precioDeCompra;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.nota = nota;
        this.error = error;
        this.vendida = vendida;
        this.precioDeVenta=0;
    }

    public ArrayList<ImageIcon> getFotos() {
        return fotos;
    }

    public void agregarFoto(ImageIcon foto) throws Exception {
        if (foto == null) {
            throw new Exception("Debe agregar al menos una foto.");
        }
        this.fotos.add(foto);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws Exception {
        if (peso == 0) {
            throw new Exception("Debe ingresar el peso de la moneda.");
        }
        this.peso = peso;
    }

    public String getTipoDeMetal() {
        return tipoDeMetal;
    }

    public void setTipoDeMetal(String tipoDeMetal) throws Exception {
        if (tipoDeMetal.trim().isEmpty()) {
            throw new Exception("Debe ingresar el tipo de metal que tiene la moneda.");
        }
        this.tipoDeMetal = tipoDeMetal;
    }

    public String getCeca() {
        return ceca;
    }

    public void setCeca(String ceca) throws Exception {
        if (ceca.trim().isEmpty()) {
            throw new Exception("Debe ingresar la ceca de la moneda.");
        }
        this.ceca = ceca;
    }

    public String getPaisDeCreacion() {
        return paisDeCreacion;
    }

    public void setPaisDeCreacion(String paisDeCreacion) throws Exception {
        if (paisDeCreacion.trim().isEmpty()) {
            throw new Exception("Debe ingresar el pais en el que la moneda fue creada   ");
        }
        this.paisDeCreacion = paisDeCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if (estado.trim().isEmpty()) {
            throw new Exception("Debe ingresar el estado que tiene la moneda.");
        }
        this.estado = estado;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) throws Exception {
        if (caracteristicas.trim().isEmpty()) {
            throw new Exception("Debe ingresar una caracteristica de la moneda.");
        }
        this.caracteristicas = caracteristicas;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) throws Exception {
        if (rareza.trim().isEmpty()) {
            throw new Exception("Debe ingresar la rareza de la moneda.");
        }
        this.rareza = rareza;
    }

    public int getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(int precioDeVenta)  {

        this.precioDeVenta = precioDeVenta;
    }

    public int getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(int precioDeCompra) throws Exception {
        if (precioDeCompra == 0) {
                throw new Exception("Debe ingresar el precio por el que fue comprada la moneda.");

        }
        this.precioDeCompra = precioDeCompra;
    }

    public String getValorYUnidad() {
        return valorYUnidad;
    }

    public void setValorYUnidad(String valorYUnidad) throws Exception {
        if (valorYUnidad.trim().isEmpty()) {
            throw new Exception("Debe ingresar el valor con y la unidad de la moneda.");
        }
        this.valorYUnidad = valorYUnidad;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        if (error.trim().isEmpty()) {
            error = "Esta moneda no tiene errores.";
        }
        this.error = error;
    }

    public double getCodigo() {
        return codigo;
    }


    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) throws Exception {
        if (ubicacion.trim().isEmpty()) {
            throw new Exception("Debe ingresar la ubicacion de la moneda en el almacen.");
        }
        this.ubicacion = ubicacion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        if (nota.trim().isEmpty()) {
            nota = "Eo hay una nota para esta moneda";
        }
        this.nota = nota;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) throws Exception {
        if (año.trim().isEmpty()) {
            throw new Exception("Debe ingresar el año de creacion de la moneda.");
        }
        this.año = año;
    }

    public void guardar(ObjectOutputStream salida) {
        try {
            salida.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
