package dominio;
import java.util.ArrayList;
import java.util.Random;
public class Mural {
    private String nombre;
    private Disenador disenador;
    private Ficha[][] mural;
    private Ficha[][] muralOriginal;

    public Mural(String nombre, Disenador disenador, char function, Ficha fichovichA, Ficha fichovichB, ArrayList arFicha){
        this.nombre = nombre;
        this.disenador = disenador;
        switch (function){
            case 'D':
                    this.mural = ordenD(fichovichA,fichovichB);
                    break;
            case 'R':
                    this.mural = ordenR(arFicha);
                    break;
            case 'F':
                    this.mural = ordenF(fichovichA,fichovichB);
                    break;
            case 'B':
                    this.mural = ordenB(fichovichA,fichovichB);
                    break;
            
        }
        this.muralOriginal = this.mural;
    }
    
    public Mural(String nombre, Disenador disenador, Ficha[][] muralM){
        this.nombre = nombre;
        this.disenador = disenador;
        this.mural = muralM;
        this.muralOriginal = this.mural;
    }
    
    
    public Ficha[][] ordenD(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralD = new Ficha[10][12];
        for(int i = 0; i < muralD.length; i++){
            for(int j = 0; j < muralD[0].length; j++){
              muralD[i][j] = j%2 == 0? fichaA : fichaB;
            }
        }
        return muralD;
    }
        public Ficha[][] ordenR(ArrayList<Ficha> arFicha){
        Random rand = new Random();
        Ficha[][] muralR = new Ficha[10][12];
        for(int i = 0; i < muralR.length; i++){
            for(int j = 0; j < muralR[0].length; j++){
              muralR[i][j] = arFicha.get(7);
            }
        }
        int maxCol = rand.nextInt(1,13);
        int maxFil = rand.nextInt(1,11);
        
            for (int i = 0; i < maxFil; i++) {
                for (int j = 0; j < maxCol; j++) {
                    muralR[i][j] = arFicha.get(rand.nextInt(0,arFicha.size()));
                }
            }
        return muralR;
    }
        public Ficha[][] ordenF(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralF = new Ficha[10][12];
        for(int i = 0; i < muralF.length; i++){
            for(int j = 0; j < muralF[0].length; j++){
              muralF[i][j] = i%2 == 0? fichaA : fichaB;
            }
        }
        return muralF;
    }
        public Ficha[][] ordenB(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralB = new Ficha[10][12];
        for(int i = 0; i < muralB.length; i++){
            for(int j = 0; j < muralB[0].length; j++){
                if (i==0 || i == muralB.length || j == 0 || j == muralB[0].length) {
                    mural[i][j] = fichaA;
                }else{
                    mural[i][j] = fichaB;
                }
            }
        }
        return muralB;
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
    public void cambiarPosicion (int fila, int columna, Ficha ficha){
        this.mural[fila][columna] = ficha;
    }
    public void restaurar(){
        this.mural = this.muralOriginal;
    }
    public ArrayList<Ficha> fichasContenidas(){
        ArrayList<Ficha> contenidos = new ArrayList<>();
        for(Ficha[] fila : this.mural){
            for(Ficha ficha : fila){
                if(!contenidos.contains(ficha)){
                    contenidos.add(ficha);
                }
            }
        }
        return contenidos;
    }
    public String darColor(char color){
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
   
    public String imprimir(boolean grande){
        int posMax = 25;
        int aAvanzar = 5;
        if(!grande){
            posMax = 9;
            aAvanzar = 3;
        }
        String retorno = "";
        for(Ficha[] fila: this.mural){
            for(int posFila = 0; posFila < posMax; posFila++){
                for(Ficha ficha: fila){
                    retorno += darColor(ficha.getColor());
                    retorno += ficha.imprimir(grande).replaceAll("\n", "").substring(posFila, posFila + aAvanzar);
                }
                posFila += aAvanzar -1;
                retorno += "\n";
            }
        }
        
        return retorno;
    }
}