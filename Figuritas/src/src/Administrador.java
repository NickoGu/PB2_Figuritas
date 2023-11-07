package src;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Administrador implements Usuario {

	private String nombre;
	private Set<Figurita> figuritasAlta;
	
	public Administrador(String nombre) {
		this.nombre = nombre;
		this.figuritasAlta = new TreeSet<Figurita>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void agregarFigurita(Figurita figurita) throws CodigoExistente {
		
		if(figuritasAlta.contains(figurita)) {
			throw new CodigoExistente();
		} else {
			figuritasAlta.add(figurita);
		}
		
		
		
	}

	public Set<Figurita> getFiguritasAlta() {
		return figuritasAlta;
	}

	public void setFiguritasAlta(Set<Figurita> figuritasAlta) {
		this.figuritasAlta = figuritasAlta;
	}



	
	
}
