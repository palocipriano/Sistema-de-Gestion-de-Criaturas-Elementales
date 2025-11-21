package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class CriaturaAncestralTest {

    @Test
    public void alCrearUnaAncestralSuEnergiaNoBajaDe100() {
        CriaturaAncestral criatura =
                new CriaturaAncestral("Aeris", 80, AfinidadElemental.AIRE);

        assertEquals(100, criatura.getEnergia());
        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
    }

    @Test
    public void entrenarConCambioSuaveRespetaRangoYPermaneceTranquila() {
        CriaturaAncestral criatura =
                new CriaturaAncestral("Aeris", 120, AfinidadElemental.AIRE);

        criatura.entrenar(20);

        assertEquals(140, criatura.getEnergia());
        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
    }

    @Test
    public void entrenarDeFormaExtremaLaVuelveInestableYPersisteEntre100y200() {
        CriaturaAncestral criatura =
                new CriaturaAncestral("Aeris", 150, AfinidadElemental.AIRE);

        criatura.entrenar(100);

        assertTrue(criatura.getEnergia() >= 100 && criatura.getEnergia() <= 200);
        assertEquals(EstadoEmocional.INESTABLE, criatura.getEstado());
    }

    @Test
    public void nuncaPuedeQuedarConEnergiaMenorA100AunqueElEntrenamientoSeaNegativo() {
        CriaturaAncestral criatura =
                new CriaturaAncestral("Aeris", 120, AfinidadElemental.AIRE);

        criatura.entrenar(-50);

        assertEquals(100, criatura.getEnergia());
    }
}
