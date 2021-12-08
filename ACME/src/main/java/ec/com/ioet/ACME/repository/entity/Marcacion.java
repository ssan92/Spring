package ec.com.ioet.ACME.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Santiago
 * */

@Entity
@Table(name = "Marcacion")
@NamedNativeQuery(name = "Marcacion.consultaMarcacionbyFechas",query = "SELECT m.* FROM MARCACION  m where trunc(m.fecha_entrada)>=to_date(?1,'YYYY-MM-DD') and trunc(m.fecha_salida)<=to_date(?2,'YYYY-MM-DD') order by m.id_empleado, m.fecha_entrada ",resultClass = Marcacion.class)
@NamedNativeQuery(name = "Marcacion.consultaMarcacionbyFechaYempleado",query = "SELECT * FROM MARCACION  m where ?1 between  m.fecha_entrada and m.fecha_salida and m.id_empleado!=?2 order by id_empleado ",resultClass = Marcacion.class)
public class Marcacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marcacion")
	private Long idMarcacion;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
	private Empleado empleado;
	
	@Column(name="fecha_entrada")
	private Date fechaEntrada;
	
	@Column(name="fecha_salida")
	private Date fechaSalida;
	
	public Long getIdMarcacion() {
		return idMarcacion;
	}
	public void setIdMarcacion(Long idMarcacion) {
		this.idMarcacion = idMarcacion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	

}
