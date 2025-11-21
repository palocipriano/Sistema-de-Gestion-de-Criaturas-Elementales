package ar.edu.unlam.pb2.elandria;

public class VinculoTerrestre extends TransformacionElemental {

    public VinculoTerrestre(Criatura base) {
        super(base);
    }

    @Override
    public int getEnergia() {
        int energiaBase = base.getEnergia();
        if (energiaBase < 50) {
            return 50;
        }
        return energiaBase;
    }
}