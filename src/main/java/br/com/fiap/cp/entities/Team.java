package br.com.fiap.cp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_team")
@SequenceGenerator(name="team", sequenceName = "SQ_TB_TEAM", allocationSize = 1)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team")
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "team")
    private List<Participant> participantes;

    @ManyToMany(mappedBy = "equipes", fetch = FetchType.LAZY)
    private List<Event> events;

}
