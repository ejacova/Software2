package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCita;

	private int celular;

	@Temporal(TemporalType.DATE)
	private Date fechaCita;

	private String horaCita;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	private Paciente paciente;

	//bi-directional many-to-one association to Secretaria
	@ManyToOne
	private Secretaria secretaria;

	//bi-directional many-to-one association to Presencial
	@OneToMany(mappedBy="cita")
	private List<Presencial> presencials;

	//bi-directional many-to-one association to Virtual
	@OneToMany(mappedBy="cita")
	private List<Virtual> virtuals;

	public Cita() {
	}

	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Secretaria getSecretaria() {
		return this.secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public List<Presencial> getPresencials() {
		return this.presencials;
	}

	public void setPresencials(List<Presencial> presencials) {
		this.presencials = presencials;
	}

	public Presencial addPresencial(Presencial presencial) {
		getPresencials().add(presencial);
		presencial.setCita(this);

		return presencial;
	}

	public Presencial removePresencial(Presencial presencial) {
		getPresencials().remove(presencial);
		presencial.setCita(null);

		return presencial;
	}

	public List<Virtual> getVirtuals() {
		return this.virtuals;
	}

	public void setVirtuals(List<Virtual> virtuals) {
		this.virtuals = virtuals;
	}

	public Virtual addVirtual(Virtual virtual) {
		getVirtuals().add(virtual);
		virtual.setCita(this);

		return virtual;
	}

	public Virtual removeVirtual(Virtual virtual) {
		getVirtuals().remove(virtual);
		virtual.setCita(null);

		return virtual;
	}

}