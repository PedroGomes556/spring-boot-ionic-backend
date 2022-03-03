package com.pedrogomes.cursmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedrogomes.cursmc.domain.Categoria;
import com.pedrogomes.cursmc.repositories.CategoriaRepository;
import com.pedrogomes.cursmc.services.exceptions.DataIntegrityException2;
import com.pedrogomes.cursmc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + 
		Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		//Verificando se o id existe
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id); 
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException2("Não é possível excluir uma categoria que possua produtos");
		}
	
	}
	
}

