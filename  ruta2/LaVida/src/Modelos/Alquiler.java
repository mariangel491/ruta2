package Modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name="alquiler",schema="public")
@PrimaryKeyJoinColumn(name="codigo")
public class Alquiler implements Serializable{
	
	@Id
	@Column(name="codigo", length=5, nullable=false)
	private String codAlquiler;
	@Column(name="montodeposito")
	private float monto;
	@Column(name="fechainicio")
	private Date fechaInicio;
	@Column(name="fechafin")
	private Date fechaFin;
	@Column(name="status")
	private String status;
	
	@OneToOne(cascade= CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	@JoinColumn(name="codlocal")
	private Local codLocal;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codinquilino")
	private Inquilino codInquilino;

	public String getCodAlquiler() {
		return codAlquiler;
	}
	public void setCodAlquiler(String codAlquiler) {
		this.codAlquiler = codAlquiler;
	}
	
	
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date date) {
		this.fechaInicio = date;
	}
	
	
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date date) {
		this.fechaFin = date;
	}
	
	public Local getCodLocal() {
		return codLocal;
	}
	public void setCodLocal(Local codLocal) {
		this.codLocal = codLocal;
	}
	public Inquilino getCodInquilino() {
		return codInquilino;
	}
	public void setCodInquilino(Inquilino codInquilino) {
		this.codInquilino = codInquilino;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
