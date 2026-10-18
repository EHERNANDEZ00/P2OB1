
package dominio;
import java.util.ArrayList;

public class Disenador {
    private String nombre;
    private String email;
    private int cantidadMurales;
    private String direccion;
    private int numeroDeMurales;
    private ArrayList<Ficha> fichasUsadas;
    private ArrayList<Character> coloresUsados;
    

    public Disenador(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadMurales = 0;
        this.direccion = direccion;
        this.numeroDeMurales = 0;
        this.numeroDeMurales = 0;
        this.fichasUsadas = new ArrayList<>();
        this.coloresUsados = new ArrayList<>();
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadMurales() {
        return cantidadMurales;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCantidadMurales(int cantidadMurales) {
        this.cantidadMurales = cantidadMurales;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void agregarDatosFicha(Ficha ficha){
        if(!this.fichasUsadas.contains(ficha)){
            this.fichasUsadas.add(ficha);
        }
        char colorDeLaFicha = ficha.getColor();
        if(!this.coloresUsados.contains(colorDeLaFicha)){
            coloresUsados.add(colorDeLaFicha);
        }
    }
    
    public int getNumeroFichas(){
        return this.fichasUsadas.size();
    }
    
    public int getNumeroColores(){
        return this.coloresUsados.size();
    }
    
    @Override
    public boolean equals(Object o){
        return this.nombre.equalsIgnoreCase(((Disenador) o).nombre);
    }
}
