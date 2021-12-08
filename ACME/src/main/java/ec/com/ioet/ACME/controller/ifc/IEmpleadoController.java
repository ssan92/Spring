package ec.com.ioet.ACME.controller.ifc;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.util.ApiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Santiago
 **/

@Api(tags = "ACMEV1", description = "Servicio para dar seguimiento a las marcaciones")
public interface IEmpleadoController {
	
	default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }
	
	@ApiOperation(value = "", nickname = "crearEmpleadoConMarcaciones", notes = "registrar los empleados con sus marcaciones", tags={ "ACMEV1", })
	@RequestMapping(value = "/empleado",
    produces = "application/json", 
    consumes = "application/json",
    method = RequestMethod.POST)
	default ResponseEntity<?> crearEmpleadoConMarcaciones(@RequestBody(required = true) EmpleadoDTO empleado){
		getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{\r\n" + 
                    		"   \"idEmpleado\":1,\r\n" + 
                    		"   \"nombre\":\"santiago\",\r\n" + 
                    		"   \"marcaciones\":[\r\n" + 
                    		"      {\r\n" + 
                    		"         \"idMarcacion\":200,\r\n" + 
                    		"         \"fechaIngreso\":\"2021-12-07 10:00:00\",\r\n" + 
                    		"         \"fechaSalida\":\"2021-12-07 12:00:00\"\r\n" + 
                    		"      },\r\n" + 
                    		"      {\r\n" + 
                    		"         \"idMarcacion\":201,\r\n" + 
                    		"         \"fechaIngreso\":\"2021-12-08 10:00:00\",\r\n" + 
                    		"         \"fechaSalida\":\"2021-12-08 12:00:00\"\r\n" + 
                    		"      }\r\n" + 
                    		"   ]\r\n" + 
                    		"}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "", nickname = "consultaMarcacionbyFecha", notes = "consultar las marcaciones que coincidan por rango de fecha", tags={ "ACMEV1", })
	@RequestMapping(value = "/marcacion/{fechaInicio}/{fechaFin}",
    produces = "application/json", 
    method = RequestMethod.GET)
	default ResponseEntity<?> consultaMarcacionbyFecha(@ApiParam(value = "",required=true) @PathVariable("fechaInicio") String fechaInicio,@ApiParam(value = "",required=true) @PathVariable("fechaFin") String fechaFin)throws ParseException{
		getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[\r\n" + 
                    		"  {\r\n" + 
                    		"    \"pares\": \"RENE-ASTRID\",\r\n" + 
                    		"    \"frecuencia\": \"2\"\r\n" + 
                    		"  },\r\n" + 
                    		"  {\r\n" + 
                    		"    \"pares\": \"RENE-ANDRES\",\r\n" + 
                    		"    \"frecuencia\": \"2\"\r\n" + 
                    		"  },\r\n" + 
                    		"  {\r\n" + 
                    		"    \"pares\": \"ASTRID-ANDRES\",\r\n" + 
                    		"    \"frecuencia\": \"3\"\r\n" + 
                    		"  }\r\n" + 
                    		"]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "", nickname = "generarArchivo", notes = "generar un arhivo con los datos generados en la capacidades anteriores", tags={ "ACMEV1", })
	@RequestMapping(value = "/reporte",
    produces = "application/json", 
    method = RequestMethod.GET)
	default ResponseEntity<Resource> generarArchivo() throws IOException{
		getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
}
