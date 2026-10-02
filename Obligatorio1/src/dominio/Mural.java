
public class Mural {
    private String nombre;
    private Disenador disenador;
    private Ficha[][] mural;

    public Mural(String nombre, Disenador disenador, Ficha[][] mural) {
        this.nombre = nombre;
        this.disenador = disenador;
        this.mural = mural;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Disenador getDisenador() {
        return disenador;
    }

    public void setDisenador(Disenador disenador) {
        this.disenador = disenador;
    }

    public Ficha[][] getMural() {
        return mural;
    }

    public void setMural(Ficha[][] mural) {
        this.mural = mural;
    }
    
    
}