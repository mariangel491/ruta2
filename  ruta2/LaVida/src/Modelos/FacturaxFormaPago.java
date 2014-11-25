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
@Table(name="facturaxformapago",schema="public")
@PrimaryKeyJoinColumn(name="id")
public class FacturaxFormaPago implements Serializable{
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="monto")
	private float monto;
	@Column(name="fecha")
	private Date fecha;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigofactura")
	private Factura factura;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoformap")
	private FormaPago formaPago;
	

	
	public FacturaxFormaPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
