package query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Login;

public class DataQuery {

	EntityManagerFactory emf;
	EntityManager em;
	
	public DataQuery() {
		emf = Persistence.createEntityManagerFactory("ScheduleApp");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public boolean loginControl(String nombreUsuario, String contraseña) {
		try {
			Login l = em.createNamedQuery("Login.control", Login.class).setParameter("nombreUsuario", nombreUsuario).setParameter("contraseña", contraseña).getSingleResult();
			if(l != null){
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
