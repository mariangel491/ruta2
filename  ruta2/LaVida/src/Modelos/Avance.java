package Modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="avance",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class Avance implements Serializable {
	
	@Id
	@Column(name="codigo")
	private String codAvance;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="cedula")
	private String cedula;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private Integer telefono;
	@Column(name="fechaingreso")
	private Date FechaIngreso;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigosocio")
	private Socio socio;
	
	/*@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Vehiculo vehiculo;
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}*/
	
	
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
	public String getCodAvance() {
		return codAvance;
	}
	public void setCodAvance(String codAvance) {
		this.codAvance = codAvance;
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
	
	

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	
	

}
