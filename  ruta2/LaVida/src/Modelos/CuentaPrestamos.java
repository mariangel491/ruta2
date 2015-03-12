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
@Table(name="cuentaprestamos",schema="public")
@PrimaryKeyJoinColumn(name="nrocuenta")
public class CuentaPrestamos {
	
	@Id
	@Column(name="nrotransaccion", nullable=false)
	private String nro_transaccion;
	@Column(name="montotransaccion", nullable=false)
	private float montoTransaccion;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@Column(name="descripcion", nullable=false)
	private String descripTransac;
	@Column(name="status",nullable=false)
	private String status;
	
	
	@OneToOne(cascade= CascadeType.ALL,optional=false)
	@JoinColumn(name="codprestamo")
	private Prestamos prestamo = new Prestamos();
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CuentaGeneral ctaGeneral;
	
	@OneToOne(cascade= CascadeType.ALL, optional=false)
	@JoinColumn(name="nrofactura")
	private Factura factura = new Factura();
	
	public CuentaPrestamos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNro_transaccion() {
		return nro_transaccion;
	}
	public void setNro_transaccion(String nro_cuenta) {
		this.nro_transaccion = nro_cuenta;
	}
	public float getMontoTransaccion() {
		return montoTransaccion;
	}
	public void setMontoTransaccion(float montoTransaccion) {
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
	public Prestamos getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamos prestamo) {
		this.prestamo = prestamo;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
