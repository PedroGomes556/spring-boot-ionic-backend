package com.pedrogomes.cursmc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pedrogomes.cursmc.domain.Categoria;
import com.pedrogomes.cursmc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{ 
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj " +
	        "INNER JOIN obj.categorias cat WHERE LOWER(obj.nome) " +
	        "LIKE LOWER(CONCAT('%',:nome,'%')) AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingIgnoreCaseAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

}
