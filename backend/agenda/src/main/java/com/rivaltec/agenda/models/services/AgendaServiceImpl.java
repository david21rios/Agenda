package com.rivaltec.agenda.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rivaltec.agenda.models.dao.IAgendaDAO;
import com.rivaltec.agenda.models.entity.Agenda;
import jakarta.persistence.EntityNotFoundException;

@Service
public  class AgendaServiceImpl implements IAgendaService{

	@Autowired
	private IAgendaDAO agendaDAO;

	@Override
	public List<Agenda> findAll() {
		// TODO Auto-generated method stub
		return (List<Agenda>)agendaDAO.findAll();
	}

	@Override
	public Agenda findById(int id) {
		// TODO Auto-generated method stub
		Agenda existingAgenda = agendaDAO.findById(id)
			.orElseThrow(()-> new EntityNotFoundException("Id no encontrado"));
		return agendaDAO.findById(id).orElse(null);
	}

	@Override
	public Agenda save(Agenda agenda) {
		// TODO Auto-generated method stub
		return agendaDAO.save(agenda);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		agendaDAO.deleteById(id);
	}

	@Override
	public Agenda update(Agenda agenda) {
		// Verifica si el parqueo existe en la base de datos
	    Agenda existingAgenda = agendaDAO.findById(agenda.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Agenda no encontrado"));

	    // Actualiza los campos del parqueo existente con los valores del parqueo proporcionado
	    existingAgenda.setDescription(agenda.getDescription());
	    existingAgenda.setTitle(agenda.getTitle());
	    existingAgenda.setFechaInicio(agenda.getFechaInicio());
	    existingAgenda.setFechaFin(agenda.getFechaFin());
	    existingAgenda.setRecordatorioActivo(agenda.isRecordatorioActivo());
	    // Añade aquí cualquier otro campo que necesites actualizar

	    // Guarda el parqueo actualizado en la base de datos
	    return agendaDAO.save(existingAgenda);
	}

	@Override
	public Agenda findByTitle(String title) {
		// TODO Auto-generated method stub
		Agenda existingAgenda = agendaDAO.findByTitle(title);
		if (existingAgenda == null) {
			throw new EntityNotFoundException("Agenda no se encuentra");
		}
		return agendaDAO.findByTitle(title);
	}
}
