package ventana;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import modelo.Delincuente;
import modelo.DelincuenteModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAntecedentes extends JPanel {
	private JTextField antecedentesTextField;
	
	private DelincuenteModel modelo;

	private Delincuente delincuente;

	/**
	 * Create the panel.
	 */
	public PanelAntecedentes() {
		setLayout(null);
		
		JLabel lblAntecedentes = new JLabel("Antecedentes");
		lblAntecedentes.setBounds(10, 23, 81, 14);
		add(lblAntecedentes);
		
		antecedentesTextField = new JTextField();
		antecedentesTextField.setBounds(10, 68, 418, 178);
		add(antecedentesTextField);
		antecedentesTextField.setColumns(10);
		
		JButton salvar_Button = new JButton("Salvar >>");
		salvar_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelo.salvarAntecedentes(antecedentesTextField.getText(), delincuente.getId());
			}
		});
		salvar_Button.setBounds(10, 266, 106, 23);
		add(salvar_Button);

	}

	public void setDelincuente(Delincuente deliSeleccionado) {
		this.delincuente = deliSeleccionado;
		
		antecedentesTextField.setText(delincuente.getAntecedentes());
	}

	public void setModelo(DelincuenteModel delincuenteModel) {
		this.modelo = delincuenteModel;
		
	}

}
