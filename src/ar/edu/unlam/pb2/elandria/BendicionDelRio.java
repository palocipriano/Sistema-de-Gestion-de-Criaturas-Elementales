package ar.edu.unlam.pb2.elandria;

public class BendicionDelRio extends TransformacionElemental {

    public BendicionDelRio(Criatura base) {
        super(base);
    }

    @Override
    public int getEnergia() {
        int energiaBase = base.getEnergia();
        int duplicada = energiaBase * 2;

        if (duplicada > 180) {
            duplicada = 180;
        }
        return duplicada;
    }
}

