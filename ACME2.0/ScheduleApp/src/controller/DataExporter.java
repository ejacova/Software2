package controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import model.Paciente;

public class DataExporter implements Serializable {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Paciente> pacientes;
	private Paciente paciente;
	private Exporter<DataTable> textExporter;
	
	public DataExporter() {
		this.emf = Persistence.createEntityManagerFactory("ScheduleApp");
		this.em = this.emf.createEntityManager();
		this.pacientes = consultarPacientes();
		this.paciente = new Paciente();
		
	}
	
	private List<Paciente> consultarPacientes() {
		String jpql = "SELECT pac FROM Paciente pac ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Paciente> pacientes = query.getResultList();
		return pacientes;
	}
	
	@PostConstruct
	public void init() {
		textExporter = new TextExporter();
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public Exporter<DataTable> getTextExporter() {
		return textExporter;
	}
	public void setTextExporter(Exporter<DataTable> textExporter) {
		this.textExporter = textExporter;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
