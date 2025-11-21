package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class CriaturaDomesticaTest {

    @Test
    public void alCrearUnaCriaturaDomesticadaQuedaTranquila() {
        CriaturaDomesticada criatura =
                new CriaturaDomesticada("Lumi", 80, AfinidadElemental.AGUA);

        assertEquals("Lumi", criatura.getNombre());
        assertEquals(80, criatura.getEnergia());
        assertEquals(AfinidadElemental.AGUA, criatura.getAfinidad());
        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
    }

    @Test
    public void alEntrenarSumaEnergiaYPermanenceTranquila() {
        CriaturaDomesticada criatura =
                new CriaturaDomesticada("Lumi", 100, AfinidadElemental.AGUA);

        criatura.entrenar(30);

        assertEquals(130, criatura.getEnergia());
        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
    }

    @Test
    public void alEntrenarMuchoNoSupera200YNuncaSeVuelveInestable() {
        CriaturaDomesticada criatura =
                new CriaturaDomesticada("Lumi", 190, AfinidadElemental.AGUA);

        criatura.entrenar(50); // intenta pasar de 200

        assertEquals(200, criatura.getEnergia()); // tope
        assertEquals(EstadoEmocional.TRANQUILO, criatura.getEstado());
    }
}
