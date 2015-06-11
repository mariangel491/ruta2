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
@Table(name="deuda", schema="public")
@PrimaryKeyJoinColumn(name="coddeuda")
public class Deuda implements Serializable
{
	@Id
	@Column(name="coddeuda", nullable=false)
	private String codigo;
	@Column(name="montodeuda", nullable=false)
	private float monto;
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	@Column(name="status", nullable=false)
	private String status;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	private Socio socio;
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

	
	/*
	 * 
	 *
	@OneToOne(cascade= CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	@JoinColumn(name="codlocal")
	private Local codLocal;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codinquilino")
	private Inquilino codInquilino;
	 * 
	 * 
	 * 
	 * */
	
	
}
