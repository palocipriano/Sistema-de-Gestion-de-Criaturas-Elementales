package ar.edu.unlam.pb2.elandria;

public class CriaturaDomesticada extends Criatura {

    public CriaturaDomesticada(String nombre, int energia, AfinidadElemental afinidad) {
        super(nombre, energia, afinidad);
    }

    @Override
    public void entrenar(int incremento) {
        int nuevaEnergia = getEnergia() + incremento;

        if (nuevaEnergia > ENERGIA_MAXIMA) {
            nuevaEnergia = ENERGIA_MAXIMA;
        }
        if (nuevaEnergia < ENERGIA_MINIMA) {
            nuevaEnergia = ENERGIA_MINIMA;
        }

        setEstado(EstadoEmocional.TRANQUILO);
        sumarEnergia(nuevaEnergia - getEnergia());
    }

    @Override
    public void pacificar() {
        setEstado(EstadoEmocional.TRANQUILO);
    }
}

