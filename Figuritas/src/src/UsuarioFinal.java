package src;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal implements Usuario {

	private String nombre;
	private Set<Figurita> stockFiguritas;

	public UsuarioFinal(String nombre) {
		this.nombre = nombre;
		this.stockFiguritas = new TreeSet<Figurita>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void agregarFigurita(Figurita figurita) {
		stockFiguritas.add(figurita);
		
	}

	public Set<Figurita> getStockFiguritas() {
		return stockFiguritas;
	}

	public void setStockFiguritas(Set<Figurita> stockFiguritas) {
		this.stockFiguritas = stockFiguritas;
	}

	
	
	


}
