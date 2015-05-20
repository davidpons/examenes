package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
				
	private String user;   //Guarda el nombre del usuario con que nos conectaremos.
	private String bbdd;  //Guarda el nombre de la bd a la que nos conectamos.
	private String url;  // Guarda la direccion de la bd.
	private String pass;// Guarda el pass con el que accedemos.
	
	private static Connection con; //Describe una conexión (puente entre App Java y BD) 
	
	/**
	 * Constructor por defecto/sin parametros.
	 */
	public ConexionDB(){
		this.url="jdbc:mysql://localhost:3306/delincuentes";
		this.user="root";
		this.pass="";
		this.bbdd="delincuentes";
	}
	
	public boolean conectarDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			this.con = DriverManager.getConnection(url,user,pass);
			
			
		} catch (ClassNotFoundException noEncuentroClase) {
			// TODO Auto-generated catch block
			noEncuentroClase.printStackTrace();
			
			return false;
		} catch (SQLException errorAlConectar) {
			// TODO Auto-generated catch block
			errorAlConectar.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	public static Connection getConexion(){
		return con;
	}
		
}
