/**
 * 
 */
package br.com.ravelino.ptm.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.ravelino.ptm.cliente.Cliente;
import br.com.ravelino.ptm.cliente.IClienteService;

/**
 * @author ravelino
 *
 */
@Component
public class Reciver {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IClienteService clienteService;
	
	@JmsListener(destination = "cliente", containerFactory = "myFactory")
    public void receiveMessage(Cliente cliente) {
		log.info("Mensagem Recebida <" + cliente + ">");
        saveCliente(cliente);
    }
	
	private void saveCliente(Cliente cliente) {
		try {
			clienteService.save(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
