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

import br.com.silva.duarte.ifevento.models.Participante;

@Controller
public class ParticipanteController {

	 @RequestMapping(value = "/participante", method = RequestMethod.GET)
	 public ModelAndView participante() {
	  return new ModelAndView("participante", "command", new Participante());
	 }

	 @RequestMapping(value = "/addParticipante", method = RequestMethod.POST)
	 public String adicionarCliente(
	  @ModelAttribute("SpringWeb") Participante participante, ModelMap model,
	  HttpServletRequest request) {

	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	   model.addAttribute("nome", participante.getNome());
	   model.addAttribute("idParticipante", participante.getIdParticipante());
	   model.addAttribute("email", participante.getEmail());
	   model.addAttribute("dataNascimento", sdf.format(participante
	   .getDataNascimento()));
	   
	   return "";
	}

	    @RequestMapping(value = "/listaParticipante", method = RequestMethod.GET)
	    public String listarPaticipante(
	  @ModelAttribute("SpringWeb") ModelMap model, HttpServletRequest request) {

	    List<Participante> participantes= (List<Participante>)
	    request.getAttribute("participantes");

	    model.addAttribute("participantes", participantes);


	    return "listaParticipantes";
	   }

	
}
