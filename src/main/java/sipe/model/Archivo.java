package sipe.model;

public class Archivo {
	private String nombre;
	private String path;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Archivo [nombre=" + nombre + ", path=" + path + "]";
	}
	
	
}