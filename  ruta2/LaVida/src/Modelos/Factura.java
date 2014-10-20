package Modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="factura",schema="public")
@PrimaryKeyJoinColumn(name="nrofactura")
public class Factura implements Serializable{
	
	@Id
	@Column(name="nrofactura")
	private String nroFactura;
	@Column(name="montototal")
	private float montoTotal;
	@Column(name="fechaemision")
	private Date fechaEmision;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	private Socio nroSocio;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codinquilino")
	private Inquilino inquilino;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codarrendatario")
	private Arrendatario arrendatario;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codruta")
	private Ruta codRuta;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="facturaxformapago", joinColumns={@JoinColumn(name="nrofactura")}, inverseJoinColumns={@JoinColumn(name="codigo")})
	private Set<FormaPago> formas=new HashSet();
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private DetalleFactura detalle;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="factura")
	List<CuentaPrestamos> ctaPrestamos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="nrofactura")
	List<CuentaIngresos> ctaIngresos;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="factura")
	List<CuentaFondoChoque> ctaFondoChoque;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="nrofactura")
	List<CuentaAlquiler> ctaAlquiler;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="nrofactura")
	List<Caja> caja;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="nrofactura")
	List<CuentaAhorro> ctaAhorro;
	
	public Factura(String nroFactura, float montoTotal, Date fechaEmision,
			Socio nroSocio, Ruta codRuta) {
		super();
		this.nroFactura = nroFactura;
		this.montoTotal = montoTotal;
		this.fechaEmision = fechaEmision;
		this.nroSocio = nroSocio;
		this.codRuta = codRuta;
	}
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}
	
	
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	

	public Socio getNroSocio() {
		return nroSocio;
	}


	public void setNroSocio(Socio nroSocio) {
		this.nroSocio = nroSocio;
	}


	public Ruta getCodRuta() {
		return codRuta;
	}


	public void setCodRuta(Ruta codRuta) {
		this.codRuta = codRuta;
	}


	public Inquilino getInquilino() {
		return inquilino;
	}


	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}


	public Arrendatario getArrendatario() {
		return arrendatario;
	}


	public void setArrendatario(Arrendatario arrendatario) {
		this.arrendatario = arrendatario;
	}
	
	
	

}
