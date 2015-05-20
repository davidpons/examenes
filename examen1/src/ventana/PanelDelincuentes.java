package ventana;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDelincuentes extends JPanel {
	private JTextField textField_Nombre;
	private JTextField textField_Edad;
	private JTextField textField_Sexo;
	private JTextField textField_Nacionalidad;
	private JTextField textField_Dirección;
	private JTextField textField_Población;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JLabel lblNacionalidad;
	private JLabel lblDireccin;
	private JLabel lblPoblacin;
	private JList list_Delincuentes;
	private JButton btnAntecendentes;

	/**
	 * Create the panel.
	 */
	public PanelDelincuentes() {
		setLayout(null);
		
		list_Delincuentes = new JList();
		list_Delincuentes.setBounds(42, 40, 146, 228);
		add(list_Delincuentes);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(259, 38, 146, 20);
		add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(259, 21, 46, 14);
		add(lblNombre);
		
		textField_Edad = new JTextField();
		textField_Edad.setBounds(259, 83, 72, 20);
		add(textField_Edad);
		textField_Edad.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(259, 69, 46, 14);
		add(lblEdad);
		
		textField_Sexo = new JTextField();
		textField_Sexo.setBounds(341, 83, 66, 20);
		add(textField_Sexo);
		textField_Sexo.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(341, 69, 46, 14);
		add(lblSexo);
		
		textField_Nacionalidad = new JTextField();
		textField_Nacionalidad.setColumns(10);
		textField_Nacionalidad.setBounds(259, 131, 146, 20);
		add(textField_Nacionalidad);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(259, 114, 72, 14);
		add(lblNacionalidad);
		
		textField_Dirección = new JTextField();
		textField_Dirección.setColumns(10);
		textField_Dirección.setBounds(259, 180, 146, 20);
		add(textField_Dirección);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(259, 162, 46, 14);
		add(lblDireccin);
		
		textField_Población = new JTextField();
		textField_Población.setColumns(10);
		textField_Población.setBounds(259, 226, 146, 20);
		add(textField_Población);
		
		lblPoblacin = new JLabel("Población");
		lblPoblacin.setBounds(259, 211, 46, 14);
		add(lblPoblacin);
		
		btnAntecendentes = new JButton("Antecedentes >>");
		btnAntecendentes.setBounds(259, 266, 146, 23);
		add(btnAntecendentes);
	
	}
}
