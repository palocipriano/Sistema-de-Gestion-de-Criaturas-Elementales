package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class BendicionDelRioTest {

    @Test
    public void duplicaLaEnergiaSinSuperar180() {
        Criatura base =
                new CriaturaDomesticada("Lumi", 80, AfinidadElemental.AGUA);

        Criatura bendecida = new BendicionDelRio(base);

        assertEquals(160, bendecida.getEnergia());
    }

    @Test
    public void siLaEnergiaDuplicadaSupera180SeLimitaA180() {
        Criatura base =
                new CriaturaDomesticada("Lumi", 120, AfinidadElemental.AGUA);

        Criatura bendecida = new BendicionDelRio(base);

        assertEquals(180, bendecida.getEnergia());
    }

    @Test
    public void siLaEnergiaDeLaBaseCambiaLaTransformacionSeActualiza() {
        Criatura base =
                new CriaturaDomesticada("Lumi", 60, AfinidadElemental.AGUA);
        Criatura bendecida = new BendicionDelRio(base);

        assertEquals(120, bendecida.getEnergia());


        base.entrenar(20);

        assertEquals(160, bendecida.getEnergia());
    }
}

