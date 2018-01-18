package com.leocaliban.funcionario.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Funcionario salvar(Funcionario funcionario) {
		funcionario.setId(null);
		return repository.save(funcionario);
	}
	
}
