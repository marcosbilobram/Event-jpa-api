package br.com.fiap.cp.view;

import java.util.Calendar;
import java.util.Collections;
import java.util.NoSuchElementException;

import br.com.fiap.cp.dao.*;
import br.com.fiap.cp.entities.Event;
import br.com.fiap.cp.entities.Organizer;
import br.com.fiap.cp.entities.Participant;
import br.com.fiap.cp.entities.Team;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ApiCRUDTest {
	
public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		TeamDao teamDao = new TeamDaoImpl(em);
		ParticipantDao participantDao = new ParticipantDaoImpl(em);
		EventDao eventDao = new EventDaoImpl(em);
		OrganizerDao organizerDao = new OrganizerDaoImpl(em);

		Team team = new Team(1L, "OSCABA", "SOMOS OS CABA", null, null);

		Participant part = new Participant("Junim", "junio@hotmai.com", "99999999");

		Organizer organizer = new Organizer("Tozé");

		Event event = new Event("Festa da uva", "É longe viu", Calendar.getInstance().getTime());

		team.setParticipantes(Collections.singletonList(part));
		part.setTeam(team);
		event.setEquipes(Collections.singletonList(team));
		event.setOrganizer(organizer);
		organizer.setEvent(event);
		
		try {
			teamDao.save(team);
			teamDao.commit();

			participantDao.save(part);
			participantDao.commit();

			organizerDao.save(organizer);
			organizerDao.commit();

			eventDao.save(event);
			eventDao.commit();

			System.out.println("Entidades cadastradas");
		}
		catch(CommitErrorException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Team teamSearch = teamDao.findById(1L);
			System.out.println(teamSearch.getNome());
		
			teamSearch.setNome("VAIXCO DA GAMA");
			teamDao.save(teamSearch);
			teamDao.commit();
			System.out.println("Time atualizado!");
			/*--------------------------------------*/
			Participant partSearch = participantDao.findById(1L);
			System.out.println(partSearch.getNome());

			partSearch.setNome("CASUMIRU");
			participantDao.save(partSearch);
			participantDao.commit();
			System.out.println("Participante atualizado!");
			/*--------------------------------------*/
			Organizer organizerSearch = organizerDao.findById(1L);
			System.out.println(organizerSearch.getNome());

			organizerSearch.setNome("GAULES");
			organizerDao.save(organizerSearch);
			organizerDao.commit();
			System.out.println("Organizador atualizado!");
			/*--------------------------------------*/
			Event eventSearch = eventDao.findById(1L);
			System.out.println(eventSearch.getNome());

			eventSearch.setNome("FESTA DO CAQUI");
			eventDao.save(eventSearch);
			eventDao.commit();
			System.out.println("Evento atualizado!");
			
		} 
		catch (CommitErrorException e) {
			System.out.println(e.getMessage());
		} 
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}
	
}
