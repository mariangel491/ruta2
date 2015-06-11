package Modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="avancearrendatario",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class AvanceArrendatario {
		
		@Id
		@Column(name="codigo",nullable=false)
		private String codAvance;
		@Column(name="cedula",nullable=false)
		private String cedula;
		@Column(name="nombre",nullable=false)
		private String nombre;
		@Column(name="apellido",nullable=false)
		private String apellido;
		@Column(name="direccion",nullable=false)
		private String direccion;
		@Column(name="telefono",nullable=false)
		private Integer telefono;
		@Column(name="fechaingreso",nullable=false)
		private Date FechaIngreso;
		
		@OneToOne(cascade= CascadeType.ALL,optional=false)
		@JoinColumn(name="codarrendatario")
		private Arrendatario arrendatario;

		public AvanceArrendatario(String codAvance, String cedula,
				String nombre, String apellido, String direccion,
				Integer telefono, Date fechaIngreso, Arrendatario arrendatario) {
			super();
			this.codAvance = codAvance;
			this.cedula = cedula;
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
			this.telefono = telefono;
			this.FechaIngreso = fechaIngreso;
			this.arrendatario = arrendatario;
		}

		public AvanceArrendatario() {
			// TODO Auto-generated constructor stub
		}

		public String getCodAvance() {
			return codAvance;
		}

		public void setCodAvance(String codAvance) {
			this.codAvance = codAvance;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public Integer getTelefono() {
			return telefono;
		}

		public void setTelefono(Integer telefono) {
			this.telefono = telefono;
		}

		public Date getFechaIngreso() {
			return FechaIngreso;
		}

		public void setFechaIngreso(Date fechaIngreso) {
			FechaIngreso = fechaIngreso;
		}

		public Arrendatario getArrendatario() {
			return arrendatario;
		}

		public void setArrendatario(Arrendatario arrendatario) {
			this.arrendatario = arrendatario;
		}
		
		
}
