package modelo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
	
	private Connection con;
	
	public UsuarioModel() {
		con = ConexionDB.getConexion();
	}

	public boolean existeUsuario(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getUsuarios() {
		List<String> usuarios = new ArrayList<String>();
		
		usuarios.add("David");
		usuarios.add("Sergio");
		
		return usuarios;
	}

}
