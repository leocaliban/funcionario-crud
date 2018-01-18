package com.leocaliban.funcionario.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.leocaliban.funcionario.domain.Funcionario;

public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message="Nome do Funcionário é obrigatório.")
	@Length(min=10, max=60, message="O nome deve conter entre 10 e 60 caracteres.")
	private String nome;
	
	private String cpf;
	
	private Date dataNascimento;

	private Double salario;
	
	@NotEmpty(message="Nome do Cargo é obrigatório.")
	@Length(min=5, max=40, message="O nome deve conter entre 5 e 40 caracteres.")
	private String cargo;

	private boolean ativo;
		
	public FuncionarioDTO() {
		
	}
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.dataNascimento = funcionario.getDataNascimento();
		this.salario = funcionario.getSalario();
		this.cargo = funcionario.getCargo();
		this.ativo = funcionario.isAtivo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
		
}
