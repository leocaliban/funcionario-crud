package com.leocaliban.funcionario.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leocaliban.funcionario.domain.Funcionario;
import com.leocaliban.funcionario.dto.FuncionarioDTO;
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
	
	@RequestMapping(method=RequestMethod.GET)
	 public ResponseEntity<List<Funcionario>> listarTodos() {
	 	List<Funcionario> categorias = service.listarTodos();
	 	return ResponseEntity.ok().body(categorias);
	 }
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
		Funcionario funcionario = service.fromDTO(funcionarioDTO);
		funcionario = service.salvar(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	 public ResponseEntity<Void> editar(@Valid @RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id){
		Funcionario funcionario = service.fromDTO(funcionarioDTO);
		funcionario.setId(id);
		funcionario = service.editar(funcionario);
	 	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Void> excluir(@PathVariable Long id) {
	 	service.excluir(id);
	 	return ResponseEntity.noContent().build();
	 }
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<FuncionarioDTO>> buscarPagina(
				@RequestParam(value="page", defaultValue="0") Integer pagina,
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linhasPorPagina ,
				@RequestParam(value="orderBy", defaultValue="nome")String ordenarPor ,
				@RequestParam(value="direction", defaultValue="ASC") String direcao){
		
		Page<Funcionario> funcionarios = service.buscarPagina(pagina, linhasPorPagina, ordenarPor, direcao);
		Page<FuncionarioDTO> funcionariosDTO = funcionarios.map(obj -> new FuncionarioDTO(obj));
		return ResponseEntity.ok().body(funcionariosDTO);
	}
}
