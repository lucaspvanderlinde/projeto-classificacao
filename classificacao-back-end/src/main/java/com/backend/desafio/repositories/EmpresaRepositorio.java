package com.backend.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.desafio.model.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {

}
