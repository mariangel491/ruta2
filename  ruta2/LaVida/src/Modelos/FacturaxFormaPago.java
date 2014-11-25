package Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="facturaxformapago",schema="public")
@PrimaryKeyJoinColumn
public class FacturaxFormaPago {
	
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigofactura")
	private Factura factura;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codigoformap")
	private FormaPago formaPago;

}
