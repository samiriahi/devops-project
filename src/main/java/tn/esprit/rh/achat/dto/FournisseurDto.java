package tn.esprit.rh.achat.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;

@Data
public class FournisseurDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @JsonIgnore
	private Long idFournisseur ;
	private String code ;
	private String libelle ;
	private CategorieFournisseur  categorieFournisseur ;
	
	 @JsonIgnore
	private Set<Facture> factures;
	 @JsonIgnore
	private Set<SecteurActivite> secteurActivites ;
	 @JsonIgnore
	private DetailFournisseur detailFournisseur ; 

}
