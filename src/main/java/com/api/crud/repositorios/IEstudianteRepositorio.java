package com.api.crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.modelo.EstudianteModel;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<EstudianteModel, Long> {

}
