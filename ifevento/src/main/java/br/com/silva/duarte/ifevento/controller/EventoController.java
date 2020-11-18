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


import br.com.silva.duarte.ifevento.models.Evento;
import br.com.silva.duarte.ifevento.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
    private EventoRepository _EventoRepository;

    @RequestMapping(value = "/evento", method = RequestMethod.GET)
    public List<Evento> Get() {
        return _EventoRepository.findAll();
    }

    @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET)
    public ResponseEntity<Evento> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Evento> evento = _EventoRepository.findById(id);
        if(evento.isPresent())
            return new ResponseEntity<Evento>(evento.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/evento", method =  RequestMethod.POST)
    public Evento Post(@Validated @RequestBody Evento evento)
    {
        return _EventoRepository.save(evento);
    }

    @RequestMapping(value = "/evento/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Evento> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Evento newEvento)
    {
        Optional<Evento> oldEvento = _EventoRepository.findById(id);
        if(oldEvento.isPresent()){
            Evento evento = oldEvento.get();
            evento.setNome(newEvento.getNome());
            _EventoRepository.save(evento);
            return new ResponseEntity<Evento>(evento, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Evento> evento = _EventoRepository.findById(id);
        if(evento.isPresent()){
            _EventoRepository.delete(evento.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	

	
		 
}
	
