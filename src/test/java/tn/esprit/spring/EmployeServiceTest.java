package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
 class EmployeServiceTest {

	@Autowired
	IEmployeService ems;

	private static final Logger l = Logger.getLogger(EmployeServiceTest.class); 
	
	@Test
	void ajouterEmploye() {
		Employe e = new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
		e = ems.ajouterEmploye(e);
		assertNotNull(e);
	}
	
	@Test
	void testGetAllEmployes() {
		List<Employe> le=ems.getAllEmployes();
		le.forEach(e->l.info(e+"\n"));
		assertNotNull(le);
	}
	
	@Test
	void testGetEmployeById(){
		Employe e=ems.getEmployeById(1);
		l.info(e);
		assertNotNull(ems.getEmployeById(1));
	}
	
	@Test 
	void testDeleteEmployeById(){
		ems.deleteEmployeById(20);
		//assertNull(ems.getEmployeById(20));
	}

}
