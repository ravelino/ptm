/**
 * 
 */
package br.com.ravelino.ptm.cliente;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ravelino.ptm.jms.Producer;
/**
 * @author ravelino
 *
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Producer jmsProducer;
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(path="/v1/pagination")
    public String list(Pageable pageable, Model model) {
		log.info("=== method list called ===");
		model.addAttribute("page", clienteService.list(pageable));
		model.addAttribute("pageNumber", pageable.getPageNumber()+1);
		model.addAttribute("pageSize", pageable.getPageSize());
		
        return "cliente/list";
    }
	
	@GetMapping(path="/v1/create")
    public String createShow(Model model) {
		
		final ClienteForm clienteForm = new ClienteForm();
		
		model.addAttribute("clienteForm", clienteForm);
		
        return "cliente/create";
    }
	
	@PostMapping(path="/v1/create")
    public String create(@ModelAttribute @Valid ClienteForm clienteForm, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
	        return "cliente/create";
	    }
		
		final Cliente cliente = ClienteMapper.mapper(clienteForm);
		
		jmsProducer.send(cliente);
		
		return "redirect:/cliente/v1/pagination?page=0&size=5";
		//return "";				
    }
}
