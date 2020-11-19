package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Paciente.control", query="SELECT p FROM Paciente p WHERE p.cedulaPac = :cedulaPac AND p.contraseñaPac = :contraseñaPac"),
	@NamedQuery(name="Paciente.findCed", query="SELECT p FROM Paciente p WHERE p.cedulaPac = :cedulaPac"),
	@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cedulaPac;

	private String apellidoPac;

	private String celular;

	private String contraseñaPac;

	private String correo;

	@Temporal(TemporalType.DATE)
	private Date fechaDeNacimiento;

	private String nombrePac;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="paciente")
	private List<Cita> citas;

	public Paciente() {
	}

	public int getCedulaPac() {
		return this.cedulaPac;
	}

	public void setCedulaPac(int cedulaPac) {
		this.cedulaPac = cedulaPac;
	}

	public String getApellidoPac() {
		return this.apellidoPac;
	}

	public void setApellidoPac(String apellidoPac) {
		this.apellidoPac = apellidoPac;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContraseñaPac() {
		return this.contraseñaPac;
	}

	public void setContraseñaPac(String contraseñaPac) {
		this.contraseñaPac = contraseñaPac;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombrePac() {
		return this.nombrePac;
	}

	public void setNombrePac(String nombrePac) {
		this.nombrePac = nombrePac;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setPaciente(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setPaciente(null);

		return cita;
	}

}