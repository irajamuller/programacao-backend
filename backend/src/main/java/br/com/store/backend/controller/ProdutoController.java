package br.com.store.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.model.Produto;
import jakarta.persistence.EntityManager;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private EntityManager em;
	
	@GetMapping
	public List<Produto> getAll() {
		
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}
