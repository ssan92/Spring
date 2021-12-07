package ec.com.ioet.ACME.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Santiago
 * */

@Entity
@Table(name = "Reporte")
public class Reporte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reporte")
	private Long idReporte;
	
	@Column(length = 60)
	private String pares;
	
	@Column(length = 200)
	private String frecuencia;
	
	@Column(name="fecha_generacion")
	private Date fechaGeneracion;
	
	@Column(name="fecha_inicio_param")
	private Date fechaInicioParam;
	
	@Column(name="fecha_fin_param")
	private Date fechaFinParam;
	
	public Long getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Long idReporte) {
		this.idReporte = idReporte;
	}
	public String getPares() {
		return pares;
	}
	public void setPares(String pares) {
		this.pares = pares;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaInicioParam() {
		return fechaInicioParam;
	}
	public void setFechaInicioParam(Date fechaInicioParam) {
		this.fechaInicioParam = fechaInicioParam;
	}
	public Date getFechaFinParam() {
		return fechaFinParam;
	}
	public void setFechaFinParam(Date fechaFinParam) {
		this.fechaFinParam = fechaFinParam;
	}
	
	

}
