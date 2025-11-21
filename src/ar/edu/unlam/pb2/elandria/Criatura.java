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

    public abstract void entrenar(int incremento);

    public abstract void pacificar();
    
    public void interactuarCon(Criatura otraCriatura) {
        
        boolean soyAncestral = this instanceof CriaturaAncestral;
        boolean otraEsAncestral = otraCriatura instanceof CriaturaAncestral;

        if (soyAncestral || otraEsAncestral) {
            aplicarDominioAncestral(this, otraCriatura);
            return;
        }

       
        if (this.getAfinidad() == otraCriatura.getAfinidad()) {
           
            this.sumarEnergia(10);
            otraCriatura.sumarEnergia(10);
        } else if (sonAfinidadesOpuestas(this.getAfinidad(), otraCriatura.getAfinidad())) {
            
            this.setEstado(EstadoEmocional.INESTABLE);
            otraCriatura.setEstado(EstadoEmocional.INESTABLE);
        }
        
    }

 
    private void aplicarDominioAncestral(Criatura c1, Criatura c2) {
        
        if (c1 instanceof CriaturaAncestral) {
            c1.sumarEnergia(20);
            c2.sumarEnergia(-15); 
        } 
        
        if (c2 instanceof CriaturaAncestral) {
            c2.sumarEnergia(20);
            c1.sumarEnergia(-15);
        }
    }

    private boolean sonAfinidadesOpuestas(AfinidadElemental a1, AfinidadElemental a2) {
        if ((a1 == AfinidadElemental.AGUA && a2 == AfinidadElemental.FUEGO) ||
            (a1 == AfinidadElemental.FUEGO && a2 == AfinidadElemental.AGUA)) {
            return true;
        }
        if ((a1 == AfinidadElemental.AIRE && a2 == AfinidadElemental.TIERRA) ||
            (a1 == AfinidadElemental.TIERRA && a2 == AfinidadElemental.AIRE)) {
            return true;
        }
        return false;
    }
}

