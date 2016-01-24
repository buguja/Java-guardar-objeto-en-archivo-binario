import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Vector;

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
public class ListaAlumno implements Serializable{
	private Vector<Alumno> lista;
	
	public Vector<Alumno> getLista() {
		return lista;
	}

	public ListaAlumno() {
		lista = new Vector<Alumno>();
	}
	
	public void insertaAlumno(Alumno objeto) {
		lista.addElement(objeto);
	}
	
	public boolean eliminaAlumno(Alumno objeto) {
		return lista.remove(objeto);
	}
	
	public boolean eliminaAlumno(String nombreCompleto) {
		StringTokenizer tokens=new StringTokenizer(nombreCompleto,";");
		String apellido=tokens.nextToken();
		String nombre=tokens.nextToken();
		for (int i=0;i<getSize();i++){
			Alumno objeto=buscaAlumno(i);
			if (objeto.getNombre().compareTo(nombre)==0 && objeto.getApellido().compareTo(apellido)==0){
				lista.removeElementAt(i);
				return true;
			}
		}
		return false;
	}
	
	public Alumno buscaAlumno(int posicion){
		return (Alumno)lista.elementAt(posicion);
	}
	public Alumno consultaAlumno(String nombreCompleto){
		StringTokenizer tokens=new StringTokenizer(nombreCompleto,";");
		String apellido=tokens.nextToken();
		String nombre=tokens.nextToken();
		for (int i=0;i<getSize();i++){
			Alumno objeto=buscaAlumno(i);
			if (objeto.getNombre().compareTo(nombre)==0 && objeto.getApellido().compareTo(apellido)==0){
				return objeto;
			}
		}
		return null;
	}
	public int getSize(){
		return lista.size();
	}
}
