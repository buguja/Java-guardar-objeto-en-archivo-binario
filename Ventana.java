import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

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
public class Ventana extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8374764018966087135L;
	private JTextField nombreCampo;
	private JTextField apellidoCampo;
	private JTextField edadCampo;
	private JTextField correo1Campo;
	private JTextField correo2Campo;
	private JTextField direccionCampo;
	private JDateChooser fechaCampo;
	private JComboBox<Alumno> alumnoCombo;
	private JComboBox<Carrera> carreraCombo;
	private JButton nuevoBoton;
	private JButton modificarBoton;
	private JButton eliminarBoton;
	private JButton guardarBoton;
	private JButton cancelarBoton;
	private JButton anteriorBoton;
	private JButton siguienteBoton;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private ListaAlumno lista;
	private boolean esNuevo;

	public Ventana() {
		super("Manejo de Alumnos");
		setSize(450, 350);
		setLocation(100, 100);
		Container contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout(5, 5));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter () { 
			public void windowClosing(WindowEvent e) { 
				respaldar();
				System.exit(0);
			}
		} );
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(9, 2, 10, 10));
		panel1.add(new JLabel("Alumnos:"));
		alumnoCombo = new JComboBox<Alumno>();
		panel1.add(alumnoCombo);
		panel1.add(new JLabel("Nombre:"));
		nombreCampo = new JTextField();
		panel1.add(nombreCampo);
		panel1.add(new JLabel("Apellidos:"));
		apellidoCampo = new JTextField();
		panel1.add(apellidoCampo);
		panel1.add(new JLabel("Edad:"));
		edadCampo = new JTextField();
		panel1.add(edadCampo);
		panel1.add(new JLabel("Correo 1:"));
		correo1Campo = new JTextField();
		panel1.add(correo1Campo);
		panel1.add(new JLabel("Correo 2:"));
		correo2Campo = new JTextField();
		panel1.add(correo2Campo);
		panel1.add(new JLabel("Dirección:"));
		direccionCampo = new JTextField();
		panel1.add(direccionCampo);
		panel1.add(new JLabel("Carrera:"));
		carreraCombo = new JComboBox<Carrera>(Carrera.values());
		panel1.add(carreraCombo);
		panel1.add(new JLabel("Fecha Nacimiento:"));
		fechaCampo = new JDateChooser(new Date());
		panel1.add(fechaCampo);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 1, 10, 20));
		nuevoBoton = new JButton("Nuevo");
		modificarBoton = new JButton("Modificar");
		eliminarBoton = new JButton("Eliminar");
		guardarBoton = new JButton("Guardar");
		cancelarBoton = new JButton("Cancelar");
		panel2.add(nuevoBoton);
		panel2.add(modificarBoton);
		panel2.add(eliminarBoton);
		panel2.add(guardarBoton);
		panel2.add(cancelarBoton);
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		anteriorBoton = new JButton("Anterior");
		siguienteBoton = new JButton("Siguiente");
		panel3.add(anteriorBoton);
		panel3.add(siguienteBoton);
		
		contenedor.add(panel1, BorderLayout.CENTER);
		contenedor.add(panel2, BorderLayout.EAST);
		contenedor.add(panel3, BorderLayout.SOUTH);

		alumnoCombo.setEditable(false);
		carreraCombo.setEditable(false);
		
		nombreCampo.setEditable(false);
		apellidoCampo.setEditable(false);
		edadCampo.setEditable(false);
		correo1Campo.setEditable(false);
		correo2Campo.setEditable(false);
		direccionCampo.setEditable(false);
		carreraCombo.setEnabled(false);
		fechaCampo.setEnabled(false);
		guardarBoton.setEnabled(false);
		cancelarBoton.setEnabled(false);

		alumnoCombo.addActionListener(this);
		nuevoBoton.addActionListener(this);
		modificarBoton.addActionListener(this);
		eliminarBoton.addActionListener(this);
		guardarBoton.addActionListener(this);
		cancelarBoton.addActionListener(this);
		anteriorBoton.addActionListener(this);
		siguienteBoton.addActionListener(this);
				
		recuperar();
		llenarCombo();
		inicializaVentana();
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ventana();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(nuevoBoton)) {
			nuevo();
		} else if (e.getSource().equals(modificarBoton)) {		
			modificar();
		} else if (e.getSource().equals(eliminarBoton)) {
			eliminar();
		} else if (e.getSource().equals(guardarBoton)) {
			guardar();		
		} else if (e.getSource().equals(cancelarBoton)) {		
			cancelar();
		} else if (e.getSource().equals(anteriorBoton)) {
			anterior();
		} else if (e.getSource().equals(siguienteBoton)) {		
			siguiente();
		} else if (e.getSource().equals(alumnoCombo)) {
			mostrar();		
		}
	}
	
	private void mostrar() {
		Alumno alumno = (Alumno) alumnoCombo.getSelectedItem();
		if (alumno != null) {
			nombreCampo.setText(alumno.getNombre());
			apellidoCampo.setText(alumno.getApellido());
			edadCampo.setText(String.valueOf(alumno.getEdad()));
			correo1Campo.setText(alumno.getCorreo1());
			correo2Campo.setText(alumno.getCorreo2());
			direccionCampo.setText(alumno.getDireccion());
			carreraCombo.setSelectedItem(alumno.getCarrera());
			fechaCampo.setDate(alumno.getFecha());
		}
	}
	
	private void siguiente() {
		int posicion = alumnoCombo.getSelectedIndex();
		if (posicion < (lista.getSize() - 1)) {
			alumnoCombo.setSelectedIndex(posicion + 1);						
		} else {
			alumnoCombo.setSelectedIndex(0);
		}
	}
	
	private void anterior() {
		int posicion = alumnoCombo.getSelectedIndex();
		if (posicion > 0) {
			alumnoCombo.setSelectedIndex(posicion - 1);						
		} else {
			alumnoCombo.setSelectedIndex(lista.getSize() - 1);
		}
	}
	
	private void cancelar() {
		nombreCampo.setEditable(false);
		apellidoCampo.setEditable(false);
		edadCampo.setEditable(false);
		correo1Campo.setEditable(false);
		correo2Campo.setEditable(false);
		direccionCampo.setEditable(false);
		carreraCombo.setEnabled(false);
		fechaCampo.setEnabled(false);
		guardarBoton.setEnabled(false);
		cancelarBoton.setEnabled(false);
		nuevoBoton.setEnabled(true);
		inicializaVentana();
	}
	
	private void guardar() {
		Alumno alumno;
		if (esNuevo) {
			alumno = new Alumno();
		} else {
			alumno = (Alumno) alumnoCombo.getSelectedItem();
		}
		try {
			alumno.setNombre(nombreCampo.getText());
			alumno.setApellido(apellidoCampo.getText());
			alumno.setEdad(edadCampo.getText());
			alumno.setCorreo1(correo1Campo.getText());
			alumno.setCorreo2(correo2Campo.getText());
			alumno.setDireccion(direccionCampo.getText());
			alumno.setCarrera((Carrera) carreraCombo.getSelectedItem());
			alumno.setFecha(fechaCampo.getDate());
			if (esNuevo) {
				lista.insertaAlumno(alumno);
				alumnoCombo.addItem(alumno);
				JOptionPane.showMessageDialog(this, "El alumno " + alumno.toString() + " se ha agregado con éxito", "Nuevo alumno", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "El alumno " + alumno.toString() + " se ha modificado con éxito", "Modificar alumno", JOptionPane.INFORMATION_MESSAGE);
			}
			cancelarBoton.doClick();
		} catch (AlumnoException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), e.getTitulo(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void eliminar() {
		Alumno alumno = (Alumno) alumnoCombo.getSelectedItem();
		if (JOptionPane.showConfirmDialog(this, "¿Desea Eliminar a " + alumno.toString(), "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			if (lista.eliminaAlumno(alumno)) {
				alumnoCombo.removeItem(alumno);
				limpiaCampos();
				inicializaVentana();
				JOptionPane.showMessageDialog(this, "Alumno eliminado con éxito", "Eliminar alumno", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo eliminar el alumno", "Eliminar alumno", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void modificar() {
		nombreCampo.setEditable(true);
		apellidoCampo.setEditable(true);
		edadCampo.setEditable(true);
		correo1Campo.setEditable(true);
		correo2Campo.setEditable(true);
		direccionCampo.setEditable(true);
		carreraCombo.setEnabled(true);
		fechaCampo.setEnabled(true);
		guardarBoton.setEnabled(true);
		cancelarBoton.setEnabled(true);
		alumnoCombo.setEnabled(false);
		nuevoBoton.setEnabled(false);
		modificarBoton.setEnabled(false);
		eliminarBoton.setEnabled(false);
		anteriorBoton.setEnabled(false);
		siguienteBoton.setEnabled(false);
		esNuevo = false;
	}
	
	private void nuevo() {
		nombreCampo.setEditable(true);
		apellidoCampo.setEditable(true);
		edadCampo.setEditable(true);
		correo1Campo.setEditable(true);
		correo2Campo.setEditable(true);
		direccionCampo.setEditable(true);
		carreraCombo.setEnabled(true);
		fechaCampo.setEnabled(true);
		guardarBoton.setEnabled(true);
		cancelarBoton.setEnabled(true);
		alumnoCombo.setEnabled(false);
		nuevoBoton.setEnabled(false);
		modificarBoton.setEnabled(false);
		eliminarBoton.setEnabled(false);
		anteriorBoton.setEnabled(false);
		siguienteBoton.setEnabled(false);
		limpiaCampos();
		esNuevo = true;
	}
	
	private void inicializaVentana() {
		if (lista.getSize() != 0) {
			alumnoCombo.setEnabled(true);
			modificarBoton.setEnabled(true);
			eliminarBoton.setEnabled(true);
			anteriorBoton.setEnabled(true);
			siguienteBoton.setEnabled(true);
			alumnoCombo.setSelectedIndex(0);
		} else {
			alumnoCombo.setEnabled(false);
			modificarBoton.setEnabled(false);
			eliminarBoton.setEnabled(false);
			anteriorBoton.setEnabled(false);
			siguienteBoton.setEnabled(false);
		}
	}
	
	private void limpiaCampos() {
		nombreCampo.setText("");
		apellidoCampo.setText("");
		edadCampo.setText("");
		correo1Campo.setText("");
		correo2Campo.setText("");
		direccionCampo.setText("");
		fechaCampo.setDate(new Date());
		carreraCombo.setSelectedIndex(0);
	}
	
	private void llenarCombo() {
		for (Alumno a : lista.getLista()) {
			alumnoCombo.addItem(a);
		}
	}

	private void respaldar() { //implementación de la práctica
		guardarDatos();
	}
	
	private void guardarDatos(){ //implementación de la práctica
		try(
			FileOutputStream fos= new FileOutputStream("datos.txt");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
		){
			oos.writeObject(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Problema de escritura: " + e.getMessage());
		}
	}
	
	private void recuperar() { //implementación de la práctica
		if(lista == null){
			try(
					FileInputStream fis= new FileInputStream("datos.txt");
					ObjectInputStream ois= new ObjectInputStream(fis);
				){
					lista= (ListaAlumno) ois.readObject();
					//lista= ois.readObject();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					lista= new ListaAlumno();
					guardarDatos();
					JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + e.getMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					lista= new ListaAlumno();
					guardarDatos();
					JOptionPane.showMessageDialog(null, "Problema de escritura: " + e.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					lista= new ListaAlumno();
					guardarDatos();
					JOptionPane.showMessageDialog(null, "Problema de escritura: " + e.getMessage());
				}
		}
	}
}
