package com.rivaltec.agenda.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rivaltec.agenda.models.entity.Agenda;
import com.rivaltec.agenda.models.services.IAgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaRestController {
	
	@Autowired
	private IAgendaService agendaService;
	//Consulta de todos las agendas
	
	@GetMapping
	public List<Agenda> findAll() {
		return agendaService.findAll();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda create(@RequestBody Agenda agenda) {
        return agendaService.save(agenda);
	}
	
	//Consulta de todos las agendas por ID
	@GetMapping("/agenda/{id}")
	public Agenda show (@PathVariable int id) {
		return agendaService.findById(id);
	}
	
	//Consulta de todos las agendas por titulo
	@GetMapping("/agenda/titulo/{title}")
	public Agenda show(@PathVariable String title) {
		return agendaService.findByTitle(title);
	}
}
