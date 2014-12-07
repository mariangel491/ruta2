package Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="iedetallefactura",schema="public")
@PrimaryKeyJoinColumn(name="iddetalle")
public class IEDetalleFactura 
{
	@Id
	@Column(name="iddetalle", nullable=false)
	private String iddetalle;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="coddetfact")
	private DetalleFactura df;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codegreso")
	private Egresos eg;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codingreso")
	private Ingresos ing;

	@Column(name="cantidad", nullable=false)
	private int cantidad;
	
	@Column(name="montounitario", nullable=false)
	private double monto;

	public String getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(String iddetalle) {
		this.iddetalle = iddetalle;
	}

	public DetalleFactura getDf() {
		return df;
	}

	public void setDf(DetalleFactura df) {
		this.df = df;
	}

	public Egresos getEg() {
		return eg;
	}

	public void setEg(Egresos eg) {
		this.eg = eg;
	}

	public Ingresos getIng() {
		return ing;
	}

	public void setIng(Ingresos ing) {
		this.ing = ing;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
}
