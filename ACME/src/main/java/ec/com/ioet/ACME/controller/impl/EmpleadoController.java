package ec.com.ioet.ACME.controller.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ec.com.ioet.ACME.constantes.AcmeConstante;
import ec.com.ioet.ACME.controller.ifc.IEmpleadoController;
import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.dto.ReporteDTO;
import ec.com.ioet.ACME.service.ifc.IEmpleadoService;
import ec.com.ioet.ACME.service.ifc.IMarcacionService;
import ec.com.ioet.ACME.service.ifc.IReporteService;
import ec.com.ioet.ACME.service.util.ApiUtil;

/**
 *@author Santiago 
 **/

@Controller
public class EmpleadoController implements IEmpleadoController {
	
	@Autowired
	IEmpleadoService service;
	
	@Autowired
	IMarcacionService serviceMarcacion;
	
	@Autowired
	IReporteService serviceReporte;
	
	//@PostMapping("/empleado")
	public ResponseEntity<?> crearEmpleadoConMarcaciones(EmpleadoDTO empleado) {
		EmpleadoDTO entity= service.crearEmpleado(empleado);
		empleado.setIdEmpleado(entity.getIdEmpleado());
		serviceMarcacion.crearMarcacion(empleado);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	public ResponseEntity<?> consultaMarcacionbyFecha(String fechaInicio, String fechaFin) throws ParseException{
		List<ReporteDTO> reporte= serviceMarcacion.consultaMarcacionbyFecha(ApiUtil.format(fechaInicio,AcmeConstante.YYYYMMDD),ApiUtil.format( fechaFin,AcmeConstante.YYYYMMDD));
		return ResponseEntity.ok(reporte);
		
	}

	public ResponseEntity<Resource> generarArchivo() throws IOException {
		File file= (File) serviceReporte.generarArchivo("reporte.txt");
		Path path = Paths.get(file.getAbsolutePath());
	    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

	    HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.txt");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        
	    return ResponseEntity.ok()
	    		.headers(header)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
}
