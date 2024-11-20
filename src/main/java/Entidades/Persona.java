package Entidades;

import java.time.LocalDate;

public class Persona {

private boolean barbero;
  private int personaId;
  private String cpfBarbero;
  private String nombre;
  private String tel;
  private LocalDate anivCliente;

	public Persona(boolean barbero, int personaId, String cpfBarbero, String nombre, String tel, LocalDate anivCliente) {
    	this.barbero = barbero;
    	this.cpfBarbero = cpfBarbero;
    	this.nombre = nombre;
    	this.tel = tel;
    	this.anivCliente = anivCliente;
	}

	public boolean isBarbero() {
    	return barbero;
	}

	public void setBarbero(boolean barbero) {
    	this.barbero = barbero;
	}

	public String getCpfBarbero() {
    	return cpfBarbero;
	}

	public void setCpfBarbero(String cpfBarbero) {
    	this.cpfBarbero = cpfBarbero;
	}

	public String getNombre() {
    	return nombre;
	}

	public void setNombre(String nombre) {
    	this.nombre = nombre;
	}

	public String getTel() {
    	return tel;
	}

	public void setTel(String tel) {
    	this.tel = tel;
	}

	public LocalDate getAnivCliente() {
    	return anivCliente;
	}

	public void setAnivCliente(LocalDate anivCliente) {
    	this.anivCliente = anivCliente;
	}

	public void modificarBarbero(){
    	//conexión a base de datos
	}

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getPersonaId() {
        return personaId;
    }
    
}

