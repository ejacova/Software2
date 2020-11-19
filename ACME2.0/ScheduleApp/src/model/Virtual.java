package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the virtual database table.
 * 
 */
@Entity
@NamedQuery(name="Virtual.findAll", query="SELECT v FROM Virtual v")
public class Virtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idVirtual;

	private int pagoAnterioridad;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	private Cita cita;

	public Virtual() {
	}

	public int getIdVirtual() {
		return this.idVirtual;
	}

	public void setIdVirtual(int idVirtual) {
		this.idVirtual = idVirtual;
	}

	public int getPagoAnterioridad() {
		return this.pagoAnterioridad;
	}

	public void setPagoAnterioridad(int pagoAnterioridad) {
		this.pagoAnterioridad = pagoAnterioridad;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}