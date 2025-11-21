package ar.edu.unlam.pb2.elandria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsejoElandria {

    private List<MaestroElemental> maestros;

    public ConsejoElandria() {
        this.maestros = new ArrayList<>();
    }

    public void registrarMaestro(MaestroElemental maestro) {
        this.maestros.add(maestro);
    }

    public List<Criatura> obtenerTodasLasCriaturas() {
        List<Criatura> todas = new ArrayList<>();
        for (MaestroElemental maestro : maestros) {
            todas.addAll(maestro.getCriaturas().values());
        }
        return todas;
    }

    public Criatura obtenerCriaturaMasPoderosa() {
        Criatura masPoderosa = null;
        int maxEnergia = -1;

        for (Criatura c : obtenerTodasLasCriaturas()) {
            if (c.getEnergia() > maxEnergia) {
                maxEnergia = c.getEnergia();
                masPoderosa = c;
            }
        }
        return masPoderosa;
    }

    public MaestroElemental obtenerMaestroConMasTransformaciones() {
        MaestroElemental topMaestro = null;
        int maxTransformadas = -1;

        for (MaestroElemental maestro : maestros) {
            int contadorTransformadas = 0;
  
            for (Criatura c : maestro.getCriaturas().values()) { 
  
                if (c instanceof TransformacionElemental) {
                    contadorTransformadas++;
                }
            }

            if (contadorTransformadas > maxTransformadas) {
                maxTransformadas = contadorTransformadas;
                topMaestro = maestro;
            }
        }
        return topMaestro;
    }

    
    public Map<AfinidadElemental, Integer> obtenerReportePorAfinidad() {
        Map<AfinidadElemental, Integer> reporte = new HashMap<>();
        
       
        for (AfinidadElemental afinidad : AfinidadElemental.values()) {
            reporte.put(afinidad, 0);
        }

        for (Criatura c : obtenerTodasLasCriaturas()) {
            AfinidadElemental af = c.getAfinidad();
            reporte.put(af, reporte.get(af) + 1);
        }

        return reporte;
    }
}