package tn.esprit.rh.achat.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OperateurDto {
	
	@JsonIgnore
	private Long idOperateur;
	private String nom;
	private String prenom ;
	private String password;

}
