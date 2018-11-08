/**
 * 
 */
package br.com.ravelino.ptm.cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

/**
 * @author ravelino
 *
 */
public class ClienteForm {
	
	private Long idCliente;

	@CPF(message="CPF invalido")
	@NotNull(message="cpfCliente nao pode ser nulo")
	private String cpfCliente;

	@NotEmpty(message="nome Cliente nao pode ser vazio")
	@Size(message="Tamanho cpf deve ser 11", min=1, max=100)
	private String nomeCliente;

	@Size(min=1, message="voce deve selecionar um codigo de apolice")
	private String [] codsCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String[] getCodsCliente() {
		return codsCliente;
	}

	public void setCodsCliente(String[] codsCliente) {
		this.codsCliente = codsCliente;
	}
}
