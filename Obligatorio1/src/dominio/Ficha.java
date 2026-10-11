
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
   
    
    public static String darColor(char color){
        String retorno = "";
        switch(color){
            case 'R':
                retorno += "\u001B[31m";
                break;
            case 'A':
                retorno += "\u001B[34m";
                break;
            case 'B':
                retorno += "\u001B[37m";
                break;
            case 'N':
                retorno += "\u001B[30m";
                break;
            case 'M':
                retorno += "\u001B[33m";
                break;
            case 'V':
                retorno += "\u001B[32m";
                break;
            case 'G':
                retorno += "\u001B[35m";
                break;
            case 'C':
                retorno += "\u001B[37m";
                break;
                
        }
        return retorno;
    }
    public String imprimir(boolean tamanoGrande){
        int porLinea = 3;
        int max = 9;
        String aVer = this.repChica;
        if(tamanoGrande){porLinea = 5; max = 25; aVer = this.repGrande;}
        String aRetornar = "";
        for(int i = 0; i < max; i++){
            String caracterAColocar = aVer.charAt(i) == '.' ? " ": (aVer.charAt(i) + "");
            aRetornar += darColor(this.color);
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
