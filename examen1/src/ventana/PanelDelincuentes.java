package ventana;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import modelo.Delincuente;
import modelo.DelincuenteModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDelincuentes extends JPanel {
	private JTextField nombreTextField;
	private JTextField edadTextField;
	private JTextField sexoTextField;
	private JTextField nacionalidadTextField;
	private JTextField direccionTextField;
	private JTextField poblacionTextField;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JLabel lblNacionalidad;
	private JLabel lblDireccin;
	private JLabel lblPoblacion;
	private JList delincuentesJList;
	private JButton btnAntecendentes;
	private JScrollPane delincuentesJScrollPane;
	
	private Delincuente deliSeleccionado;
	
	private VentanaPrincipal principal;
	private PanelAntecedentes panelAntecedentes;
	private DelincuenteModel delincuenteModel;

	/**
	 * Create the panel.
	 */
	public PanelDelincuentes(VentanaPrincipal prin, PanelAntecedentes panelAnt) {
		setLayout(null);
		this.principal = prin;
		this.panelAntecedentes = panelAnt;
				
		delincuenteModel = new DelincuenteModel();
		
		Delincuente[] delincuentes = delincuenteModel.getDelincuentes();
		delincuentesJList = new JList(delincuentes);
		
		
		delincuentesJList.addListSelectionListener(new ListSelectionListener() {
			private int INDICE_MOSTRADO = -1;
			
			public void valueChanged(ListSelectionEvent e) {
				//TODO: Programar que se actualicen todos los campos de la parte derecha.
				if(e.getLastIndex()!=INDICE_MOSTRADO){
					
					deliSeleccionado = (Delincuente) delincuentesJList.getSelectedValue();
					refrescarDelincuente(deliSeleccionado);
				}
								
				INDICE_MOSTRADO = delincuentesJList.getSelectedIndex();
			}
			
			private void refrescarDelincuente(Delincuente del){
				nombreTextField.setText(del.getNombre());
				edadTextField.setText(del.getEdad());
				sexoTextField.setText(del.getSexo());
				nacionalidadTextField.setText(del.getNacionalidad());
				direccionTextField.setText(del.getDireccion());
				poblacionTextField.setText(del.getPoblacion());
			}
		});
		
		delincuentesJList.setBounds(64, 38, 125, 144);		
		delincuentesJList.setVisibleRowCount(6);
		delincuentesJScrollPane = new JScrollPane(delincuentesJList);
		delincuentesJScrollPane.setBounds(64, 38, 125, 100);
		
		add(delincuentesJScrollPane);
		
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(259, 38, 146, 20);
		add(nombreTextField);
		nombreTextField.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(259, 21, 89, 14);
		add(lblNombre);
		
		edadTextField = new JTextField();
		edadTextField.setBounds(259, 83, 72, 20);
		add(edadTextField);
		edadTextField.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(259, 69, 64, 14);
		add(lblEdad);
		
		sexoTextField = new JTextField();
		sexoTextField.setBounds(341, 83, 66, 20);
		add(sexoTextField);
		sexoTextField.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(341, 69, 64, 14);
		add(lblSexo);
		
		nacionalidadTextField = new JTextField();
		nacionalidadTextField.setColumns(10);
		nacionalidadTextField.setBounds(259, 131, 146, 20);
		add(nacionalidadTextField);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(259, 114, 128, 14);
		add(lblNacionalidad);
				
		direccionTextField = new JTextField();
		direccionTextField.setColumns(10);
		direccionTextField.setBounds(259, 180, 146, 20);
		add(direccionTextField);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(259, 162, 128, 14);
		add(lblDireccin);
		
		poblacionTextField = new JTextField();
		poblacionTextField.setColumns(10);
		poblacionTextField.setBounds(259, 226, 146, 20);
		add(poblacionTextField);
		
		lblPoblacion = new JLabel("Población");
		lblPoblacion.setBounds(259, 211, 128, 14);
		add(lblPoblacion);
		
		btnAntecendentes = new JButton("Antecedentes >>");
		btnAntecendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO: Accedes al delincuente seleccionado.
				
				if(deliSeleccionado!=null)
					visualizarPanelAntecedentes();
			}
		});
		btnAntecendentes.setBounds(259, 266, 146, 23);
		add(btnAntecendentes);
	
	}
	
	private void visualizarPanelAntecedentes(){
		panelAntecedentes.setDelincuente(deliSeleccionado);
		panelAntecedentes.setModelo(delincuenteModel);
		principal.getContentPane().remove(this);
		principal.getContentPane().add(panelAntecedentes);
		principal.getContentPane().validate();
	}
}
