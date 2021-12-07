package ec.com.ioet.ACME.service.dto;

import java.util.Date;

/**
 * @author Santiago
 **/

public class MarcacionDTO {
	
	private Long idMarcacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	public Long getIdMarcacion() {
		return idMarcacion;
	}
	public void setIdMarcacion(Long idMarcacion) {
		this.idMarcacion = idMarcacion;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	

}
