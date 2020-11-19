package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the secretaria database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Secretaria.control", query="SELECT s FROM Secretaria s WHERE s.cedulaSec = :cedulaSec AND s.contraseñaSec = :contraseñaSec"),
	@NamedQuery(name="Secretaria.findAll", query="SELECT s FROM Secretaria s")})
public class Secretaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cedulaSec;

	private String apellidoSec;

	private String contraseñaSec;

	private String nombreSec;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="secretaria")
	private List<Cita> citas;

	public Secretaria() {
	}

	public int getCedulaSec() {
		return this.cedulaSec;
	}

	public void setCedulaSec(int cedulaSec) {
		this.cedulaSec = cedulaSec;
	}

	public String getApellidoSec() {
		return this.apellidoSec;
	}

	public void setApellidoSec(String apellidoSec) {
		this.apellidoSec = apellidoSec;
	}

	public String getContraseñaSec() {
		return this.contraseñaSec;
	}

	public void setContraseñaSec(String contraseñaSec) {
		this.contraseñaSec = contraseñaSec;
	}

	public String getNombreSec() {
		return this.nombreSec;
	}

	public void setNombreSec(String nombreSec) {
		this.nombreSec = nombreSec;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setSecretaria(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setSecretaria(null);

		return cita;
	}

}