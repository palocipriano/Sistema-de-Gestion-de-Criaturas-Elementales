package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class TransformacionesApiladasTest {

    @Test
    public void maestroPuedeApilarTransformacionesComoCapasDecoradoras()
            throws FaltaMaestriaExcepcion {

        MaestroElemental maestro =
                new MaestroElemental("Ailin", 40, AfinidadElemental.FUEGO);

        CriaturaSalvaje drako =
                new CriaturaSalvaje("Drako", 80, AfinidadElemental.FUEGO);

        maestro.agregarCriatura(drako);

        maestro.aplicarBendicionDelRio("Drako");

        maestro.aplicarAscensoDelViento("Drako");

        Criatura criaturaFinal = maestro.buscarCriatura("Drako");

        assertTrue(criaturaFinal instanceof AscensoDelViento);

        TransformacionElemental externo = (TransformacionElemental) criaturaFinal;
        Criatura capaIntermedia = externo.getBase();

        assertTrue(capaIntermedia instanceof BendicionDelRio);

        TransformacionElemental intermedia = (TransformacionElemental) capaIntermedia;
        Criatura baseOriginal = intermedia.getBase();

        assertSame(drako, baseOriginal);
    }
}

