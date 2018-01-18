package com.leocaliban.funcionario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.funcionario.domain.Funcionario;
import com.leocaliban.funcionario.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario buscar(Long id) {
		Funcionario funcionario = repository.findOne(id);
		return funcionario;
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		funcionario.setId(null);
		return repository.save(funcionario);
	}
	
}
