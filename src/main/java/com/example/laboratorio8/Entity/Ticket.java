package com.example.laboratorio8.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne
    @JoinColumn(name = "idtipoticket")
    private TipoTickerEvento idtipoticket;

    @OneToOne
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;

}
