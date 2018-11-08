/**
 * 
 */
package br.com.ravelino.ptm.cliente;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ravelino.ptm.apolice.cliente.ApoliceCliente;

/**
 * @author ravelino
 *
 */
public class ClienteMapper {
	
	public static Cliente mapper(ClienteForm clienteForm) {
		final Cliente cliente = new Cliente();
		cliente.setCpfCliente(clienteForm.getCpfCliente());
		cliente.setNomeCliente(clienteForm.getNomeCliente());
		cliente.setApolicesCliente(getApolices(clienteForm.getCodsCliente()));
		
		return cliente;
		
	}
	
	private static List<ApoliceCliente> getApolices(String [] codApolices) {
		
		if (codApolices.length == 0) return null;
		
		return Arrays
					.asList(codApolices)
					.stream()
					.map(cod -> new ApoliceCliente(cod))
					.collect(Collectors.toList());
				
		
	}

}
