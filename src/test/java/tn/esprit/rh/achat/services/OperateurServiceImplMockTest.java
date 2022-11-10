package tn.esprit.rh.achat.services;



import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;




@ExtendWith(MockitoExtension.class)
 class OperateurServiceImplMockTest {



@Mock
OperateurRepository operateurRepository ;


@InjectMocks
OperateurServiceImpl operateurService ;




@Test
void testRetrieveOperateur() {
when(operateurRepository.findAll()).thenReturn(Stream.of(new Operateur((long) 3 ,"sami3", "riahi3","password3"),
														 new Operateur((long) 1 ,"sami1", "riahi1","password1"),
														 new Operateur( (long) 2 ,"sami2", "riahi2","password2"))
			.collect(Collectors.toList()));
			assertEquals(3,operateurService.retrieveAllOperateurs().size());

}

@Test
void testAddOperateur() {
	Operateur operateur = new Operateur( (long) 20 ,"sami", "riahi" ,"letmein");
	when(operateurRepository.save(operateur)).thenReturn(operateur);
	assertEquals(operateur, operateurService.addOperateur(operateur));
}


@Test
void testDeleteOperateur() {
@SuppressWarnings("unused")
Operateur operateur = new Operateur((long)11 ,"sami", "riahi","password");
operateurService.deleteOperateur((long) 11);
verify(operateurRepository).deleteById((long) 11);


}

@Test
void testUpdateOperateur() {
Operateur operateur = new Operateur((long) 3 ,"sami3", "riahi3","password3");
Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(operateur);
operateur.setNom("newNom");
Operateur exisitingOp= operateurService.updateOperateur((long) 3, operateur) ;

assertNotNull(exisitingOp);
assertEquals("newNom", operateur.getNom());
}






}