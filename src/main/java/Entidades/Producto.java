
package Entidades;

import java.time.LocalDate;

public class Producto {
    
    private int idProducto;
	private String descripcionProducto;
	private boolean prodControlado;
	private int cantProdxId = 0;
	private double precioVenta;
	private LocalDate fechaVencimiento;

	public Producto(int idProducto, String descripcionProducto, boolean prodControlado, int cantProdxId, double precioVenta, LocalDate fechaVencimiento) {
    	this.idProducto = idProducto;
    	this.descripcionProducto = descripcionProducto;
    	this.prodControlado = prodControlado;
    	this.cantProdxId = cantProdxId;
    	this.precioVenta = precioVenta;
    	this.fechaVencimiento = fechaVencimiento;
	}

	public int getIdProducto() {
    	return idProducto;
	}

	public void setIdProducto(int idProducto) {
    	this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
    	return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
    	this.descripcionProducto = descripcionProducto;
	}

	public void setProdControlado(boolean prodControlado) {
    	this.prodControlado = prodControlado;
	}

        public boolean isProdControlado() {
        return prodControlado;
        }
        
	public int getCantProdxId() {
    	return cantProdxId;
	}

	public void setCantProdxId(int cantProdxId) {
    	this.cantProdxId = cantProdxId;
	}

	public double getPrecioVenta() {
    	return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
    	this.precioVenta = precioVenta;
	}

	public LocalDate getFechaVencimiento() {
    	return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
    	this.fechaVencimiento = fechaVencimiento;
	}
    
}


