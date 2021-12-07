package ec.com.ioet.ACME.controller.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ec.com.ioet.ACME.service.dto.EmpleadoDTO;
import ec.com.ioet.ACME.service.dto.MarcacionDTO;

@SpringBootTest
@AutoConfigureMockMvc
class EmpleadoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ObjectMapper objectMapper;

	private File gestionJson;
	private File gestionErroneoJson;
	
	HttpHeaders headers;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.headers = new HttpHeaders();
		this.headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.txt");
		this.headers.set("Cache-Control","no-cache, no-store, must-revalidate");
		this.headers.set("Pragma","no-cache");
		this.headers.set("Expires","0");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.gestionJson = new File("src/test/resources/gestion.json");
		this.gestionErroneoJson = new File("src/test/resources/gestionErroneo.json");
	}

	@AfterEach
	void tearDown() throws Exception {
		this.mockMvc = null;
		this.headers = null;
	}
	
	@Test
	void testcrearEmpleadoConMarcaciones() throws JsonProcessingException, Exception {
		List<MarcacionDTO> list=new ArrayList<MarcacionDTO>();
		MarcacionDTO marcaciones=new MarcacionDTO();
		marcaciones.setIdMarcacion(Long.valueOf("0"));
		marcaciones.setFechaEntrada(new Date());
		marcaciones.setFechaSalida(new Date());
		list.add(marcaciones);
		EmpleadoDTO dto=new EmpleadoDTO();
		dto.setIdEmpleado(Long.valueOf("0"));
		dto.setNombre("Santiago");
		dto.setMarcaciones(list);
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/empleado")
				.content(objectMapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				//.headers(this.headers)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	void testconsultaMarcacionbyFecha() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/marcacion/2021-12-06/2021-12-12")
				//.headers(this.headers)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testgenerarArchivoFecha() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/reporte")
				.headers(this.headers)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
