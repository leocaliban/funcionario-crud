package com.leocaliban.funcionario.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leocaliban.funcionario.domain.Funcionario;
import com.leocaliban.funcionario.services.FuncionarioService;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		Funcionario funcionario = service.buscar(id);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Funcionario funcionario){
		funcionario = service.salvar(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	 public ResponseEntity<Void> editar(@RequestBody Funcionario funcionario, @PathVariable Long id){
		funcionario.setId(id);
		funcionario = service.editar(funcionario);
	 	return ResponseEntity.noContent().build();
	}
		
}
