package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Participant;
import jakarta.persistence.EntityManager;

public class ParticipantDaoImpl extends GenericDaoImpl<Participant, Long> implements ParticipantDao {

    public ParticipantDaoImpl(EntityManager em) {
        super(em);
    }
}
