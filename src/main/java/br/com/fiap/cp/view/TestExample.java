package br.com.fiap.cp.view;

import br.com.fiap.cp.dao.ClientDao;
import br.com.fiap.cp.dao.ClientDaoImpl;
import br.com.fiap.cp.entities.Client;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import lombok.Builder;

public class TestExample {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClientDao clientDao = new ClientDaoImpl(em);
		
		Client client = new Client(1, "marcos", "marcosbilobram@hotmail.com", "1234567", null, null);

	}

}
