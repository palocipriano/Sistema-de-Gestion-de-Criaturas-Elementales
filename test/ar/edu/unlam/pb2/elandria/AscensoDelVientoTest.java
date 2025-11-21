package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class AscensoDelVientoTest {

    @Test
    public void convierteTemporalmenteLaAfinidadEnAireSinTocarLaBase() {
        Criatura base =
                new CriaturaDomesticada("Lumi", 100, AfinidadElemental.AGUA);

        AscensoDelViento transformada = new AscensoDelViento(base);

        assertEquals(AfinidadElemental.AIRE, transformada.getAfinidad());

        assertEquals(AfinidadElemental.AGUA, base.getAfinidad());
    }

    @Test
    public void noModificaLaEnergiaSoloLaAfinidadVisible() {
        Criatura base =
                new CriaturaDomesticada("Lumi", 120, AfinidadElemental.FUEGO);

        AscensoDelViento transformada = new AscensoDelViento(base);

        assertEquals(120, transformada.getEnergia());
    }
}
