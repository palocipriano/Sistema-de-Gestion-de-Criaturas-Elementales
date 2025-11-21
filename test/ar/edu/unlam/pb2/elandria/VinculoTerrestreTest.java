package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class VinculoTerrestreTest {

    @Test
    public void siLaEnergiaEsMayorA50NoLaModifica() {
        Criatura base =
                new CriaturaDomesticada("Gaia", 80, AfinidadElemental.TIERRA);

        Criatura vinculo = new VinculoTerrestre(base);

        assertEquals(80, vinculo.getEnergia());
    }

    @Test
    public void siLaEnergiaEsMenorA50LaMuestraComo50() {
        Criatura base =
                new CriaturaDomesticada("Gaia", 30, AfinidadElemental.TIERRA);

        Criatura vinculo = new VinculoTerrestre(base);

        assertEquals(50, vinculo.getEnergia());
    }

    @Test
    public void siLaEnergiaBaseCambiaHaciaAbajoSigueMostrandoMinimo50() {
        CriaturaDomesticada base =
                new CriaturaDomesticada("Gaia", 60, AfinidadElemental.TIERRA);
        Criatura vinculo = new VinculoTerrestre(base);

        assertEquals(60, vinculo.getEnergia());

        base.entrenar(-20);

        assertEquals(50, vinculo.getEnergia());
    }
}

