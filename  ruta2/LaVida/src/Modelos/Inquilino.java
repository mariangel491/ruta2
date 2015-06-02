package Modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="inquilino",schema="public")
@PrimaryKeyJoinColumn(name="cedula_rif")
public class Inquilino implements Serializable{
	
	//static public String TIPO_INQUILINO_SOCIO="INQUILINO";
	static public String TIPO_FACTURADO_INQUILINO = "INQUILINO";
	@Id
	@Column(name="codinquilino")
	private String codinquilino;
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private Integer telefono;
	@Column(name="status")
	private String status;
	@Column(name="tipopersona")
	private String tipo;
	@Column(name="rif")
	private String rif;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codinquilino")
	Set<Factura> facturas = new HashSet<Factura>();
	
	@OneToMany
	@JoinColumn(name="codinquilino")
	List<Alquiler> alquileres;

	@OneToOne
	@JoinColumn(name="codigoruta")
	private Ruta ruta;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codinquilino")
	List<Deuda> deudas;
	
	public String getCodInquilino() {
		return codinquilino;
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

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

/*	public List<Alquiler> getAlquileres() {
		return alquileres;
	}
	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}*/
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodinquilino() {
		return codinquilino;
	}
	public void setCodinquilino(String codinquilino) {
		this.codinquilino = codinquilino;
	}
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
	
	

}
