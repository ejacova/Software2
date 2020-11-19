package controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import query.DataQuery;

public class SearchController implements Serializable {
	
	private Integer cedulaPac;
	private String contrase�aPac;
	private Integer cedulaSec;
	private String contrase�aSec;
	private Integer cedulaMed;
	private String contrase�aMed;
	private DataQuery query = new DataQuery();
	
	public String loginControlPaciente() {
		if(query.loginPacienteControl(cedulaPac, contrase�aPac)) {
			return "Citas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String loginControlSecretaria() {
		if(query.loginSecretariaControl(cedulaSec, contrase�aSec)) {
			return "Scitas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String loginControlMedico() {
		if(query.loginMedicoControl(cedulaMed, contrase�aMed)) {
			return "Citas.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public void memberControlUser() {
		if(query.memberControl(cedulaPac)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "�Atencion!" ,"Usted se encuentra registrado"));
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "�Atencion!" ,"Inicie sesion para agendar una cita"));
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "�Atencion!" ,"Usted no se encuentra registrado"));
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "�Atencion!" ,"Por favor dirijase a contactos"));
		}
	}

	public Integer getCedulaPac() {
		return cedulaPac;
	}

	public void setCedulaPac(Integer cedulaPac) {
		this.cedulaPac = cedulaPac;
	}

	public String getContrase�aPac() {
		return contrase�aPac;
	}

	public void setContrase�aPac(String contrase�aPac) {
		this.contrase�aPac = contrase�aPac;
	}
	
	public Integer getCedulaSec() {
		return cedulaSec;
	}

	public void setCedulaSec(Integer cedulaSec) {
		this.cedulaSec = cedulaSec;
	}

	public String getContrase�aSec() {
		return contrase�aSec;
	}

	public void setContrase�aSec(String contrase�aSec) {
		this.contrase�aSec = contrase�aSec;
	}

	public Integer getCedulaMed() {
		return cedulaMed;
	}

	public void setCedulaMed(Integer cedulaMed) {
		this.cedulaMed = cedulaMed;
	}

	public String getContrase�aMed() {
		return contrase�aMed;
	}

	public void setContrase�aMed(String contrase�aMed) {
		this.contrase�aMed = contrase�aMed;
	}

}
