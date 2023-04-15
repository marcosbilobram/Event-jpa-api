package br.com.fiap.cp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_address")
@SequenceGenerator(name="ads", sequenceName = "SQ_TB_ADDRESS", allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ads")
    @Column(name = "nr_address_id")
    private Long id;

    @Column(name = "ds_address_type",length = 20)
    private String addressType;

    @Column(name = "nm_address_street", length = 25, nullable = false)
    private String street;

    @Column(name = "nr_address_number", length = 6, nullable = false)
    private int number;

    @Column(name = "ds_address_complement", length = 25)
    private String complement;

    @Column(name = "nm_address_neighborhood", length = 30)
    private String neighborhood;

    @Column(name = "nm_address_city", length = 20, nullable = false)
    private String city;
    
    @OneToOne
    private Client client;
}
