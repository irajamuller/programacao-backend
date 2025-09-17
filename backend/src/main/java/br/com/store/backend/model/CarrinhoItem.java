package br.com.store.backend.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(indexes = {
		@Index(name = "fk_carrinhoItem_carrinho", columnList = "carrinho" )
})
public class CarrinhoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(nullable = false)
	private Integer qtde;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal precoUnitario;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal vlrCupom;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal vlrBruto;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal vlrLiquido;
	@ManyToOne(optional = false)
	@JoinColumn(name = "carrinho", foreignKey = @ForeignKey(name = "fk_carrinhoItem_carrinho"))
	private Carrinho carrinho;
	@ManyToOne(optional = false)
	@JoinColumn(name = "produto", foreignKey = @ForeignKey(name = "fk_carrinhoItem_produto"))
	private Produto produto;
}
