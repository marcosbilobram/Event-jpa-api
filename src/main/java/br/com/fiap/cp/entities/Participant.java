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

    @Column(name = "participant_name", length = 30, nullable = false)
    private String nome;

    @Column(name = "participant_email", nullable = false, unique = true)
    private String email;

    @Column(name = "participant_tel", length = 12)
    private String telefone;

    @OneToOne(mappedBy = "participantes")
    private Team team;

    public Participant(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
