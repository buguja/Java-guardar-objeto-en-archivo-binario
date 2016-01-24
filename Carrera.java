
public enum Carrera {
	BIOLOGIA ("Licenciatura en Biología"),
	ZOOTECNIA ("Licenciatura en Zootecnia"),
	FORESTAL ("Ingeniería Forestal"),
	INFORMATICA ("Licenciatura en Informática"),
	ENFERMERIA ("Licenciatura en Enfermería");
	
	private final String nombreCarrera;
	
	private Carrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	
	public String getCarrera() {
		return nombreCarrera;
	}
	
	public String toString() {
		return getCarrera();
	}
}
