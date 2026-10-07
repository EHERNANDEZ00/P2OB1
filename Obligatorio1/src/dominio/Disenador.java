
package dominio;


public class Disenador {
    private String nombre;
    private String email;
    private int cantidadMurales;
    private String direccion;

    public Disenador(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadMurales = 0;
        this.direccion = direccion;
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
    
}
