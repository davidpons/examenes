package modelo;

public class Delincuente {

	private int id;
	private String nombre;
	private String edad;
	private String sexo;
	private String nacionalidad;
	private String direccion;
	private String poblacion;
	private String antecedentes;
	

	public Delincuente(int id, String nombre, String edad, String sexo,
			String nacionalidad, String direccion, String poblacion, String antecedentes) {
		this.setId(id);
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.nacionalidad=nacionalidad;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.setAntecedentes(antecedentes);
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getEdad() {
		// TODO Auto-generated method stub
		return edad;
	}

	public String getSexo() {
		// TODO Auto-generated method stub
		return sexo;
	}

	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return nacionalidad;
	}

	public String getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}

	public String getPoblacion() {
		// TODO Auto-generated method stub
		return poblacion;
	}
	
	@Override
	public String toString() {
		
		return nombre;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
