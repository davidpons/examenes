package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.ConexionDB;

public class ConexionDB {
				
	//DATOS DE LA BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//Conexion
	private static Connection conexion = null;// maneja la conexió
	
	public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		
		
		conectarDB();
	}
	
	public boolean conectarDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conexion = DriverManager.getConnection(this.url,this.user,this.pass);
			
			
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
		return conexion;
	}
		
}

