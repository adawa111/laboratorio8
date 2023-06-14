package com.example.laboratorio8.repository;

import com.example.laboratorio8.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento,Integer> {


    //@Query(value = "select evento.id as id, evento.fecha as fecha," +
            //"evento.descripcion as descripcion\n" +
           // "from evento\n" +
          //  "",nativeQuery = true)
    //List<SalariosPorPuestosDTO> salariosPorPuesto();
}
