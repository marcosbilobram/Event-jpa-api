package br.com.fiap.cp.entities;

import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_address")
@SequenceGenerator(name="ads", sequenceName = "SQ_TB_ADDRESS", allocationSize = 1)
public class Organizer {

    private Long id;
    private String nome;

    @OneToOne(mappedBy = "organizer")
    private Event event;

    public Organizer(String nome) {
        this.nome = nome;
    }
}
