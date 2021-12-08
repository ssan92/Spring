package ec.com.ioet.ACME.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;

import ec.com.ioet.ACME.repository.entity.Empleado;
import ec.com.ioet.ACME.repository.entity.Marcacion;
import ec.com.ioet.ACME.repository.entity.Reporte;
import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.dto.MarcacionDTO;
import ec.com.ioet.ACME.service.dto.ReporteDTO;

public final class Convert {
	
	public static Empleado dtoTOentity(EmpleadoDTO dto) {
		return new ModelMapper().map(dto, Empleado.class);
	}
	
	public static EmpleadoDTO convertDTO(Empleado empleado) {
		return new ModelMapper().map(empleado, EmpleadoDTO.class);
	}
	
	public static List<Marcacion> dtoTOentityM(EmpleadoDTO empleadoDTO) {
		List<Marcacion> marList=new ArrayList<Marcacion>();
		System.out.println(TimeZone.getDefault());
		Empleado empleado=dtoTOentity(empleadoDTO);
		for (MarcacionDTO marcacionDTO : empleadoDTO.getMarcaciones()) {
			Marcacion marcacion=new Marcacion();
			marcacion.setFechaEntrada(marcacionDTO.getFechaEntrada());
			marcacion.setFechaSalida(marcacionDTO.getFechaSalida());
			marcacion.setIdMarcacion(marcacionDTO.getIdMarcacion());
			marcacion.setEmpleado(empleado);
			marList.add(marcacion);
		}
		return marList;
	}
	
	public static List<ReporteDTO> dtoTOentityR(List<Reporte> list) {
		List<ReporteDTO> reporteDTOs=new ArrayList<ReporteDTO>();
		for (Reporte reporte : list) {
			ReporteDTO dto=new ReporteDTO();
			dto.setFrecuencia(reporte.getFrecuencia());
			dto.setPares(reporte.getPares());
			reporteDTOs.add(dto);
		}
		return reporteDTOs;
	}

}
