/**
 * 
 */
package ec.com.ioet.ACME.service.ifc;

import org.springframework.stereotype.Repository;

/**
 * @author Santiago
 *
 */
@Repository
public interface IReporteService {
	
	public Object generarArchivo(String ruta);

}
