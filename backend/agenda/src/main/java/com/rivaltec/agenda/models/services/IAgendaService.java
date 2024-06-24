package com.rivaltec.agenda.models.services;

import java.util.List;

import com.rivaltec.agenda.models.entity.Agenda;

public interface IAgendaService {
	public List<Agenda> findAll();
	public Agenda findById (int id);
	public Agenda save (Agenda agenda);
	public void delete (int id);
	public Agenda update (Agenda agenda);
	public Agenda findByTitle (String title);
}
