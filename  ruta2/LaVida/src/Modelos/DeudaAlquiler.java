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
@Table(name="deudaalquiler", schema="public")
@PrimaryKeyJoinColumn(name="coddeuda")
public class DeudaAlquiler implements Serializable
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
	@JoinColumn(name="codinquilino")
	private Inquilino inquilino;

	@OneToOne
	@PrimaryKeyJoinColumn
	private HistorialDeuda historial;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	
}
