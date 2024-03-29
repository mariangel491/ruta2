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
@Table(name="subsidio",schema="public")
@PrimaryKeyJoinColumn(name="codsubsidio")
public class Subsidio implements Serializable {

		@Id
		@Column(name="codsubsidio", nullable= false)
		private String codigo;
		@Column(name="monto", nullable= false)
		private float monto;
		@Column(name="status", nullable= false)
		private char status;
		@Column(name="fecha", nullable= false)
		private Date Fecha;
		
		@OneToOne(cascade= CascadeType.ALL, optional= false)
		@JoinColumn(name="codsocio")
		private Socio socio;
		
		public Socio getSocio() {
			return socio;
		}
		public void setSocio(Socio socio) {
			this.socio = socio;
		}
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
		public char getStatus() {
			return status;
		}
		public void setStatus(char status) {
			this.status = status;
		}
		public Date getFecha() {
			return Fecha;
		}
		public void setFecha(Date fecha) {
			Fecha = fecha;
		}
	
		
		
}
