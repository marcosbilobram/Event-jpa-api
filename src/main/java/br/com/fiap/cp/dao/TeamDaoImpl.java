package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Team;
import jakarta.persistence.EntityManager;

public class TeamDaoImpl extends GenericDaoImpl<Team, Long> implements TeamDao {

    public TeamDaoImpl(EntityManager em) {
        super(em);
    }
}
