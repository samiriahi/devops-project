package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import tn.esprit.rh.achat.dto.OperateurDto;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;
	@Autowired
	private ModelMapper modelMapper;
	
	// http://localhost:8089/SpringMVC/operateur/retrieve-all-operateurs
	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<OperateurDto> getOperateurs() {
		return operateurService.retrieveAllOperateurs().stream().map(operateur -> modelMapper.map(operateur, OperateurDto.class))
				.collect(Collectors.toList());
	}

	
	// http://localhost:8089/SpringMVC/operateur/retrieve-operateur/8
	@GetMapping("/retrieve-operateur/{operateur-id}")
	public ResponseEntity<OperateurDto> retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		Operateur operateur = operateurService.retrieveOperateur(operateurId);
		OperateurDto operateurResponse = modelMapper.map(operateur, OperateurDto.class);
		return ResponseEntity.ok().body(operateurResponse);
	}

	// http://localhost:8089/SpringMVC/operateur/add-operateur
	@PostMapping("add-operateur")
	public ResponseEntity<OperateurDto> addOperateur(@RequestBody OperateurDto operateurDto) {
		// convert DTO to entity
		Operateur operateurRequest = modelMapper.map(operateurDto, Operateur.class);
		Operateur operateur = operateurService.addOperateur(operateurRequest);
		// convert entity to DTO
		OperateurDto operateurResponse = modelMapper.map(operateur, OperateurDto.class);
		return new ResponseEntity<>(operateurResponse, HttpStatus.CREATED);
	}
	
	
	
	// http://localhost:8089/SpringMVC/operateur/remove-operateur/7
	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}
	



	// http://localhost:8089/SpringMVC/operateur/modify-operateur/id
	@PutMapping("/modify-operateur")
	public ResponseEntity<OperateurDto> modifyOperateur(@PathVariable long id, @RequestBody OperateurDto operateurDto) {

		Operateur operateurRequest = modelMapper.map(operateurDto, Operateur.class);
		Operateur operateur = operateurService.updateOperateur(id, operateurRequest);

		// entity to DTO
		OperateurDto postResponse = modelMapper.map(operateur, OperateurDto.class);

		return ResponseEntity.ok().body(postResponse);
	}
	
}
