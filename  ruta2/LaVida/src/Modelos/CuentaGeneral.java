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
@Table(name="cuentageneral",schema="public")
@PrimaryKeyJoinColumn(name="nrocuenta")
public class CuentaGeneral {
	
	@Id
	@Column(name="codcuenta", nullable=false)
	private String cod_cuenta;
	@Column(name="descripcion", nullable=false)
	private String descripCuenta;
	@Column(name="montotransaccion", nullable=false)
	private float montoTransaccion;
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="rif")
	private Ruta codRuta;
	
	/*@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codctaAhorro")
	private CuentaIngresos ctaIng;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codctaalquiler")
	private CuentaAlquiler ctaAlquiler;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codctafondochoque")
	private CuentaFondoChoque cfchoque;*/
	
	public String getCod_cuenta() {
		return cod_cuenta;
	}
	public String getDescripCuenta() {
		return descripCuenta;
	}
	public float getMontoTransaccion() {
		return montoTransaccion;
	}
	public void setCod_cuenta(String cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}
	public void setDescripCuenta(String descripCuenta) {
		this.descripCuenta = descripCuenta;
	}
	public void setMontoTransaccion(float montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}
	
	
	

}
