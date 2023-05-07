package br.com.fiap.cp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_event")
@SequenceGenerator(name="event", sequenceName = "SQ_TB_EVENT", allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event")
    private Long id;

    @Column(name = "Event_name", nullable = false)
    private String nome;

    @Column(name = "event_place", nullable = false)
    private String local;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_data", nullable = false)
    private Date data;

    @OneToOne(mappedBy = "event", optional = false, cascade = CascadeType.ALL)
    private Organizer organizer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_event_teams",
            joinColumns = @JoinColumn(
                    name = "event_id",
                    referencedColumnName = "id"
            ),

            inverseJoinColumns = @JoinColumn(
                    name = "team_id",
                    referencedColumnName = "id")
    )
    private List<Team> equipes;

    public Event(String nome, String local, Date data) {
        this.nome = nome;
        this.local = local;
        this.data = data;
    }
}
