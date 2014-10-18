package Modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="vehiculoarrendatario",schema="public")
@PrimaryKeyJoinColumn(name="placa")
public class VehiculoArrendatario implements Serializable{
	
		@Id
		@Column(name="placa",nullable=false)
		private String placa;
		@Column(name="serial",nullable=false)
		private String serialCarroceria;
		/*@Column(name="marca")
		private String marca;*/
		@Column(name="anno",nullable=false)
		private Integer anno;
		@Column(name="nropuestos",nullable=false)
		private Integer nropuestos;
		@Column(name="avance",nullable=false)
		private String avance;
		
		@OneToOne(cascade= CascadeType.ALL, optional=false)
		@JoinColumn(name="codarrendatario")
		private Arrendatario arrendatario;
		
		@OneToOne(cascade= CascadeType.ALL, optional=false)
		@JoinColumn(name="marca")
		private Marca codMarca;

		
		public VehiculoArrendatario(String placa, String serialCarroceria,
				Integer anno, Integer nropuestos, String avance,
				Arrendatario arrendatario, Marca codMarca) {
			super();
			this.placa = placa;
			this.serialCarroceria = serialCarroceria;
			this.anno = anno;
			this.nropuestos = nropuestos;
			this.avance = avance;
			this.arrendatario = arrendatario;
			this.codMarca = codMarca;
		}

		public VehiculoArrendatario() {
			// TODO Auto-generated constructor stub
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getSerialCarroceria() {
			return serialCarroceria;
		}

		public void setSerialCarroceria(String serialCarroceria) {
			this.serialCarroceria = serialCarroceria;
		}

		public Integer getAnno() {
			return anno;
		}

		public void setAnno(Integer anno) {
			this.anno = anno;
		}

		public Integer getNropuestos() {
			return nropuestos;
		}

		public void setNropuestos(Integer nropuestos) {
			this.nropuestos = nropuestos;
		}

		public String getAvance() {
			return avance;
		}

		public void setAvance(String avance) {
			this.avance = avance;
		}

		public Arrendatario getArrendatario() {
			return arrendatario;
		}

		public void setArrendatario(Arrendatario arrendatario) {
			this.arrendatario = arrendatario;
		}

		public Marca getCodMarca() {
			return codMarca;
		}

		public void setCodMarca(Marca codMarca) {
			this.codMarca = codMarca;
		}
		
		
		
		
		
		
}
