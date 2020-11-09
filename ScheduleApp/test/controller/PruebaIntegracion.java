package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaIntegracion {
	
	@Test
	public void loginControlPaciente() {
		SearchController obj = new SearchController();
		assertNotNull(obj.loginControlPaciente());
	}
	
	@Test
	public void loginControlSecretaria() {
		SearchController obj = new SearchController();
		assertNotNull(obj.loginControlSecretaria());
	}
	
	@Test
	public void loginControlMedico() {
		SearchController obj = new SearchController();
		assertNotNull(obj.loginControlMedico());
	}
	
	@Test
	public void getCedulaPac() {
		SearchController obj = new SearchController();
		obj.setCedulaPac(4555);
		assertTrue(obj.getCedulaPac() == 4555);
	}
	
	@Test
	public void setCedulaPac() {
		SearchController obj = new SearchController();
		obj.setCedulaPac(221);
		assertTrue(obj.getCedulaPac() == 221);
	}

	@Test
	public void getContraseñaPac() {
		SearchController obj = new SearchController();
		obj.setContraseñaPac("4564");
		assertTrue(obj.getContraseñaPac()=="4564");
	}

	@Test
	public void setContraseñaPac() {
		SearchController obj = new SearchController();
		obj.setContraseñaPac("4562");
		assertTrue(obj.getContraseñaPac()=="4562");
	}
	
	@Test
	public void getCedulaSec() {
		SearchController obj = new SearchController();
		obj.setCedulaSec(241);
		assertTrue(obj.getCedulaSec() == 241);
	}

	@Test
	public void setCedulaSec() {
		SearchController obj = new SearchController();
		obj.setCedulaSec(341);
		assertTrue(obj.getCedulaSec() == 341);
	}

	@Test
	public void getContraseñaSec() {
		SearchController obj = new SearchController();
		obj.setContraseñaSec("5562");
		assertTrue(obj.getContraseñaSec()=="5562");
	}

	@Test
	public void setContraseñaSec() {
		SearchController obj = new SearchController();
		obj.setContraseñaSec("5762");
		assertTrue(obj.getContraseñaSec()=="5762");
	}

	@Test
	public void getCedulaMed() {
		SearchController obj = new SearchController();
		obj.setCedulaMed(3441);
		assertTrue(obj.getCedulaMed() == 3441);
	}

	@Test
	public void setCedulaMed() {
		SearchController obj = new SearchController();
		obj.setCedulaMed(3415);
		assertTrue(obj.getCedulaMed() == 3415);
	}

	@Test
	public void getContraseñaMed() {
		SearchController obj = new SearchController();
		obj.setContraseñaMed("5769");
		assertTrue(obj.getContraseñaMed()=="5769");
	}

	@Test
	public void setContraseñaMed() {
		SearchController obj = new SearchController();
		obj.setContraseñaMed("576");
		assertTrue(obj.getContraseñaMed()=="576");
	}
}
