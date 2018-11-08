package br.com.ravelino.ptm.cliente;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ravelino.ptm.apolice.cliente.ApoliceCliente;


@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -5353136165330323680L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CLIENTE")
	private Long idCliente;

	@Column(name="CPF_CLIENTE")
	private String cpfCliente;

	@Column(name="NOME_CLIENTE")
	private String nomeCliente;

	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ApoliceCliente> apolicesCliente;


	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return this.cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public List<ApoliceCliente> getApolicesCliente() {
		return apolicesCliente;
	}

	public void setApolicesCliente(List<ApoliceCliente> apolicesCliente) {
		this.apolicesCliente = apolicesCliente;
	}

	public ApoliceCliente addApoliceCliente(ApoliceCliente apoliceCliente) {
		getApolicesCliente().add(apoliceCliente);
		apoliceCliente.setCliente(this);

		return apoliceCliente;
	}

	public ApoliceCliente removeApoliceCliente(ApoliceCliente apoliceCliente) {
		getApolicesCliente().remove(apoliceCliente);
		apoliceCliente.setCliente(this);

		return apoliceCliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [idCliente=");
		builder.append(idCliente);
		builder.append(", cpfCliente=");
		builder.append(cpfCliente);
		builder.append(", nomeCliente=");
		builder.append(nomeCliente);
		builder.append(", apolicesCliente=");
		builder.append(apolicesCliente);
		builder.append("]");
		return builder.toString();
	}
}