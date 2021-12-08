package ec.com.ioet.ACME.service.ifc;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.dto.ReporteDTO;


/**
 * @author Santiago
 * */

public interface IMarcacionService {
	
	public void crearMarcacion(EmpleadoDTO dto);
	
	public List<ReporteDTO> consultaMarcacionbyFecha(Date fechaInicio, Date fechaFin) throws ParseException;
	

}
