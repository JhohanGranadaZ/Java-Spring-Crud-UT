package com.api.crud.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.modelo.EstudianteModel;
import com.api.crud.servicios.EstudianteServicio;

@RestController
//damos la ruta donde queramos llamar el controlador estudiantes
@RequestMapping("/estudiantes")
public class EstudianteControlador {
	
	@Autowired
	private EstudianteServicio estudianteServicio;
	
	//listar estudiante
	@GetMapping
	public ArrayList<EstudianteModel> getEstudiantes(){
		return this.estudianteServicio.getEstudiantes();		
	}
	
	//guardar estudiante
	@PostMapping
	public EstudianteModel guardarEstudiante(@RequestBody EstudianteModel Estudiante){
		return this.estudianteServicio.guardarEstudiante(Estudiante);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<EstudianteModel> getEstudianteById(@PathVariable("id") Long id){
		return this.estudianteServicio.getById(id);	
	}
	
	@PutMapping(path = "{id}")
	public EstudianteModel updateEstudianteById(@RequestBody EstudianteModel request, @PathVariable Long id) {
		return this.estudianteServicio.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id){
		boolean ok = this.estudianteServicio.deleteEstudiante(id);
		
		if(ok){
			return "Estudiante con id " + id + " eliminado";
		}
		else {
			return "Error, no se ha podido eliminar el estudiante";
		}
	}
	
}
