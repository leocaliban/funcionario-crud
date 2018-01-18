package com.leocaliban.funcionario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.leocaliban.funcionario.domain.Funcionario;
import com.leocaliban.funcionario.repositories.FuncionarioRepository;
import com.leocaliban.funcionario.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario buscar(Long id) {
		Funcionario funcionario = repository.findOne(id);
		if(funcionario == null) {
			throw new ObjetoNaoEncontradoException("Funcionario Não Encontrado! Id: "+id+
													" , Tipo: "+Funcionario.class.getName());
		}
		return funcionario;
	}
	
	public List<Funcionario> listarTodos(){
	 	return repository.findAll();
	}	
	public Funcionario salvar(Funcionario funcionario) {
		funcionario.setId(null);
		return repository.save(funcionario);
	}
	
	public Funcionario editar(Funcionario funcionario) {
		 	buscar(funcionario.getId());
		 	return repository.save(funcionario);
	}
	
	public void excluir(Long id) {
		 	buscar(id);
		 	repository.delete(id);
	}
	
	public Page<Funcionario> buscarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		 	PageRequest pageRequest = new PageRequest(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		 	return repository.findAll(pageRequest);
	}
	
}
