/**
 * 
 */
package br.com.ravelino.ptm.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author ravelino
 *
 */
public interface IClienteService {
	
	public Page<Cliente> list(Pageable pageable);
	
	public Cliente save(Cliente cliente);

}
