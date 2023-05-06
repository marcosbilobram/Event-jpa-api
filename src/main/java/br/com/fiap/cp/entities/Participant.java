package br.com.fiap.cp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_participant")
@SequenceGenerator(name="prtc", sequenceName = "SQ_TB_PARTICIPAN", allocationSize = 1)
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prtc")
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @OneToOne(mappedBy = "participantes")
    private Team team;

    public Participant(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
