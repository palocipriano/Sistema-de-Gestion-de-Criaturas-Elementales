package ar.edu.unlam.pb2.elandria;
import java.util.HashMap;
import java.util.Map;

public class MaestroElemental {

    private String nombre;
    private int nivelMaestria;
    private AfinidadElemental afinidadPrincipal;
    private Map<String, Criatura> criaturas;

    public MaestroElemental(String nombre, int nivelMaestria, AfinidadElemental afinidadPrincipal) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidadPrincipal = afinidadPrincipal;
        this.criaturas = new HashMap<String, Criatura>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelMaestria() {
        return nivelMaestria;
    }

    public AfinidadElemental getAfinidadPrincipal() {
        return afinidadPrincipal;
    }

    public int getCantidadDeCriaturas() {
        return this.criaturas.size();
    }

    public void agregarCriatura(Criatura criatura) {
        this.criaturas.put(criatura.getNombre(), criatura);
    }

    public Criatura buscarCriatura(String nombreCriatura) {
        return this.criaturas.get(nombreCriatura);
    }

    public void entrenarCriatura(String nombreCriatura, int incremento)
            throws FaltaMaestriaExcepcion {

        Criatura criatura = buscarCriatura(nombreCriatura);
        if (criatura == null) {
            throw new IllegalArgumentException("No existe una criatura con el nombre " + nombreCriatura);
        }

        if (!tieneMaestriaSuficientePara(criatura)) {
            throw new FaltaMaestriaExcepcion(
                    "El maestro no tiene maestría suficiente para entrenar a esta criatura");
        }

        criatura.entrenar(incremento);
    }

    public void pacificarCriatura(String nombreCriatura) {
        Criatura criatura = buscarCriatura(nombreCriatura);
        if (criatura == null) {
            throw new IllegalArgumentException("No existe una criatura con el nombre " + nombreCriatura);
        }
        criatura.pacificar();
    }

    private boolean tieneMaestriaSuficientePara(Criatura criatura) {

        if (criatura instanceof CriaturaDomesticada) {
            return true;
        }

        if (criatura instanceof CriaturaSalvaje) {
            return this.nivelMaestria >= 20;
        }

        if (criatura instanceof CriaturaAncestral) {
            return this.nivelMaestria >= 35;
        }

        return false;
    }
    
    public void aplicarBendicionDelRio(String nombreCriatura) {
        Criatura original = buscarCriatura(nombreCriatura);
        if (original == null) {
            throw new IllegalArgumentException("No existe una criatura con el nombre " + nombreCriatura);
        }

        Criatura transformada = new BendicionDelRio(original);
        this.criaturas.put(nombreCriatura, transformada);
    }
    
    public void aplicarAscensoDelViento(String nombreCriatura) {
        Criatura original = buscarCriatura(nombreCriatura);
        if (original == null) {
            throw new IllegalArgumentException(
                    "No existe una criatura con el nombre " + nombreCriatura);
        }

        Criatura transformada = new AscensoDelViento(original);

        this.criaturas.put(nombreCriatura, transformada);
    }
    
    public void aplicarLlamaInterna(String nombreCriatura) {
        Criatura original = buscarCriatura(nombreCriatura);
        if (original == null) {
            throw new IllegalArgumentException(
                    "No existe una criatura con el nombre " + nombreCriatura);
        }
        Criatura transformada = new LlamaInterna(original);
        this.criaturas.put(nombreCriatura, transformada);
    }

    public void aplicarVinculoTerrestre(String nombreCriatura) {
        Criatura original = buscarCriatura(nombreCriatura);
        if (original == null) {
            throw new IllegalArgumentException(
                    "No existe una criatura con el nombre " + nombreCriatura);
        }
        Criatura transformada = new VinculoTerrestre(original);
        this.criaturas.put(nombreCriatura, transformada);
    }


}

