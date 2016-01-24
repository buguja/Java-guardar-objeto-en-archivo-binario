import java.io.Serializable;
import java.util.Date;

/*
 * Created on 27/06/2006
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author Manuel Valdes
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Alumno implements Serializable{
	private String nombre;
	private String apellido;
	private int edad;
	private String correo1;
	private String correo2;
	private String direccion;
	private Carrera carrera;
	private Date fecha;
	
	public Alumno() {
		nombre = "";
		apellido = "";
		edad = 0;
		correo1 = "";
		correo2 = "";
		direccion = "";
		carrera = null;
		fecha = null;
	}
	
	public String getApellido() {
		return apellido;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public String getCorreo1() {
		return correo1;
	}

	public String getCorreo2() {
		return correo2;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getEdad() {
		return edad;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) throws AlumnoException {
		if (apellido.matches("([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*)")){
			this.apellido = apellido;
		} else {
			throw new AlumnoException(AlumnoException.APELLIDO);
		}
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public void setCorreo1(String correo1) throws AlumnoException {
		if (correo1.matches("[a-z]([a-z]|[0-9]|_|.)*@[a-z]([a-z]|[0-9]|_|.)*")) {
			this.correo1 = correo1;
		} else {
			throw new AlumnoException(AlumnoException.CORREO1);
		}
	}

	public void setCorreo2(String correo2) throws AlumnoException {
		if (correo2.compareTo("") == 0) {
			this.correo2 = correo2;
		} else if (correo2.matches("[a-z]([a-z]|[0-9]|_|.)*@[a-z]([a-z]|[0-9]|_|.)*")) {
			this.correo2 = correo2;
		} else {
			throw new AlumnoException(AlumnoException.CORREO2);
		}
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setEdad(String edad) throws AlumnoException {
		int edadAux;
		try {
			edadAux = Integer.parseInt(edad);
			setEdad(edadAux);
		} catch(NumberFormatException e) {
			throw new AlumnoException(AlumnoException.EDAD_INCORRECTA);
		}
	}
	
	public void setEdad(int edad) throws AlumnoException {
		if (edad > 0 && edad < 130) {
			this.edad = edad;
		} else {
			throw new AlumnoException(AlumnoException.EDAD_RANGO);
		}
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNombre(String nombre) throws AlumnoException {
		if (nombre.matches("([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*)")) {
			this.nombre = nombre;
		} else {
			throw new AlumnoException(AlumnoException.NOMBRE);
		}
	}

	public String toString() {
		return apellido + ", " + nombre;
	}
}
