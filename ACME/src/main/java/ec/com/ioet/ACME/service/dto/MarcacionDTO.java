package ec.com.ioet.ACME.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Santiago
 **/

public class MarcacionDTO {
	
	private Long idMarcacion;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT-5")
	private Date fechaEntrada;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT-5")
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
