package ventana;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAntecedentes extends JPanel {
	private JTextField textField_Antecedentes;

	/**
	 * Create the panel.
	 */
	public PanelAntecedentes() {
		setLayout(null);
		
		JLabel lblAntecedentes = new JLabel("Antecedentes");
		lblAntecedentes.setBounds(10, 23, 81, 14);
		add(lblAntecedentes);
		
		textField_Antecedentes = new JTextField();
		textField_Antecedentes.setBounds(10, 68, 418, 178);
		add(textField_Antecedentes);
		textField_Antecedentes.setColumns(10);
		
		JButton salvar_Button = new JButton("Salvar >>");
		salvar_Button.setBounds(10, 266, 106, 23);
		add(salvar_Button);

	}

}
