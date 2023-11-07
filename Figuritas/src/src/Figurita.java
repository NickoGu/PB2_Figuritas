package src;

import java.util.Objects;

public class Figurita implements Comparable<Figurita> {

	private String letraGrupo;
	private String seleccion;
	private String nombre;
	private Integer valor;
	private String identificadorUnico;
	private Integer numeroFigurita;

	public Figurita(String letraGrupo, String seleccion, String nombre, int valor, int numeroFigurita) {
		this.letraGrupo = letraGrupo;
		this.seleccion = seleccion;
		this.nombre = nombre;
		this.valor = valor;
		this.numeroFigurita = numeroFigurita;
		this.identificadorUnico = this.seleccion + this.numeroFigurita;
	}

	public String getLetraGrupo() {
		return letraGrupo;
	}

	public void setLetraGrupo(String letraGrupo) {
		this.letraGrupo = letraGrupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getIdentificadorUnico() {
		return identificadorUnico;
	}

	public void setIdentificadorUnico() {
		this.identificadorUnico = this.seleccion + this.numeroFigurita;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(identificadorUnico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(identificadorUnico, other.identificadorUnico);
	}

	@Override
	public int compareTo(Figurita o) {
		
		return identificadorUnico.compareTo(o.identificadorUnico);
	}

}
