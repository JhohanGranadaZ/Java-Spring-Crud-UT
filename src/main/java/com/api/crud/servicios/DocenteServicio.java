package com.api.crud.servicios;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crud.modelo.DocenteModel;
import com.api.crud.repositorios.IDocenteRepositorio;

@Service
public class DocenteServicio {
	

	//Inyeccion de dependendias
	@Autowired
	IDocenteRepositorio useDocenteRepositorio;
	
	public ArrayList<DocenteModel> getDocentes(){
		
		return (ArrayList<DocenteModel>) useDocenteRepositorio.findAll();
	} 
	
	public DocenteModel guardarDocente(DocenteModel docente) {
		return useDocenteRepositorio.save(docente);
	}
	
	public Optional<DocenteModel> getById(Long id){
		return useDocenteRepositorio.findById(id);
		
	}
	
	public DocenteModel updateById(DocenteModel request, Long id){
		DocenteModel docente = useDocenteRepositorio.findById(id).get();
		
		if(!useDocenteRepositorio.existsById(id)) {
			throw new RuntimeException("No se puede actualizar. Docente no encontrado con el ID proporcionado");
		}
		
		docente.setNombres(request.getNombres());
		docente.setApellidos(request.getApellidos());
		docente.setIdentificacion(request.getIdentificacion());
		docente.setEmail(request.getEmail());
		docente.setTipo_identificacion(request.getTipo_identificacion());
		docente.setMateria(request.getMateria());
		useDocenteRepositorio.save(docente);
		return docente;
	}
	
	public Boolean deleteDocente(Long id) {
		try {
			if (!useDocenteRepositorio.existsById(id)) {
				throw new RuntimeException("No se puede eliminar. Docente no encontrado con el ID proporcionado");
			}
			useDocenteRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {

			return false;
		}
		
	}

}
