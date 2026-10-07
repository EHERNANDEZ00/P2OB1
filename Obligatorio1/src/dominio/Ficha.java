
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
   
    /**
     *
     * @param tamanoGrande
     * @return
     */
    public String imprimir(boolean tamanoGrande){
        int porLinea = 3;
        int max = 9;
        String aVer = this.repChica;
        if(tamanoGrande){porLinea = 5; max = 25; aVer = this.repGrande;}
        String aRetornar = "";
        for(int i = 0; i < max; i++){
            String caracterAColocar = aVer.charAt(i) == '.' ? " ": (aVer.charAt(i) + "");
            if(i % porLinea == 0 && i != 0){
                aRetornar += "\n" + caracterAColocar;
            } else {
                aRetornar += caracterAColocar;
            }
        }
        return aRetornar;
    }
    
    @Override
    public String toString(){
        String aRetornar = "";
        aRetornar += "Ficha: " + this.nombre + "\nColor: " + this.color + "\nTamaño Chico \n" + this.imprimir(false) + "\n Tamaño Grande \n" + this.imprimir(true);
        return aRetornar;
    }
    
}
