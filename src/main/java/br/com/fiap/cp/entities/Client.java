package br.com.fiap.cp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@Data
@Builder
@SequenceGenerator(name="client", sequenceName = "SQ_TB_CLIENT", allocationSize = 1)
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "client")
	@Column(unique = true, name = "nr_client_id")
	private Integer id;
	
	@Column(name = "nm_client_name", nullable = false, length = 35)
	private String name;
	
	@Column(name = "nm_client_email", nullable = false, length = 20, unique = true)
	private String email;
	
	@Column(name = "ps_client_password", nullable = false, length = 16)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	private List<Order> orders;

	public Client(Integer id, String name, String email, String password, Address address, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.orders = orders;
	}
	
}
