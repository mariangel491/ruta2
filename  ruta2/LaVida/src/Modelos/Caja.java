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
@Table(name="caja",schema="public")
@PrimaryKeyJoinColumn(name="nrotransaccion")
public class Caja {
	
	//codigo, fecha, monto, status(D o N), relacion con la factura
	//en el detalle de la factura se debe tener un monto especifico?????
	
	@Id
	@Column(name="nrotransaccion", nullable=false)
	private String nro_cuenta;
	@Column(name="montotransaccion", nullable=false)
	private float montoTransaccion;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@Column(name="status", nullable=false)
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CuentaGeneral getCtaGeneral() {
		return ctaGeneral;
	}

	public void setCtaGeneral(CuentaGeneral ctaGeneral) {
		this.ctaGeneral = ctaGeneral;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
