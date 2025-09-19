package br.com.store.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.store.backend.model.UnidadeFederativa;
import br.com.store.backend.repository.UnidadeFederativaRepository;

@Service
public class UnidadeFederativaService {
	
	@Autowired
	private UnidadeFederativaRepository unidadeFederativaRepository;
	
	public List<UnidadeFederativa> getAll(String sigla) {
		if (sigla != null)
			return unidadeFederativaRepository.findBySigla(sigla);
		return unidadeFederativaRepository.findAll(Sort.by("nome"));
	}
	
	public UnidadeFederativa getOne(UUID id) {
		return unidadeFederativaRepository.findById(id).orElse(null);
	}
	
	public void save(UnidadeFederativa unidadeFederativa) {
		unidadeFederativaRepository.save(unidadeFederativa);
	}
	
	public void delete(UUID id) {
		unidadeFederativaRepository.deleteById(id);
	}
	
}
