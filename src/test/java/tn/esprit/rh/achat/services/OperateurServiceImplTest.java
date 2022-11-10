package tn.esprit.rh.achat.services;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Operateur;




@RunWith(SpringRunner.class)
@SpringBootTest	
@Slf4j
public class OperateurServiceImplTest {
	
	@Autowired
	IOperateurService operateurService ;
	
	
	@Test
	public void testAddOperateur()throws ParseException{
		Operateur operateur  = new Operateur();
		operateur.setIdOperateur((long) 3);		
		operateur.setNom( " Riahi " ) ;
		operateur.setPrenom( "Sami" );
		operateur.setPassword( "letmein" );
		operateurService.addOperateur(operateur);
		log.info("Operateur added successfully");
	}
	
	@Test
	public void testUpdateOperateur()throws ParseException{
		Operateur operateur  = new Operateur();
		operateur.setIdOperateur((long) 4);		
		operateur.setNom( " Riahi " ) ;
		operateur.setPrenom( "Sami" );
		operateur.setPassword( "letmein" );
		operateurService.addOperateur(operateur);
		log.info("Operateur added successfully");
		operateur.setNom( " riahi44 " ) ;
		operateur.setPrenom( "sami44" );
		operateur.setPassword( "password44" );
		operateurService.updateOperateur(4, operateur);
		log.info("Operateur information updated successfully");		
	}
	
	@Test
	public void testDeleteOperateur () throws ParseException{
		Operateur op = new Operateur() ;
		op.setIdOperateur((long) 4);		
		op.setNom( " Riahi " ) ;
		op.setPrenom( "Sami" );
		op.setPassword( "letmein" );
		operateurService.addOperateur(op);
		operateurService.deleteOperateur(op.getIdOperateur());
		log.info("Operateur deleted  successfully");
		
	}
	
	@Test
	public void testRetrieveAllOperateur() throws ParseException {
		List<Operateur> listOperateur = operateurService.retrieveAllOperateurs();
		Assertions.assertNotEquals(0, listOperateur.size());
		log.info(" nombre Operateur =" +listOperateur.size()+" \n " );
		for (int i=0 ;  i<listOperateur.size(); i++) {
			log.info(" " + listOperateur.get(i).getNom() );
		}
	}
	
	
	
}
