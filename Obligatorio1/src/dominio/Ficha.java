
package dominio;

public class Ficha {
    private String nombre;
    private String repChica;
    private String repGrande;
    private char color;

    public Ficha(String nombre, String repChica, String repGrande, char color) {
        this.nombre = nombre;
        this.repChica = repChica;
        this.repGrande = repGrande;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRepChica() {
        return repChica;
    }

    public String getRepGrande() {
        return repGrande;
    }

    public char getColor() {
        return color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRepChica(String repChica) {
        this.repChica = repChica;
    }

    public void setRepGrande(String repGrande) {
        this.repGrande = repGrande;
    }

    public void setColor(char color) {
        this.color = color;
    }
    
    
}
