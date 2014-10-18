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
@Table(name="cuentaahorro",schema="public")
@PrimaryKeyJoinColumn(name="nrocuenta")
public class CuentaAhorro {
	
	@Id
	@Column(name="nrocuenta", length=5, nullable=false)
	private String nro_cuenta;
	@Column(name="montotransaccion", nullable=false)
	private float montoTransaccion;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@Column(name="descripcion", nullable=false)
	private String descripTransac;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	private Socio socio;
	
	@OneToOne(cascade= CascadeType.ALL, optional=false)
	@JoinColumn(name="nrofactura")
	private Factura factura;
	
	public CuentaAhorro() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getDescripTransac() {
		return descripTransac;
	}

	public void setDescripTransac(String descripTransac) {
		this.descripTransac = descripTransac;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	
	
	
}
