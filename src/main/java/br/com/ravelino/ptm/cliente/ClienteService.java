/**
 * 
 */
package br.com.ravelino.ptm.cliente;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.ravelino.ptm.exceptions.PTMException;

/**
 * @author ravelino
 *
 */
@Service
public class ClienteService implements IClienteService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Page<Cliente> list(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		Cliente clienteSaved = null;
		
		try {
			setClienteInApoliceCliente(cliente);
			
			clienteSaved = repository.save(cliente);
		} catch (Exception e) {
			log.error("Erro ao salvar cliente");
			throw new PTMException("Erro ao salvar cliente");
		}
		
		return clienteSaved;
	}
	
	private void setClienteInApoliceCliente(Cliente cliente) {
		if (!CollectionUtils.isEmpty(cliente.getApolicesCliente()))
			cliente.getApolicesCliente().forEach(ac -> ac.setCliente(cliente));
	}
}
