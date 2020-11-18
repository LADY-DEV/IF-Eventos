package br.com.silva.duarte.ifevento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.silva.duarte.ifevento.models.Participante;
import br.com.silva.duarte.ifevento.repository.ParticipanteRepository;

@Controller
public class ParticipanteController {
	 @Autowired
	    private ParticipanteRepository _participanteRepository;

	    @RequestMapping(value = "/participante", method = RequestMethod.GET)
	    public List<Participante> Get() {
	        return _participanteRepository.findAll();
	    }

	    @RequestMapping(value = "/participante/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Participante> GetById(@PathVariable(value = "id") long id)
	    {
	        Optional<Participante> participante = _participanteRepository.findById(id);
	        if(participante.isPresent())
	            return new ResponseEntity<Participante>(participante.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/participante", method =  RequestMethod.POST)
	    public Participante Post(@Validated @RequestBody Participante participante)
	    {
	        return _participanteRepository.save(participante);
	    }

	    @RequestMapping(value = "/participante/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Participante> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Participante newPessoa)
	    {
	        Optional<Participante> oldParticipante = _participanteRepository.findById(id);
	        if(oldParticipante.isPresent()){
	        	Participante participante = oldParticipante.get();
	            participante.setNome(newPessoa.getNome());
	            _participanteRepository.save(participante);
	            return new ResponseEntity<Participante>(participante, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/participante/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Participante> participante = _participanteRepository.findById(id);
	        if(participante.isPresent()){
	            _participanteRepository.delete(participante.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	
}
