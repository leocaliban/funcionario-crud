package com.leocaliban.funcionario.resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String find() {
		return "Rest OK!";
	}
}
