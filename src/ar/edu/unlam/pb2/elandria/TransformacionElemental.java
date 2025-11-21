package ar.edu.unlam.pb2.elandria;
public abstract class TransformacionElemental extends Criatura {

    protected Criatura base;

    public TransformacionElemental(Criatura base) {
        super(base.getNombre(), base.getEnergia(), base.getAfinidad());
        this.base = base;
    }

    @Override
    public String getNombre() {
        return base.getNombre();
    }

    @Override
    public int getEnergia() {
        return base.getEnergia();
    }

    @Override
    public AfinidadElemental getAfinidad() {
        return base.getAfinidad();
    }

    @Override
    public EstadoEmocional getEstado() {
        return base.getEstado();
    }

    @Override
    public void entrenar(int incremento) {
        base.entrenar(incremento);
    }

    @Override
    public void pacificar() {
        base.pacificar();
    }
    
    public Criatura getBase() {
        return base;
    }
}
