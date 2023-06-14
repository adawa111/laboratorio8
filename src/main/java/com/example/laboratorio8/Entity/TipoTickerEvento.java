package com.example.laboratorio8.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_ticket_evento")
public class TipoTickerEvento {

    @Id
    @Column(name = "id_tipo_ticket", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoTicket;

    @Column(name = "precio")
    private String precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @OneToOne
    @JoinColumn(name = "idevento")
    private Evento idevento;


}
