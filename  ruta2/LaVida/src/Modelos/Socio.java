package Modelos;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="socio",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class Socio implements Serializable{
	
	static public String TIPO_FACTURADO_SOCIO="SOCIO";
	@Id
	@Column(name="codigo")
	private String nroSocio;
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private String telefono;
	@Column(name="status")
	private char status;
	@Column(name="fechaingreso")
	private Date FechaIngreso;
	@Column(name="montoahorrosocio")
	private float MontoAhorro;
	@Column(name="tieneavance")
	private boolean tiene;
	
	@OneToOne
	@JoinColumn(name="rif")
	private Ruta ruta;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codigosocio")
	List<Prestamos> prestamos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	List<Beneficiario> beneficiarios;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="nrosocio")
	List<Vehiculo> vehiculos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codigosocio")
	List<Avance> avances;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	List<Factura> facturas;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CuentaAhorro ctaAhorro;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	List<Deuda> deudas;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	List<Subsidio> subsidio;
	
	public String getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
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


	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	public List<Avance> getAvances() {
		return avances;
	}
	
	public void setAvances(List<Avance> avances) {
		this.avances = avances;
	}
	public Date getFechaIngreso() {
		return FechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
	public float getMontoAhorro() {
		return MontoAhorro;
	}
	public void setMontoAhorro(float montoAhorro) {
		MontoAhorro = montoAhorro;
	}
	public List<Prestamos> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(List<Prestamos> prestamos) {
		this.prestamos = prestamos;
	}
	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}
	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
		public List<Deuda> getDeudas() {
		return deudas;
	}
	public void setDeudas(List<Deuda> deudas) {
		this.deudas = deudas;
	}
	public CuentaAhorro getCtaAhorro() {
		return ctaAhorro;
	}
	public void setCtaAhorro(CuentaAhorro ctaAhorro) {
		this.ctaAhorro = ctaAhorro;
	}
	public boolean isTiene() {
		return tiene;
	}
	public void setTiene(boolean tiene) {
		this.tiene = tiene;
	}
	
	
	
	

}
