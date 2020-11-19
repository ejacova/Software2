package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Medico.control", query="SELECT m FROM Medico m WHERE m.cedulaMed = :cedulaMed AND m.contraseñaMed = :contraseñaMed"),
	@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")})
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cedulaMed;

	private String apellidoMed;

	private String contraseñaMed;

	private String nombreMed;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="medico")
	private List<Cita> citas;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="medico")
	private List<Horario> horarios;

	public Medico() {
	}

	public int getCedulaMed() {
		return this.cedulaMed;
	}

	public void setCedulaMed(int cedulaMed) {
		this.cedulaMed = cedulaMed;
	}

	public String getApellidoMed() {
		return this.apellidoMed;
	}

	public void setApellidoMed(String apellidoMed) {
		this.apellidoMed = apellidoMed;
	}

	public String getContraseñaMed() {
		return this.contraseñaMed;
	}

	public void setContraseñaMed(String contraseñaMed) {
		this.contraseñaMed = contraseñaMed;
	}

	public String getNombreMed() {
		return this.nombreMed;
	}

	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setMedico(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMedico(null);

		return cita;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setMedico(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setMedico(null);

		return horario;
	}

}