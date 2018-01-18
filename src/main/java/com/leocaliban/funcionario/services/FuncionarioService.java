package com.leocaliban.funcionario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.funcionario.domain.Funcionario;
import com.leocaliban.funcionario.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario find(Long id) {
		Funcionario funcionario = repository.findOne(id);
		return funcionario;
	}
	
}
