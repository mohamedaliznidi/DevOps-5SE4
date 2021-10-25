package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceTest {

	@Autowired
	IEmployeService ems;

	@Test
	void ajouterEmploye() {
		Employe e = new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
		e = ems.ajouterEmploye(e);
		assertNotNull(e.getId());
	}

}
