package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Login.control", query="SELECT l FROM Login l WHERE l.nombreUsuario = :nombreUsuario AND l.contraseña = :contraseña"),
	@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")})
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idregistro;

	private String contraseña;

	private String nombreUsuario;

	public Login() {
	}

	public int getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}