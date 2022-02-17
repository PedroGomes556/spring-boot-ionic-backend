package com.pedrogomes.cursmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrogomes.cursmc.domain.Categoria;
import com.pedrogomes.cursmc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informártica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//Salvando os objetos no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
