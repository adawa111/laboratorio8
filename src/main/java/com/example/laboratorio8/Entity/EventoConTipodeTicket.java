package com.example.laboratorio8.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class EventoConTipodeTicket {

    @Id
    private Integer id;

    private String nombre;

    private String descripcion;

    private String fecha;

    private List<TipoTickerEvento> tipoDeTickets;
}
