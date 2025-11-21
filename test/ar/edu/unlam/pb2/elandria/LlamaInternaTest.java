package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class LlamaInternaTest {

    @Test
    public void siLaAfinidadEsFuegoSuma30DeEnergia() {
        Criatura base =
                new CriaturaDomesticada("Pyra", 100, AfinidadElemental.FUEGO);

        Criatura llama = new LlamaInterna(base);

        assertEquals(130, llama.getEnergia());
        assertEquals(AfinidadElemental.FUEGO, llama.getAfinidad());
    }

    @Test
    public void siNoEsFuegoLaCriaturaSeVuelveInestablePeroMantieneEnergia() {
        Criatura base =
                new CriaturaDomesticada("Aqua", 90, AfinidadElemental.AGUA);

        Criatura llama = new LlamaInterna(base);

        assertEquals(90, llama.getEnergia());
        assertEquals(EstadoEmocional.INESTABLE, llama.getEstado());
    }

    @Test
    public void siLaEnergiaBaseCambiaLaTransformacionSeActualiza() {
        CriaturaDomesticada base =
                new CriaturaDomesticada("Pyra", 80, AfinidadElemental.FUEGO);

        Criatura llama = new LlamaInterna(base);
        assertEquals(110, llama.getEnergia());

        base.entrenar(10);
        assertEquals(120, llama.getEnergia());
    }
}

