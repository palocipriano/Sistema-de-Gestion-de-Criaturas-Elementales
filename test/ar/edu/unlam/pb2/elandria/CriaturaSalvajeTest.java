package ar.edu.unlam.pb2.elandria;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturaSalvajeTest {

	 @Test
	    public void alCrearUnaCriaturaSalvajeSeInicializaCorrectamente() {
	        CriaturaSalvaje criatura =
	                new CriaturaSalvaje("Drako", 150, AfinidadElemental.FUEGO);

	        assertEquals("Drako", criatura.getNombre());
	        assertEquals(150, criatura.getEnergia());
	        assertEquals(AfinidadElemental.FUEGO, criatura.getAfinidad());
	        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
	    }

	    @Test
	    public void entrenarIncrementaLaEnergiaSiNoSuperaElMaximo() {
	        CriaturaSalvaje criatura =
	                new CriaturaSalvaje("Drako", 180, AfinidadElemental.FUEGO);

	        criatura.entrenar(10);

	        assertEquals(190, criatura.getEnergia());
	    }

	    @Test(expected = EnergiaDesbordadaExcepcion.class)
	    public void entrenarLanzaExcepcionSiLaEnergiaSupera200() {
	        CriaturaSalvaje criatura =
	                new CriaturaSalvaje("Drako", 195, AfinidadElemental.FUEGO);

	        criatura.entrenar(10);
	    }
}
