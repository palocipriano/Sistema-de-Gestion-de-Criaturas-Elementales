package ar.edu.unlam.pb2.elandria;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ConsejoTest {

    private ConsejoElandria consejo;
    private MaestroElemental maestroAgua;
    private MaestroElemental maestroFuego;

    @Before
    public void setUp() {
        consejo = new ConsejoElandria();
        maestroAgua = new MaestroElemental("Katara", 40, AfinidadElemental.AGUA);
        maestroFuego = new MaestroElemental("Zuko", 45, AfinidadElemental.FUEGO);
        
        consejo.registrarMaestro(maestroAgua);
        consejo.registrarMaestro(maestroFuego);
    }

    @Test
    public void queSePuedaObtenerLaCriaturaConMayorEnergiaTotal() {
      
        Criatura c1 = new CriaturaDomesticada("Pez", 50, AfinidadElemental.AGUA);
        Criatura c2 = new CriaturaSalvaje("Tiburon", 180, AfinidadElemental.AGUA); 
        Criatura c3 = new CriaturaSalvaje("Llama", 20, AfinidadElemental.FUEGO);

        maestroAgua.agregarCriatura(c1);
        maestroAgua.agregarCriatura(c2);
        maestroFuego.agregarCriatura(c3);

     
        Criatura masPoderosa = consejo.obtenerCriaturaMasPoderosa();

   
        assertEquals("Tiburon", masPoderosa.getNombre());
        assertEquals(180, masPoderosa.getEnergia());
    }

    @Test
    public void queSePuedaDeterminarElMaestroConMasTransformaciones() {
     
        Criatura c1 = new CriaturaDomesticada("Base1", 100, AfinidadElemental.AGUA);
        Criatura c2 = new CriaturaDomesticada("Base2", 100, AfinidadElemental.AGUA);
        
       
        maestroAgua.agregarCriatura(c1);
        maestroAgua.aplicarBendicionDelRio("Base1"); 
        
        maestroAgua.agregarCriatura(c2);
        maestroAgua.aplicarAscensoDelViento("Base2"); 

       
        Criatura c3 = new CriaturaSalvaje("Base3", 100, AfinidadElemental.FUEGO);
        maestroFuego.agregarCriatura(c3);

     
        MaestroElemental maestroTop = consejo.obtenerMaestroConMasTransformaciones();

      
        assertEquals("Katara", maestroTop.getNombre());
    }

    @Test
    public void queSeGenereElReporteDeCantidadPorAfinidad() {
  
        maestroAgua.agregarCriatura(new CriaturaDomesticada("A1", 10, AfinidadElemental.AGUA));
        maestroAgua.agregarCriatura(new CriaturaDomesticada("A2", 10, AfinidadElemental.AGUA));
        
        maestroFuego.agregarCriatura(new CriaturaDomesticada("F1", 10, AfinidadElemental.FUEGO));
        
        maestroFuego.agregarCriatura(new CriaturaDomesticada("T1", 10, AfinidadElemental.TIERRA));

       
        Map<AfinidadElemental, Integer> reporte = consejo.obtenerReportePorAfinidad();

        
        assertEquals(Integer.valueOf(2), reporte.get(AfinidadElemental.AGUA));
        assertEquals(Integer.valueOf(1), reporte.get(AfinidadElemental.FUEGO));
        assertEquals(Integer.valueOf(1), reporte.get(AfinidadElemental.TIERRA));
        assertEquals(Integer.valueOf(0), reporte.get(AfinidadElemental.AIRE));
    }
    
    @Test
    public void queListeTodasLasCriaturasDeTodosLosMaestros() {
        maestroAgua.agregarCriatura(new CriaturaDomesticada("C1", 10, AfinidadElemental.AGUA));
        maestroFuego.agregarCriatura(new CriaturaDomesticada("C2", 10, AfinidadElemental.FUEGO));
        
        List<Criatura> todas = consejo.obtenerTodasLasCriaturas();
        
        assertEquals(2, todas.size());
    }
}