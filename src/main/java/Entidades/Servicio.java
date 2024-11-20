package Entidades;

import java.util.Date;

public class Servicio {
    
private int idServicio;
	private String descripServicio;
	private int personaId;
	private int cpfBarbero;
	private Date fechaHoraCita;
	private Date fechaHoraPago;
	private double costoTotalServicio;
	private double costoComision;
	private double montoVenta;
	private double totalVentaDiaria;
        private int serviciosxBarbero;

	public Servicio(int idServicio, String descripServicio, int personaId, int cpfBarbero, Date fechaHoraCita, Date fechaHoraPago, double costoTotalServicio, double costoComision, double montoVenta, double totalVentaDiaria) {
    	this.idServicio = idServicio;
    	this.descripServicio = descripServicio;
    	this.personaId = personaId;
    	this.cpfBarbero = cpfBarbero;
    	this.fechaHoraCita = fechaHoraCita;
    	this.fechaHoraPago = fechaHoraPago;
    	this.costoTotalServicio = costoTotalServicio;
    	this.costoComision = costoComision;
    	this.montoVenta = montoVenta;
    	this.totalVentaDiaria = totalVentaDiaria;
	}

	public int getIdServicio() {
    	return idServicio;
	}

	public void setIdServicio(int idProducto) {
    	this.idServicio = idProducto;
	}

	public String getDescripServicio() {
    	return descripServicio;
	}

	public void setDescripServicio(String descripServicio) {
    	this.descripServicio = descripServicio;
	}

	public int getPersonaId() {
    	return personaId;
	}

	public void setPersonaId(int personaId) {
    	this.personaId = personaId;
	}

	public int getCpfBarbero() {
    	return cpfBarbero;
	}

	public void setCpfBarbero(int cpfBarbero) {
    	this.cpfBarbero = cpfBarbero;
	}

	public Date getFechaHoraCita() {
    	return fechaHoraCita;
	}

	public void setFechaHoraCita(Date fechaHoraCita) {
    	this.fechaHoraCita = fechaHoraCita;
	}

	public Date getFechaHoraPago() {
    	return fechaHoraPago;
	}

	public void setFechaHoraPago(Date fechaHoraPago) {
    	this.fechaHoraPago = fechaHoraPago;
	}

	public double getCostoTotalServicio() {
    	return costoTotalServicio;
	}

	public void setCostoTotalServicio(double costoTotalServicio) {
    	this.costoTotalServicio = costoTotalServicio;
	}

	public double getCostoComision() {
    	return costoComision;
	}

	public void setCostoComision(double costoComision) {
    	this.costoComision = costoComision;
	}

	public double getMontoVenta() {
    	return montoVenta;
	}

	public void setMontoVenta(double montoVenta) {
    	this.montoVenta = montoVenta;
	}

	public double getTotalVentaDiaria() {
    	return totalVentaDiaria;
	}

	public void setTotalVentaDiaria(double totalVentaDiaria) {
    	this.totalVentaDiaria = totalVentaDiaria;
	}

        public int getServiciosxBarbero() {
        return serviciosxBarbero;
        }

        public void setServiciosxBarbero(int serviciosxBarbero) {
        this.serviciosxBarbero = serviciosxBarbero;
        }
        
        
}

