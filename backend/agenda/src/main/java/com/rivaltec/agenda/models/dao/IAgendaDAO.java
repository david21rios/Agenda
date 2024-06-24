package com.rivaltec.agenda.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.rivaltec.agenda.models.entity.Agenda;

public interface IAgendaDAO extends CrudRepository<Agenda,Integer>{
	public Agenda findByTitle (String title);
	//public optional<Agenda> findById (Integer id);
}
