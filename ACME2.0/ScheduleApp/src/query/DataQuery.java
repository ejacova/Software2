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

	public boolean loginPacienteControl(Integer cedulaPac, String contraseñaPac) {
		try {
			Paciente p = em.createNamedQuery("Paciente.control", Paciente.class).setParameter("cedulaPac", cedulaPac).setParameter("contraseñaPac", contraseñaPac).getSingleResult();
			if (p != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginSecretariaControl(Integer cedulaSec, String contraseñaSec) {
		try {
			Secretaria s = em.createNamedQuery("Secretaria.control", Secretaria.class).setParameter("cedulaSec", cedulaSec).setParameter("contraseñaSec", contraseñaSec).getSingleResult();
			if (s != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginMedicoControl(Integer cedulaMed, String contraseñaMed) {
		try {
			Medico m = em.createNamedQuery("Medico.control", Medico.class).setParameter("cedulaMed", cedulaMed).setParameter("contraseñaMed", contraseñaMed).getSingleResult();
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
