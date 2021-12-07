package ec.com.ioet.ACME.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Santiago
 **/


public class EmpleadoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEmpleado;
	private String nombre;
	private List<MarcacionDTO> marcaciones;
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<MarcacionDTO> getMarcaciones() {
		return marcaciones;
	}
	public void setMarcaciones(List<MarcacionDTO> marcaciones) {
		this.marcaciones = marcaciones;
	}
	
	

}
