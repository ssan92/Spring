package ec.com.ioet.ACME.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.ioet.ACME.repository.entity.Reporte;
import ec.com.ioet.ACME.repository.ifc.IReporteDAO;
import ec.com.ioet.ACME.service.ifc.IReporteService;
import ec.com.ioet.ACME.service.util.CrearArchivo;

@Service
public class ReporteService implements IReporteService {

	@Autowired
	IReporteDAO repositorioReporte;
	
	@Autowired
	CrearArchivo crearArchivo;
	
	@Override
	public Object generarArchivo(String ruta) {
		Iterable<Reporte> list= repositorioReporte.findAll();
		
		File file= crearArchivo.crearArchivoTXT(list, ruta);
		return file;
	}

}
