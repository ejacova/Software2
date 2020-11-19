package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaUnitaria {

	@Test
	public void loginControlPaciente() {
		SearchController obj = new SearchController();
		assertNotNull(obj.loginControlPaciente());
	}
	
}
