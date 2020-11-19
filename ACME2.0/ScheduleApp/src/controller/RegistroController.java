package controller;

import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mailsender.MailSender;
import model.Cita;
import model.Horario;
import model.Medico;
import model.Paciente;

public class RegistroController {

	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Paciente> pacientes;
	private Paciente paciente;
	private List<Cita> citas;
	private Cita cita;
	private List<Medico> medicos;
	private Medico medico;
	private List<Horario> horarios;
	private Horario horario;
	private String fromMail = "secrectacco01@gmail.com";
	private String username = "secrectacco01@gmail.com";
	private String password = "secrect0079";
	private String toMail;
	private String subject = "Registro nuevo usuario - ScheduleApp";
	private String message;

	public RegistroController() {
		this.emf = Persistence.createEntityManagerFactory("ScheduleApp");
		this.em = this.emf.createEntityManager();
		this.pacientes = consultarPacientes();
		this.paciente = new Paciente();
		this.citas = consultarCitas();
		this.cita = new Cita();
		this.medicos = consultarMedicos();
		this.medico = new Medico();
		this.horarios = consultarHorarios();
		this.horario = new Horario();
	}

	private List<Paciente> consultarPacientes() {
		String jpql = "SELECT pac FROM Paciente pac ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Paciente> pacientes = query.getResultList();
		return pacientes;
	}

	private List<Cita> consultarCitas() {
		String jpql = "SELECT cit FROM Cita cit ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Cita> citas = query.getResultList();
		return citas;
	}

	private List<Medico> consultarMedicos() {
		String jpql = "SELECT med FROM Medico med ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Medico> medicos = query.getResultList();
		return medicos;
	}

	private List<Horario> consultarHorarios() {
		String jpql = "SELECT hor FROM Horario hor ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Horario> horarios = query.getResultList();
		return horarios;
	}


	public void nuevaCita() {

		char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder(8);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		paciente.setContraseñaPac(sb.toString());

		try {
			this.em.getTransaction().begin();
			this.em.persist(this.paciente);
			this.em.persist(this.cita);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.paciente = new Paciente();
			this.pacientes = consultarPacientes();
			this.cita = new Cita();
			this.citas = consultarCitas();
			toMail = paciente.getCorreo();
			message = "Bienvenido a ScheduleApp \n" + "\n" + "\n" + "\n" + "Su usuario es: " + paciente.getCedulaPac()
					+ "\n" + "\n" + "\n" + "\n" + "Su contraseña es: " + paciente.getContraseñaPac() + "\n" + "\n"
					+ "\n" + "\n" + "¡Gracias por registrarse en nuestra plataforma!";
			MailSender mailSender = new MailSender();
			mailSender.sendMail(fromMail, username, password, toMail, subject, message);
		} catch (Exception e) {
			System.out.println(e);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!",
				"Se ha enviado un correo con sus credenciales"));
	}
	
	public void nuevoPaciente() {
		
		char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder(8);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		this.paciente.setContraseñaPac(sb.toString());

		try {
			this.em.getTransaction().begin();
			this.em.persist(this.paciente);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.paciente = new Paciente();
			this.pacientes = consultarPacientes();
			toMail = this.paciente.getCorreo();
			message = "Bienvenido a ScheduleApp \n" + "\n" + "\n" + "\n" + "Su usuario es: "
					+ this.paciente.getCedulaPac() + "\n" + "\n" + "\n" + "\n" + "Su contraseña es: "
					+ this.paciente.getContraseñaPac() + "\n" + "\n" + "\n" + "\n"
					+ "¡Gracias por registrarse en nuestra plataforma!";
			MailSender mailSender = new MailSender();
			mailSender.sendMail(fromMail, username, password, toMail, subject, message);
		} catch (Exception e) {
			System.out.println(e);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Se ha agregado un nuevo paciente"));
	}

	public void onCountryChange() {
		if (medico != null && !medico.equals(""))
			horarios = medico.getHorarios();
		else
			System.out.print("None");
	}

	public void reprogramarCita() {
		this.cita = this.citas.get(0);
		if (this.cita != null) {
			try {
				this.em.getTransaction().begin();
				this.em.merge(this.cita);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.cita = new Cita();
				this.citas = consultarCitas();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void eliminarCita() {
		this.cita = this.citas.get(0);
		if (this.cita != null) {
			try {
				this.em.getTransaction().begin();
				this.em.remove(this.cita);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.cita = new Cita();
				this.citas = consultarCitas();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public String getFromMail() {
		return fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}