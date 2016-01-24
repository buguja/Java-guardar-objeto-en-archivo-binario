

public class AlumnoException extends Exception {
	private static final long serialVersionUID = -6166277717034919830L;
	
	public static final String[] APELLIDO = {"El sistema sólo admite letras y espacios en el apellido", "Error en apellido"};
	public static final String[] NOMBRE = {"El sistema sólo admite letras y espacios en el nombre", "Error en nombre"};
	public static final String[] EDAD_RANGO = {"La edad debe ser un valor entre 1 y 130", "Error en edad"};
	public static final String[] CORREO1 = {"El formato del correo 1 es inválido, \nEjemplo de correo: cuenta@dominio", "Error en correo"};
	public static final String[] CORREO2 = {"El formato del correo 2 es inválido, \nEjemplo de correo: cuenta@dominio", "Error en correo"};
	public static final String[] EDAD_INCORRECTA = {"La edad debe ser un número entero", "Error en edad"};

	private String titulo;
	
	public AlumnoException(String msg) {
		super(msg);
		setTitulo("Error en Alumno");
	}
	
	public AlumnoException(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
