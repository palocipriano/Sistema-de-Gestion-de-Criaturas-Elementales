package ar.edu.unlam.pb2.elandria;

public class AscensoDelViento extends TransformacionElemental {

    public AscensoDelViento(Criatura base) {
        super(base);
    }

    @Override
    public AfinidadElemental getAfinidad() {
        return AfinidadElemental.AIRE;
    }
}
