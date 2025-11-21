package ar.edu.unlam.pb2.elandria;

public class CriaturaAncestral extends Criatura {

    private static final int ENERGIA_MINIMA_ANCESTRAL = 100;
    private static final int UMBRAL_ENTRENAMIENTO_EXTREMO = 50;

    public CriaturaAncestral(String nombre, int energia, AfinidadElemental afinidad) {
        super(nombre, energia, afinidad);
    }

    @Override
    protected void setEnergia(int energia) {
        int ajustada = energia;

        if (ajustada < ENERGIA_MINIMA_ANCESTRAL) {
            ajustada = ENERGIA_MINIMA_ANCESTRAL;
        }
        if (ajustada > ENERGIA_MAXIMA) {
            ajustada = ENERGIA_MAXIMA;
        }

        super.setEnergia(ajustada);
    }

    @Override
    public void entrenar(int incremento) {
        if (Math.abs(incremento) > UMBRAL_ENTRENAMIENTO_EXTREMO) {
            setEstado(EstadoEmocional.INESTABLE);
        }

        int nuevaEnergia = getEnergia() + incremento;
        setEnergia(nuevaEnergia);
    }

    @Override
    public void pacificar() {
        setEstado(EstadoEmocional.TRANQUILO);
    }
}

