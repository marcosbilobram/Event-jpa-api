package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Organizer;
import br.com.fiap.cp.entities.Participant;
import jakarta.persistence.EntityManager;

public class OrganizerDaoImpl extends GenericDaoImpl<Organizer, Long> implements OrganizerDao {

    public OrganizerDaoImpl(EntityManager em) {
        super(em);
    }
}
