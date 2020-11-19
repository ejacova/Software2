package controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import query.DataQuery;

public class SearchController implements Serializable {
	
	private Integer cedulaPac;
	private String contraseñaPac;
	private Integer cedulaSec;
	private String contraseñaSec;
	private Integer cedulaMed;
	private String contraseñaMed;
	private DataQuery query = new DataQuery();
	
	public String loginControlPaciente() {
		if(query.loginPacienteControl(cedulaPac, contraseñaPac)) {
			return "Citas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String loginControlSecretaria() {
		if(query.loginSecretariaControl(cedulaSec, contraseñaSec)) {
			return "Scitas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String loginControlMedico() {
		if(query.loginMedicoControl(cedulaMed, contraseñaMed)) {
			return "Citas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public void memberControlUser() {
		if(query.memberControl(cedulaPac)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Usted se encuentra registrado"));
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Inicie sesion para agendar una cita"));
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Usted no se encuentra registrado"));
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Por favor dirijase a contactos"));
		}
	}

	public Integer getCedulaPac() {
		return cedulaPac;
	}

	public void setCedulaPac(Integer cedulaPac) {
		this.cedulaPac = cedulaPac;
	}

	public String getContraseñaPac() {
		return contraseñaPac;
	}

	public void setContraseñaPac(String contraseñaPac) {
		this.contraseñaPac = contraseñaPac;
	}
	
	public Integer getCedulaSec() {
		return cedulaSec;
	}

	public void setCedulaSec(Integer cedulaSec) {
		this.cedulaSec = cedulaSec;
	}

	public String getContraseñaSec() {
		return contraseñaSec;
	}

	public void setContraseñaSec(String contraseñaSec) {
		this.contraseñaSec = contraseñaSec;
	}

	public Integer getCedulaMed() {
		return cedulaMed;
	}

	public void setCedulaMed(Integer cedulaMed) {
		this.cedulaMed = cedulaMed;
	}

	public String getContraseñaMed() {
		return contraseñaMed;
	}

	public void setContraseñaMed(String contraseñaMed) {
		this.contraseñaMed = contraseñaMed;
	}

}
