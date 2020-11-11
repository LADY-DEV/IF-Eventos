package br.com.silva.duarte.ifevento.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.silva.duarte.ifevento.models.Evento;

@Controller
public class EventoController {


	@RequestMapping(value = "/evento", method = RequestMethod.GET)
	public ModelAndView Evento() {
		return new ModelAndView("evento", "command", new Evento());
	}

	@RequestMapping(value = "/addEvento", method = RequestMethod.POST)
	 public String adicionarEvento(
	  @ModelAttribute("SpringWeb") Evento evento, ModelMap model,
	  HttpServletRequest request) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		model.addAttribute("nome", evento.getNome());
		model.addAttribute("idEvento", evento.getIDEvento());
		model.addAttribute("descricao", evento.getDescricao());
		model.addAttribute("dataInicio", sdf.format(evento
		   .getDataInicio()));
		 model.addAttribute("dataFim", sdf.format(evento
				   .getDataFim()));
		 
		/* List<Evento> eventos = (List<Evento>)
				   request.getSession().getAttribute("eventos");
				   if (eventos == null) {
				      eventos = new ArrayList<Evento>();
				   }
				   eventos.add(evento);
				   request.getSession().setAttribute("eventos", eventos);*/

				  // return "exibeEventos";
		       		return " ";
				}
                   /*
				    @RequestMapping(value = "/listaEventos", method = RequestMethod.GET)
				    public String listarEventos(
				  @ModelAttribute("SpringWeb") ModelMap model, HttpServletRequest request) {

				    List<Evento> eventos = (List<Evento>)
				    request.getAttribute("eventos");

				    model.addAttribute("evento", eventos);


				    return "listaEventos";
				   }  */

		 
}
	
