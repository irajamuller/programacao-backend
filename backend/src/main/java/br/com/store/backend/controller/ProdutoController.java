package br.com.store.backend.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@GetMapping
	public List<Produto> getAll() {
		Produto p = Produto.builder()
						.id(UUID.randomUUID())
						.nome("Bola de Futebol")
						.qtde(2)
						.vlrUnitario(BigDecimal.valueOf(150))
						.build();
		return List.of(p);
	}
}
