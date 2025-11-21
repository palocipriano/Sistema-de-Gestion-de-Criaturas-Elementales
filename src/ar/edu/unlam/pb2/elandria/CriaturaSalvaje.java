package ar.edu.unlam.pb2.elandria;

public class CriaturaSalvaje extends Criatura {

    public CriaturaSalvaje(String nombre, int energia, AfinidadElemental afinidad) {
        super(nombre, energia, afinidad);
    }

    @Override
    public void entrenar(int incremento) {
        int nuevaEnergia = getEnergia() + incremento;

        if (nuevaEnergia > ENERGIA_MAXIMA) {
            throw new EnergiaDesbordadaExcepcion(
                    "La energía de la criatura salvaje supera el máximo permitido");
        }

        if (incremento > 0) {
            setEstado(EstadoEmocional.INESTABLE);
        }

        sumarEnergia(incremento);
    }

    @Override
    public void pacificar() {
        setEstado(EstadoEmocional.TRANQUILO);
    }
}
