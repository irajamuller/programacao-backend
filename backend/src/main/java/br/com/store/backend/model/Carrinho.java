package br.com.store.backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(nullable = false)
	private LocalDateTime dtEmissao;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal vlrTotal;
	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_carrinho_cliente"))
	private Cliente cliente;
	@OneToMany(mappedBy = "carrinho")
	private List<CarrinhoItem> carrinhoItens;
	@OneToMany(mappedBy = "carrinho")
	private List<CarrinhoPgto> carrinhoPgtos;
}

