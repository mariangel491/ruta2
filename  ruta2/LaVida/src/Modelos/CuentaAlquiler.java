package Modelos;

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
@Table(name="cuentaalquiler",schema="public")
@PrimaryKeyJoinColumn(name="nrocuenta")
public class CuentaAlquiler {
	
	@Id
	@Column(name="nrotransaccion", nullable=false)
	private String nro_cuenta;
	@Column(name="montotransaccion", nullable=false)
	private Float montoTransaccion;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@Column(name="descripcion", nullable=false)
	private String descripTransac;
	@Column(name="status",nullable=false)
	private String status;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CuentaGeneral ctaGeneral;
	
	@OneToOne(cascade= CascadeType.ALL, optional=false)
	@JoinColumn(name="nrofactura")
	private Factura factura;
	
	
	public String getNro_cuenta() {
		return nro_cuenta;
	}
	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}
	public Float getMontoTransaccion() {
		return montoTransaccion;
	}
	public void setMontoTransaccion(Float montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripTransac() {
		return descripTransac;
	}
	public void setDescripTransac(String descripTransac) {
		this.descripTransac = descripTransac;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}

