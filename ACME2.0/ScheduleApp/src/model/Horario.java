package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idHorario;

	@Temporal(TemporalType.DATE)
	private Date fechaMed;

	private String horaMed;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	private Medico medico;

	public Horario() {
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public Date getFechaMed() {
		return this.fechaMed;
	}

	public void setFechaMed(Date fechaMed) {
		this.fechaMed = fechaMed;
	}

	public String getHoraMed() {
		return this.horaMed;
	}

	public void setHoraMed(String horaMed) {
		this.horaMed = horaMed;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}