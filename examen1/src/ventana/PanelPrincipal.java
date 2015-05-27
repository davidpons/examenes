package ventana;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import modelo.ConexionDB;
import modelo.UsuarioModel;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class PanelPrincipal extends JPanel {
	private JTextField contrase�a;
	private JComboBox usuariosDesplegable;
	private JButton logInButton;
	private Component logOutButton;
	private UsuarioModel usuariosModel;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		String HOST="localhost";
		String BBDD="delincuentes";
		String USER="root";
		String PASS="";
		ConexionDB conBD = new ConexionDB(HOST, BBDD, USER, PASS);
		
		ConexionDB usuariosDb = new ConexionDB("localhost", "delincuentes", "root", "");
		
		setLayout(null);
		
		usuariosDesplegable = new JComboBox();
		usuariosDesplegable.setBounds(55, 65, 107, 20);
		add(usuariosDesplegable);
		
		usuariosModel = new UsuarioModel();
		
		Iterator<String> it = this.usuariosModel.getUsuarios().iterator();
		
		while(it.hasNext()){
			String usuario = it.next();
			usuariosDesplegable.addItem(usuario);
		}
		
		contrase�a = new JTextField();
		contrase�a.setBounds(55, 106, 110, 20);
		add(contrase�a);
		contrase�a.setColumns(10);
		
		logInButton = new JButton("LogIn");
		logInButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if("".equals(contrase�a.getText())){
					//mostramos el mensaje de error
					JOptionPane.showMessageDialog(null, "No existe contrase�a", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					String usuario=obtenerUsuarioSeleccionado();					
					
					boolean existeUsuario = usuariosModel.existeUsuario(usuario,contrase�a.getText());
					
					if(existeUsuario){
						logInButton.setEnabled(false);
						logOutButton.setEnabled(true);
					}else{
						JOptionPane.showMessageDialog(null, "Usuario no valido", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		logInButton.setBounds(55, 157, 107, 23);
		add(logInButton);
		
		logOutButton = new JButton("LogOut");
		logOutButton.setBounds(55, 191, 107, 23);
		add(logOutButton);
	}			
	
	private String obtenerUsuarioSeleccionado() {
		// TODO Auto-generated method stub
		return (String) usuariosDesplegable.getSelectedItem();
	}
		
}
