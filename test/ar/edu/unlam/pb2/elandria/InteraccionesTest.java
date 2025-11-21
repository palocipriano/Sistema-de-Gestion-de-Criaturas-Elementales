package ar.edu.unlam.pb2.elandria;

import static org.junit.Assert.*;
import org.junit.Test;

public class InteraccionesTest {

    @Test
    public void queDosCriaturasDeMismaAfinidadGanenEnergiaAlInteractuar() {
       
        Criatura agua1 = new CriaturaDomesticada("Nemo", 100, AfinidadElemental.AGUA);
        Criatura agua2 = new CriaturaSalvaje("Dory", 50, AfinidadElemental.AGUA);

        
        agua1.interactuarCon(agua2);

      
        assertEquals(110, agua1.getEnergia());
        assertEquals(60, agua2.getEnergia());
    }

    @Test
    public void queCriaturasDeAfinidadesOpuestasSeVuelvanInestables() {
     
        Criatura agua = new CriaturaDomesticada("Squirtle", 100, AfinidadElemental.AGUA);
        Criatura fuego = new CriaturaSalvaje("Charmander", 100, AfinidadElemental.FUEGO);

 
        agua.interactuarCon(fuego);

        assertEquals(EstadoEmocional.INESTABLE, agua.getEstado());
        assertEquals(EstadoEmocional.INESTABLE, fuego.getEstado());
    }
    
    @Test
    public void queCriaturasDeAfinidadesDistintasNoOpuestasNoSufranCambios() {
     
        Criatura agua = new CriaturaDomesticada("Squirtle", 100, AfinidadElemental.AGUA);
        Criatura aire = new CriaturaSalvaje("Pidgey", 100, AfinidadElemental.AIRE);

        
        int energiaInicialAgua = agua.getEnergia();
        EstadoEmocional estadoInicial = agua.getEstado();

   
        agua.interactuarCon(aire);

   
        assertEquals(energiaInicialAgua, agua.getEnergia());
        assertEquals(estadoInicial, agua.getEstado());
    }

    @Test
    public void queUnaCriaturaAncestralDomineLaInteraccion() {
      
        Criatura ancestral = new CriaturaAncestral("Mewtwo", 150, AfinidadElemental.FUEGO);
        Criatura comun = new CriaturaSalvaje("Rattata", 50, AfinidadElemental.TIERRA);

       
        ancestral.interactuarCon(comun);

     
        assertEquals(170, ancestral.getEnergia());
        assertEquals(35, comun.getEnergia());      
    }
    
    @Test
    public void queLaEnergiaNoBajeDeCeroAlPerderEnInteraccion() {
        Criatura ancestral = new CriaturaAncestral("Dragon", 150, AfinidadElemental.FUEGO);
        Criatura debil = new CriaturaSalvaje("Slime", 5, AfinidadElemental.TIERRA); 

        ancestral.interactuarCon(debil);

       
        assertEquals(0, debil.getEnergia());
    }
    
    @Test(expected = FaltaMaestriaExcepcion.class)
    public void queUnMaestroNoPuedaEntrenarSiNoTieneMaestriaSuficiente() throws FaltaMaestriaExcepcion {
        MaestroElemental novato = new MaestroElemental("Novato", 1, AfinidadElemental.AGUA);
        Criatura salvaje = new CriaturaSalvaje("Bestia", 100, AfinidadElemental.AGUA);
        
       
        novato.agregarCriatura(salvaje);
        novato.entrenarCriatura("Bestia", 10); 
    }
}