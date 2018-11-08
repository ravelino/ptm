/**
 * 
 */
package br.com.ravelino.ptm.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.com.ravelino.ptm.cliente.Cliente;

/**
 * @author ravelino
 *
 */
@Component
public class Producer {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(Cliente cliente) {
        log.info("Enviando mensagem.");
        jmsTemplate.convertAndSend("cliente", cliente);
    }

}
