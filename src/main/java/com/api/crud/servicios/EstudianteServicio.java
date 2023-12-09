package com.api.crud.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.modelo.EstudianteModel;
import com.api.crud.repositorios.IEstudianteRepositorio;

@Service
public class EstudianteServicio {

	//Inyeccion de dependendias
	@Autowired
	IEstudianteRepositorio useEstudianteRepositorio;
	
	public ArrayList<EstudianteModel> getEstudiantes(){
		
		return (ArrayList<EstudianteModel>) useEstudianteRepositorio.findAll();
	} 
	
	public EstudianteModel guardarEstudiante(EstudianteModel estudiante) {
		return useEstudianteRepositorio.save(estudiante);
	}
	
	public Optional<EstudianteModel> getById(Long id){
		return useEstudianteRepositorio.findById(id);
		
	}
	
	public EstudianteModel updateById(EstudianteModel request, Long id){
		EstudianteModel estudiante = useEstudianteRepositorio.findById(id).get();
		
		estudiante.setNombres(request.getNombres());
		estudiante.setApellidos(request.getApellidos());
		estudiante.setIdentificacion(request.getIdentificacion());
		estudiante.setEmail(request.getEmail());
		useEstudianteRepositorio.save(estudiante);
		return estudiante;
	}
	
	public Boolean deleteEstudiante(Long id) {
		try {
			useEstudianteRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {

			return false;
		}
		
	}
	
}
