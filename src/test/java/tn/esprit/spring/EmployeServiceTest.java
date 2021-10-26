package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
 class EmployeServiceTest {

	@Autowired
	IEmployeService ems;
	@Autowired
	DepartementRepository depts;
	@Autowired
	ContratRepository conts;
	
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
		ems.getEmployeById(17);
		assertNotNull(ems.getEmployeById(17));
	}
	
	@Test 
	void testDeleteEmployeById(){
		ems.deleteEmployeById(25);
	}
	
	@Test
	void testupdateemailEmploye(){
		ems.getEmployeById(25);
		assertNotNull(ems.getEmployeById(25));
		ems.mettreAjourEmailByEmployeId("nourhene.oueslati@esprit.tn", 25);
	}

	@Test
	void testaffecterEmployeADepartement() {
		ems.getEmployeById(18);
		depts.findById(1);
		ems.affecterEmployeADepartement(18, 1);
	}
	
	@Test
	void testdesaffecterEmployeADepartement() {
		ems.getEmployeById(17);
		depts.findById(2);
		ems.desaffecterEmployeDuDepartement(17, 2);
	}
	
	@Test
	void testGetEmployeprenomById(){
		Employe e=ems.getEmployeById(17);
	//	System.out.print(e.getPrenom());
		assertNotNull(e.getPrenom());
	}
	
}
