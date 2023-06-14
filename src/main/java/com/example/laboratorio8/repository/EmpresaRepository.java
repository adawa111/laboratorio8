package com.example.laboratorio8.repository;

import com.example.laboratorio8.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
}
