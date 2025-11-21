package ar.edu.unlam.pb2.elandria;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaestroElementalTest {

    @Test
    public void alCrearUnMaestroSeInicializanSusDatosYNoTieneCriaturas() {
        MaestroElemental maestro =
                new MaestroElemental("Ailin", 25, AfinidadElemental.AGUA);

        assertEquals("Ailin", maestro.getNombre());
        assertEquals(25, maestro.getNivelMaestria());
        assertEquals(AfinidadElemental.AGUA, maestro.getAfinidadPrincipal());
        assertEquals(0, maestro.getCantidadDeCriaturas());
    }

    @Test
    public void agregarCriaturaLaGuardaEnElHashMapIdentificadaPorNombre() {
        MaestroElemental maestro =
                new MaestroElemental("Ailin", 25, AfinidadElemental.AGUA);
        Criatura lumi =
                new CriaturaDomesticada("Lumi", 80, AfinidadElemental.AGUA);

        maestro.agregarCriatura(lumi);

        assertSame(lumi, maestro.buscarCriatura("Lumi"));
        assertEquals(1, maestro.getCantidadDeCriaturas());
    }

    @Test
    public void entrenarCriaturaDomesticadaConMaestriaSuficienteAumentaEnergia()
			throws FaltaMaestriaExcepcion {

        MaestroElemental maestro =
                new MaestroElemental("Ailin", 10, AfinidadElemental.AGUA);
        CriaturaDomesticada lumi =
                new CriaturaDomesticada("Lumi", 100, AfinidadElemental.AGUA);
        maestro.agregarCriatura(lumi);

        maestro.entrenarCriatura("Lumi", 20);

        assertEquals(120, lumi.getEnergia());
    }

    @Test(expected = FaltaMaestriaExcepcion.class)
    public void entrenarCriaturaSalvajeConMaestriaInsuficienteLanzaChecked()
            throws FaltaMaestriaExcepcion {

        MaestroElemental maestro =
                new MaestroElemental("Dario", 10, AfinidadElemental.FUEGO);
        CriaturaSalvaje drako =
                new CriaturaSalvaje("Drako", 100, AfinidadElemental.FUEGO);
        maestro.agregarCriatura(drako);

        maestro.entrenarCriatura("Drako", 20);
    }

    @Test
    public void pacificarUnaCriaturaInestableLaVuelveTranquila()
            throws FaltaMaestriaExcepcion {

        MaestroElemental maestro =
                new MaestroElemental("Dario", 30, AfinidadElemental.FUEGO);
        CriaturaSalvaje drako =
                new CriaturaSalvaje("Drako", 100, AfinidadElemental.FUEGO);

        
        drako.entrenar(20);
        assertEquals(EstadoEmocional.INESTABLE, drako.getEstado());

        maestro.agregarCriatura(drako);
        maestro.pacificarCriatura("Drako");

        assertEquals(EstadoEmocional.TRANQUILO, drako.getEstado());
    }
}

