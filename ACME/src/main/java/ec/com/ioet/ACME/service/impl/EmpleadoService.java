package ec.com.ioet.ACME.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.ioet.ACME.repository.entity.Empleado;
import ec.com.ioet.ACME.repository.ifc.IEmpleadoDAO;
import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.ifc.IEmpleadoService;
import ec.com.ioet.ACME.service.util.Convert;

/**
 * @author Santiago
 **/


@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	IEmpleadoDAO repositorio;

	@Override
	public EmpleadoDTO crearEmpleado(EmpleadoDTO empleado) {
		Empleado entity= repositorio.save(Convert.dtoTOentity(empleado));
		return Convert.convertDTO(entity);
	}

}
