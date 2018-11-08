package br.com.ravelino.ptm.apolice.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ravelino.ptm.cliente.Cliente;


@Entity
@Table(name="APOLICE_CLIENTE")
public class ApoliceCliente implements Serializable {
	
	
	private static final long serialVersionUID = 1526713527950577855L;

	public ApoliceCliente() {}
	
	public ApoliceCliente(String codProduto) {
		this.codProduto = codProduto;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_APOLICE")
	private Long idApolice;

	@Column(name="COD_PRODUTO")
	private String codProduto;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLIENTE")
	@JsonIgnore
	private Cliente cliente;

	public Long getIdApolice() {
		return idApolice;
	}

	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}

	public String getCodProduto() {
		return this.codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}