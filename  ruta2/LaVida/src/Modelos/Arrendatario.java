package Modelos;

import java.io.Serializable;
import java.util.List;

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
@Table(name="arrendatario",schema="public")
@PrimaryKeyJoinColumn(name="cedula")
public class Arrendatario implements Serializable{
	
	static public String TIPO_FACTURADO_ARRENDATARIO="ARRENDATARIO";
	@Id
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
	@Column(name="status",nullable=false)
	private String status;
	@Column(name="monto",nullable=false)
	private Float monto;
	@Column(name="TieneAvance", nullable=false)
	private boolean tiene;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	private Ruta ruta;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codarrendatario")
	List<Factura> facturas;
	
	//RECORDARSE HACER LA RELACION CON LOS AVANCES
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codarrendatario")
	List<VehiculoArrendatario> vehiculos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codarrendatario")
	List<AvanceArrendatario> avances;

	public Arrendatario(String cedula, String nombre,
			String apellido, String direccion, Integer telefono, String status,
			Float monto, Ruta ruta) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.status = status;
		this.monto = monto;
		this.ruta = ruta;
	}

	public Arrendatario() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}


	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<VehiculoArrendatario> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<VehiculoArrendatario> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<AvanceArrendatario> getAvances() {
		return avances;
	}

	public void setAvances(List<AvanceArrendatario> avances) {
		this.avances = avances;
	}

	public boolean isTiene() {
		return tiene;
	}

	public void setTiene(boolean tiene) {
		this.tiene = tiene;
	}
	
	
	

}
