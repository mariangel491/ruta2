package Modelos;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ruta",schema="public")
@PrimaryKeyJoinColumn(name="rif")
public class Ruta implements Serializable{
	
	@Id
	@Column(name="rif")
	private String rif;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private Integer telefono;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	List<Factura> facturas;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	List<Arrendatario> arrendatarios;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoruta")
	List<Inquilino> inquilinos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	List<Local> locales;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoruta")
	List<Ingresos> ingresos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoruta")
	List<Egresos> egresos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="rif")
	List<Socio> socios;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CuentaGeneral ctagral;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private HistorialDeuda historial;
	
	
	
	
	public Ruta() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	//no se si generamos este constructor..??
	public Ruta(String rif, String nombre, String direccion, Integer telefono) {
		super();
		this.rif = rif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	
	
	
	
}
