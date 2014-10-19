package Modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="beneficiario",schema="public")
@PrimaryKeyJoinColumn(name="cedulabenef")
public class Beneficiario implements Serializable {
	
	@Id
	@Column(name="cedulabenef")
	private String cedBeneficiario;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellido")
	private String apellido;
	@Column(name="Direccion")
	private String direccion;
	@Column(name="Telefono")
	private Integer telefono;
	@Column(name="Status")
	private String status;
	@Column(name="edad")
	private Integer edad;
	@Column(name="parentesco")
	private String parentesco;
	@Column(name="fechanacimiento")
	private Date fechanacimiento;
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="codsocio")
	private Socio socio;

	
	
	public Beneficiario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beneficiario(String cedBeneficiario, String nombre, String apellido, Integer edad, String parentesco,
			String direccion, Integer telefono, String status, Date fechanacimiento, Socio socio) {
		super();
		this.cedBeneficiario = cedBeneficiario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.parentesco = parentesco;
		this.direccion = direccion;
		this.telefono = telefono;
		this.status = status;
		this.fechanacimiento = fechanacimiento;
		this.socio = socio;
	}
	public String getCedBeneficiario() {
		return cedBeneficiario;
	}
	public void setCedBeneficiario(String cedBeneficiario) {
		this.cedBeneficiario = cedBeneficiario;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
}
