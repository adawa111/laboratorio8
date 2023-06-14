package com.example.laboratorio8.repository;

import com.example.laboratorio8.Entity.TipoTickerEvento;

import java.util.List;

public interface EventoConTipodeTicketDTO {

    Integer id();

    String nombre();

    String descripcion();

    String fecha();

    List<TipoTickerEvento> tipoDeTickets();
}
