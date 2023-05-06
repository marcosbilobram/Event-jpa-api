package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Event;
import jakarta.persistence.EntityManager;

public class EventDaoImpl extends GenericDaoImpl<Event, Long> implements EventDao {

    public EventDaoImpl(EntityManager em) {
        super(em);
    }
}
