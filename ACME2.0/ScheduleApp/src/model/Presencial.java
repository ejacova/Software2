package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the presencial database table.
 * 
 */
@Entity
@NamedQuery(name="Presencial.findAll", query="SELECT p FROM Presencial p")
public class Presencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPresencial;

	private int codigoQR;

	private String instruccionesCita;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	private Cita cita;

	public Presencial() {
	}

	public int getIdPresencial() {
		return this.idPresencial;
	}

	public void setIdPresencial(int idPresencial) {
		this.idPresencial = idPresencial;
	}

	public int getCodigoQR() {
		return this.codigoQR;
	}

	public void setCodigoQR(int codigoQR) {
		this.codigoQR = codigoQR;
	}

	public String getInstruccionesCita() {
		return this.instruccionesCita;
	}

	public void setInstruccionesCita(String instruccionesCita) {
		this.instruccionesCita = instruccionesCita;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}