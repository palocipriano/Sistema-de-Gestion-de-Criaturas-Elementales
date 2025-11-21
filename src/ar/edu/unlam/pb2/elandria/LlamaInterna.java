package ar.edu.unlam.pb2.elandria;

public class LlamaInterna extends TransformacionElemental {

    public LlamaInterna(Criatura base) {
        super(base);
    }

    @Override
    public int getEnergia() {
        if (base.getAfinidad() == AfinidadElemental.FUEGO) {
            return base.getEnergia() + 30;
        }
        return base.getEnergia();
    }

    @Override
    public EstadoEmocional getEstado() {
        if (base.getAfinidad() != AfinidadElemental.FUEGO) {
            return EstadoEmocional.INESTABLE;
        }
        return base.getEstado();
    }
}
