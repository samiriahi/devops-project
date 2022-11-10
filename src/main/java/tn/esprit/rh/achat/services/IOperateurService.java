package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;


public interface IOperateurService {
	Operateur retrieveOperateur(Long id);
	List<Operateur> retrieveAllOperateurs();
	Operateur addOperateur(Operateur o);
	void deleteOperateur(Long id);
	Operateur updateOperateur(long id ,Operateur operateur)  ;
	

}
