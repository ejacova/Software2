package query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Medico;
import model.Paciente;
import model.Secretaria;

public class DataQuery {

	EntityManagerFactory emf;
	EntityManager em;

	public DataQuery() {
		emf = Persistence.createEntityManagerFactory("ScheduleApp");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public boolean loginPacienteControl(Integer cedulaPac, String contraseņaPac) {
		try {
			Paciente p = em.createNamedQuery("Paciente.control", Paciente.class).setParameter("cedulaPac", cedulaPac).setParameter("contraseņaPac", contraseņaPac).getSingleResult();
			if (p != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginSecretariaControl(Integer cedulaSec, String contraseņaSec) {
		try {
			Secretaria s = em.createNamedQuery("Secretaria.control", Secretaria.class).setParameter("cedulaSec", cedulaSec).setParameter("contraseņaSec", contraseņaSec).getSingleResult();
			if (s != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginMedicoControl(Integer cedulaMed, String contraseņaMed) {
		try {
			Medico m = em.createNamedQuery("Medico.control", Medico.class).setParameter("cedulaMed", cedulaMed).setParameter("contraseņaMed", contraseņaMed).getSingleResult();
			if (m != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean memberControl(Integer cedulaPac) {
		try {
			Paciente p = em.createNamedQuery("Paciente.findCed", Paciente.class).setParameter("cedulaPac", cedulaPac).getSingleResult();
			if (p != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
