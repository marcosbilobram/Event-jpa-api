package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Order;
import jakarta.persistence.EntityManager;

public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao{

	public OrderDaoImpl(EntityManager em) {
		super(em);
	}

}
