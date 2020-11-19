package controller;

import java.util.List;

import javax.persistence.Query;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cita;

public class AgendarController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Cita> citas;
	private Cita cita;
	
	public AgendarController() {
		this.emf = Persistence.createEntityManagerFactory("ScheduleApp");
		this.em = this.emf.createEntityManager();
		this.citas = consultarCitas();
		this.cita = new Cita();
	}
	
	private List<Cita> consultarCitas() {
		String jpql = "SELECT cit FROM Cita cit ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Cita> citas = query.getResultList();
		return citas;
	}
	
	public void nuevaCita() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Se ha agendado una nueva cita"));
		
		try {
			this.em.getTransaction().begin();
			this.em.persist(this.cita);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.cita = new Cita();
			this.citas = consultarCitas();
		} catch (Exception e) {
			System.out.println(e);
		}
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
	
	
}
