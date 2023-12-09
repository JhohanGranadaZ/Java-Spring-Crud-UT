package com.api.crud.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "docentes")
public class DocenteModel {
	//mapeamos todos los campos de la tabla docentes con sus respectivos getters and setters
		@jakarta.persistence.Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column (unique = true, nullable = false)
		private Long Id;
		
		@Column
		private String nombres;
		
		@Column
		private String apellidos;
		
		@Column
		private String identificacion;
		
		@Column
		private String email;
		
		@Column
		private String tipo_identificacion;
		
		@Column
		private String materia;
		
		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getNombres() {
			return nombres;
		}

		public void setNombres(String nombres) {
			this.nombres = nombres;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getIdentificacion() {
			return identificacion;
		}

		public void setIdentificacion(String identificacion) {
			this.identificacion = identificacion;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTipo_identificacion() {
			return tipo_identificacion;
		}

		public void setTipo_identificacion(String tipo_identificacion) {
			this.tipo_identificacion = tipo_identificacion;
		}

		public String getMateria() {
			return materia;
		}

		public void setMateria(String materia) {
			this.materia = materia;
		}

		

}
