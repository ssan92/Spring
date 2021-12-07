package ec.com.ioet.ACME.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.ioet.ACME.repository.entity.Marcacion;
import ec.com.ioet.ACME.repository.entity.Reporte;
import ec.com.ioet.ACME.repository.ifc.IMarcacionDAO;
import ec.com.ioet.ACME.repository.ifc.IReporteDAO;
import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.dto.ReporteDTO;
import ec.com.ioet.ACME.service.ifc.IMarcacionService;
import ec.com.ioet.ACME.service.util.Convert;
import ec.com.ioet.ACME.service.util.CrearArchivo;

@Service
public class MarcacionService implements IMarcacionService {

	@Autowired
	IMarcacionDAO repositorio;
	
	@Autowired
	IReporteDAO repositorioReporte;
	
	@Override
	public void crearMarcacion(EmpleadoDTO dto) {
		List<Marcacion> dtos=Convert.dtoTOentityM(dto);
		repositorio.saveAll(dtos);
	}

	@Override
	public List<ReporteDTO> consultaMarcacionbyFecha(Date fechaInicio, Date fechaFin) {
		List<Marcacion> marcacions = repositorio.consultaMarcacionbyFechas(fechaInicio, fechaFin);
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		HashMap<String, Integer> mapTmp=new HashMap<String, Integer>();
		for (Marcacion mPadre : marcacions) {
			
			List<Marcacion> mEmpleado =repositorio.consultaMarcacionbyFechaYempleado(mPadre.getFechaEntrada(), mPadre.getEmpleado().getIdEmpleado());
			String nombre=mPadre.getEmpleado().getNombre();
			for (Marcacion mHijo : mEmpleado) {
				String key=nombre+"-"+mHijo.getEmpleado().getNombre();
				String keyInv=mHijo.getEmpleado().getNombre()+"-"+nombre;
				//System.out.println(nombre+" - "+mHijo.getEmpleado().getNombre()+" - "+con);
				if(!map.containsKey(keyInv))
				if(map.containsKey(key)) {
					int tmp=map.get(key);
					map.put(key, tmp+1);
				}else {
					map.put(key, 1);
				}
				mapTmp.put(keyInv, 0);
			}
		}
		List<Reporte> listReporte=new ArrayList<Reporte>();
		for (String clave:map.keySet()) {
		    int valor = map.get(clave);
		    System.out.println("Clave: " + clave + ", valor: " + valor);
		    
		    Reporte reporte=new Reporte();
		    reporte.setFechaGeneracion(new Date(System.currentTimeMillis()));
		    reporte.setFrecuencia(String.valueOf(valor));
		    reporte.setPares(clave);
		    reporte.setFechaInicioParam(fechaInicio);
		    reporte.setFechaFinParam(fechaFin);
		    reporte.setIdReporte(Long.valueOf("0"));
		    listReporte.add(reporte);
		}
		repositorioReporte.saveAll(listReporte);
		List<ReporteDTO> dto=Convert.dtoTOentityR(listReporte);
		return dto;
	}

}
