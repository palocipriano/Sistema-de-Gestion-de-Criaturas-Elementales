package ar.edu.unlam.pb2.elandria;

public abstract class Criatura {

    protected static final int ENERGIA_MINIMA = 0;
    protected static final int ENERGIA_MAXIMA = 200;

    private String nombre;
    private int energia;
    private AfinidadElemental afinidad;
    private EstadoEmocional estado;

    public Criatura(String nombre, int energia, AfinidadElemental afinidad) {
        this.nombre = nombre;
        this.afinidad = afinidad;
        this.estado = EstadoEmocional.TRANQUILO;
        setEnergia(energia);
    }


    protected void setEnergia(int energia) {
        if (energia < ENERGIA_MINIMA) {
            this.energia = ENERGIA_MINIMA;
        } else {
            this.energia = energia;
        }
    }

    protected void sumarEnergia(int incremento) {
        setEnergia(this.energia + incremento);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public AfinidadElemental getAfinidad() {
        return afinidad;
    }

    public EstadoEmocional getEstado() {
        return estado;
    }

    protected void setEstado(EstadoEmocional estado) {
        this.estado = estado;
    }

    // Cada subtipo define su lógica de entrenamiento y pacificación
    public abstract void entrenar(int incremento);

    public abstract void pacificar();
}

