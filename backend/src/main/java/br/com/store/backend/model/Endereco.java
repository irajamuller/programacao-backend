package br.com.store.backend.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(length = 50, nullable = false)
	private String logradouro;
	@Column(length = 10, nullable = false)
	private String numero;
	@Column(length = 50)
	private String complemento;
	@Column(length = 10, nullable = false)
	private String cep; 
	@ManyToOne(optional = false) 
	@JoinColumn(name = "municipio", foreignKey = @ForeignKey(name = "fk_endereco_municipio"))
	private Municipio municipio;
}
