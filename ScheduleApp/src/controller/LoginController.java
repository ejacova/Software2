package controller;

import java.io.Serializable;
import query.DataQuery;

public class LoginController implements Serializable {
	
	private String nombreUsuario;
	private String contraseña;
	private DataQuery query = new DataQuery();
	
	public String loginControlUser() {
		if(query.loginControl(nombreUsuario, contraseña)) {
			return "user.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
