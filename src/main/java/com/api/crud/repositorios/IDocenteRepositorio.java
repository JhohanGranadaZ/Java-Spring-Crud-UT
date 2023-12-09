package com.api.crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.modelo.DocenteModel;

@Repository
public interface IDocenteRepositorio extends JpaRepository<DocenteModel, Long>{

}
