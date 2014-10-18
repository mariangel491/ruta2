package Modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="prestamo",schema="public")
@PrimaryKeyJoinColumn(name="codigoprestamo")
public class Prestamos implements Serializable{
	
	@Id
	@Column(name="codigoprestamo")
	private String codPrestamo;
	@Column(name="montoprestamo")
	private float monto;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fechaemision")
	private Date fechaEmision;
	@Column(name="status")
	private char status;
	
	@OneToOne
	@JoinColumn(name="codigosocio")
	private Socio nroSocio;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CuentaPrestamos ctaPrestamos;
	
	public Prestamos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//no se si generamos este constructor..??
	public Prestamos(String codPrestamo, Socio nroSocio, float monto, String descripcion, 
			          Date fechaEmision, char status) 
	{
		super();
		this.codPrestamo = codPrestamo;
		this.nroSocio = nroSocio;
		this.monto = monto;
		this.descripcion = descripcion;
		this.fechaEmision = fechaEmision;
		this.status = status;
	}
	
	public Socio getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(Socio nroSocio) {
		this.nroSocio = nroSocio;
	}
	
	
	public String getCodPrestamo() {
		return codPrestamo;
	}
	public void setCodPrestamo(String codPrestamo) {
		this.codPrestamo = codPrestamo;
	}


	public float getMonto(){
		return monto;
	}
	public void setMonto(float monto){
		this.monto=monto;
	}
	

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaEmision(){
		return fechaEmision;
	}
	public void setFechaEmision(Date fecha){
		this.fechaEmision=fecha;
	}
	
	
	public char getStatus(){
		return status;
	}
	public void setStatus(char stat){
		this.status=stat;
	}
	
	
}