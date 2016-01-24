
public enum Carrera {
	BIOLOGIA ("Licenciatura en Biolog�a"),
	ZOOTECNIA ("Licenciatura en Zootecnia"),
	FORESTAL ("Ingenier�a Forestal"),
	INFORMATICA ("Licenciatura en Inform�tica"),
	ENFERMERIA ("Licenciatura en Enfermer�a");
	
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
