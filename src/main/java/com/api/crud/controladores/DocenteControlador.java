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

import com.api.crud.modelo.DocenteModel;
import com.api.crud.servicios.DocenteServicio;

@RestController
//damos la ruta donde queramos llamar el controlador docentes
@RequestMapping(path = "/docentes")
public class DocenteControlador {
	
	@Autowired
	private DocenteServicio docenteServicio;
	
	//listar docente
	@GetMapping
	public ArrayList<DocenteModel> getDocentes(){
		return this.docenteServicio.getDocentes();		
	}
	
	//guardar docente
	@PostMapping
	public DocenteModel guardarDocente(@RequestBody DocenteModel Docente){
		return this.docenteServicio.guardarDocente(Docente);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<DocenteModel> getDocenteById(@PathVariable("id") Long id){
		return this.docenteServicio.getById(id);	
	}
	
	@PutMapping(path = "{id}")
	public DocenteModel updateDocenteById(@RequestBody DocenteModel request, @PathVariable Long id) {
		return this.docenteServicio.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id){
		boolean ok = this.docenteServicio.deleteDocente(id);
		
		if(ok){
			return "Docente con id " + id + " eliminado";
		}
		else {
			return "Error, no se ha podido eliminar el docente";
		}
	}

}
