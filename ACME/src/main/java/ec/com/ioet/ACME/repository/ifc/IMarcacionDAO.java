package ec.com.ioet.ACME.repository.ifc;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.com.ioet.ACME.repository.entity.Marcacion;

/**
 * @author Santiago
 * */

public interface IMarcacionDAO extends CrudRepository<Marcacion, Long>{
	
	//@Query("SELECT m FROM Marcacion  m where trunc(m.fechaEntrada)>=?1 and trunc(m.fechaSalida)<=?2 order by m.fechaEntrada order by m.fechaEntrada")
	List<Marcacion> consultaMarcacionbyFechas(Date fechaInicio, Date fechaFin);
	
	List<Marcacion> consultaMarcacionbyFechaYempleado(Date fechaInicio, Long idEmpleado);

}
