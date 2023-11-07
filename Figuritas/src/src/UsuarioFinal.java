package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal implements Usuario {

	private String nombre;
	private Set<Figurita> stockFiguritas;
	private Set<Figurita> figuritasPegadas;
	
	public UsuarioFinal(String nombre) {
		this.nombre = nombre;
		this.stockFiguritas = new TreeSet<Figurita>();
		this.figuritasPegadas = new HashSet<Figurita>();
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
	
	public void pegarFigurita(Figurita figurita) throws FiguritaRepetida {
		if(figuritasPegadas.contains(figurita)) {
			throw new FiguritaRepetida();
		} else {
			figuritasPegadas.add(figurita);
			stockFiguritas.remove(figurita);
		}
	}

	public Set<Figurita> getFiguritasPegadas() {
		return figuritasPegadas;
	}

	public void setFiguritasPegadas(Set<Figurita> figuritasPegadas) {
		this.figuritasPegadas = figuritasPegadas;
	}
	
	
	public void intercambiar(Figurita figurita, Figurita figurita2) throws FiguritaNoDisponible {
		if(stockFiguritas.contains(figurita)) {
			stockFiguritas.remove(figurita);
			stockFiguritas.add(figurita2);
		} else {
			throw new FiguritaNoDisponible();
		}
	}
	
	


}
