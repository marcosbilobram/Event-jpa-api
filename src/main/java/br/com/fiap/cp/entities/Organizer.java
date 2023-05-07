package br.com.fiap.cp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_organizer")
@SequenceGenerator(name="org", sequenceName = "SQ_TB_ORGANIZER", allocationSize = 1)
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org")
    private Long id;

    @Column(name = "organizer_name", nullable = false, length = 30)
    private String nome;

    @OneToOne(mappedBy = "organizer")
    private Event event;

    public Organizer(String nome) {
        this.nome = nome;
    }
}
