package com.pedrogomes.cursmc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pedrogomes.cursmc.domain.Cliente;
import com.pedrogomes.cursmc.domain.enums.TipoCliente;
import com.pedrogomes.cursmc.dto.ClienteNewDTO;
import com.pedrogomes.cursmc.repositories.ClienteRepository;
import com.pedrogomes.cursmc.resource.exceptions.FieldMessage;
import com.pedrogomes.cursmc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	public ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) 
				&& !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURICA.getCod()) 
				&& !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existente!"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}