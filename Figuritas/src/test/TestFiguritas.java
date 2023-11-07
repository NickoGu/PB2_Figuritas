package test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

import src.Administrador;
import src.CodigoExistente;
import src.Figurita;
import src.FiguritaNoDisponible;
import src.FiguritaRepetida;
import src.Usuario;
import src.UsuarioFinal;

public class TestFiguritas {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);

		assertNotNull(figurita);

	}

	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario admin = new Administrador("Nico");

		assertNotNull(admin);
	}

	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario usuarioFinal = new UsuarioFinal("Nico");

		assertNotNull(usuarioFinal);
	}

	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws CodigoExistente {
		Usuario admin = new Administrador("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);

		admin.agregarFigurita(figurita);

		assertTrue(((Administrador) admin).getFiguritasAlta().contains(figurita));

	}

	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita()throws CodigoExistente {
		Usuario usuarioFinal = new UsuarioFinal("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);

		usuarioFinal.agregarFigurita(figurita);

		assertTrue(((UsuarioFinal) usuarioFinal).getStockFiguritas().contains(figurita));
	}

	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws CodigoExistente{
		Usuario usuarioFinal = new UsuarioFinal("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 10);
		Figurita figurita2 = new Figurita("A", "Argentina", "Aguero", 100000, 9);
		Figurita figurita3 = new Figurita("A", "Argentina", "Dibu", 100000, 1);

		usuarioFinal.agregarFigurita(figurita);
		usuarioFinal.agregarFigurita(figurita2);
		usuarioFinal.agregarFigurita(figurita3);
		
		
		TreeSet<Figurita> figuritasOrdenadas = (TreeSet<Figurita>) ((UsuarioFinal) usuarioFinal).getStockFiguritas();
		
		assertEquals(figurita3, figuritasOrdenadas.first());
		assertEquals(figurita2, figuritasOrdenadas.last());
		
		
	}

	@Test (expected = CodigoExistente.class)
	public void  queUnAdministradorNoPuedaAgregarUnaFiguritaExistente()throws CodigoExistente {
		Usuario admin = new Administrador("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);
		Figurita figurita2 = new Figurita("A", "Argentina", "Messi", 100000, 1);

		admin.agregarFigurita(figurita);
		admin.agregarFigurita(figurita2);

		assertTrue(((Administrador) admin).getFiguritasAlta().contains(figurita));
	}

	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws CodigoExistente {
		Usuario usuarioFinal = new UsuarioFinal("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);
		Figurita figurita2 = new Figurita("A", "Argentina", "Messi", 100000, 1);

		usuarioFinal.agregarFigurita(figurita);

		assertTrue(((UsuarioFinal) usuarioFinal).getStockFiguritas().contains(figurita));
		assertTrue(((UsuarioFinal) usuarioFinal).getStockFiguritas().contains(figurita2));
	}
	
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetida {
		Usuario usuarioFinal = new UsuarioFinal("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);
		
		((UsuarioFinal) usuarioFinal).pegarFigurita(figurita);
		
		
		assertTrue(((UsuarioFinal) usuarioFinal).getFiguritasPegadas().contains(figurita));
	}
		
	@Test (expected = FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida {
		Usuario usuarioFinal = new UsuarioFinal("Nico");
		Figurita figurita = new Figurita("A", "Argentina", "Messi", 100000, 1);
		Figurita figurita2 = new Figurita("A", "Argentina", "Messi", 100000, 1);
		
		((UsuarioFinal) usuarioFinal).pegarFigurita(figurita);
		((UsuarioFinal) usuarioFinal).pegarFigurita(figurita2);
		
		assertTrue(((UsuarioFinal) usuarioFinal).getFiguritasPegadas().contains(figurita));
		assertTrue(((UsuarioFinal) usuarioFinal).getFiguritasPegadas().contains(figurita2));
	
	}
		
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaNoDisponible, CodigoExistente {
		Usuario usuario1 = new UsuarioFinal("Nico");
		Usuario usuario2 = new UsuarioFinal("Martupe");
		Figurita figurita = new Figurita("A", "Argentina", "Dibu", 100000, 1);
		Figurita figurita2 = new Figurita("A", "Argentina", "Messi", 100000, 10);
		
		usuario1.agregarFigurita(figurita);
		usuario2.agregarFigurita(figurita2);
		
		((UsuarioFinal) usuario1).intercambiar(figurita, figurita2);
		((UsuarioFinal) usuario2).intercambiar(figurita2, figurita);
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void  queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws CodigoExistente, FiguritaNoDisponible, FiguritaRepetida {
		Usuario usuario1 = new UsuarioFinal("Nico");
		Usuario usuario2 = new UsuarioFinal("Martupe");
		Figurita figurita = new Figurita("A", "Argentina", "Dibu", 100000, 1);
		Figurita figurita2 = new Figurita("A", "Argentina", "Messi", 100000, 10);
		
		usuario1.agregarFigurita(figurita);
		usuario2.agregarFigurita(figurita2);
		((UsuarioFinal) usuario2).pegarFigurita(figurita2);
		
		((UsuarioFinal) usuario1).intercambiar(figurita, figurita2);
		((UsuarioFinal) usuario2).intercambiar(figurita2, figurita);
	}
//	@Test
//	public void  queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() {
//		fail("Not yet implemented");
//	}
//		

}
