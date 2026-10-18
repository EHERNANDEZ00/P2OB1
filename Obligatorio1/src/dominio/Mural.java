package dominio;
import java.util.ArrayList;
import java.util.Random;
public class Mural {
    private String nombre;
    private Disenador disenador;
    private Ficha[][] mural;
    private Ficha[][] muralOriginal;

    public Mural(String nombre, Disenador disenador, char function, Ficha fichaA, Ficha fichaB){
        this.nombre = nombre;
        this.disenador = disenador;
        this.muralOriginal = new Ficha[10][12];
        switch (function){
            case 'D':
                    this.mural = ordenD(fichaA,fichaB);
                    break;
            case 'R':
                    this.mural = ordenR(fichaA, fichaB);
                    break;
            case 'F':
                    this.mural = ordenF(fichaA,fichaB);
                    break;
            case 'B':
                    this.mural = ordenB(fichaA,fichaB);
                    break;
        }
        guardarOriginal();
    }
    
    private void guardarOriginal(){
        for(int i = 0; i < this.mural.length; i++){
            for(int j = 0; j < this.mural[0].length; j++){
                this.muralOriginal[i][j] = this.mural[i][j];
            }
        }
    }
    public Mural(String nombre, Disenador disenador, Ficha[][] muralM){
        this.nombre = nombre;
        this.disenador = disenador;
        this.mural = muralM;
        this.muralOriginal = this.mural;
    }
    
    
    private Ficha[][] ordenD(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralD = new Ficha[10][12];
        for(int i = 0; i < muralD.length; i++){
            for(int j = 0; j < muralD[0].length; j++){
              muralD[i][j] = (j+i)%2 == 0? fichaA : fichaB;
            }
        }
        return muralD;
    }
        private Ficha[][] ordenR(Ficha fichaA, Ficha fichaB){
            Random rand = new Random();
            Ficha[][] muralR = new Ficha[10][12];
            for(int i = 0; i < muralR.length; i++){
                for(int j = 0; j < muralR[0].length; j++){
                    muralR[i][j] = rand.nextInt(2) == 1 ? fichaA : fichaB;
                }
            }
            return muralR;
    }
        private Ficha[][] ordenF(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralF = new Ficha[10][12];
        for(int i = 0; i < muralF.length; i++){
            for(int j = 0; j < muralF[0].length; j++){
              muralF[i][j] = i%2 == 0? fichaA : fichaB;
            }
        }
        return muralF;
    }
        private Ficha[][] ordenB(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralB = new Ficha[10][12];
        for(int i = 0; i < muralB.length; i++){
            for(int j = 0; j < muralB[0].length; j++){
                if (i==0 || i == muralB.length -1 || j == 0 || j == muralB[0].length -1) {
                    muralB[i][j] = fichaA;
                }else{
                    muralB[i][j] = fichaB;
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
   
    public void cambiarFicha(Ficha aCambiar, Ficha cambio){
        for(int i = 0; i < this.mural.length; i++){
            for(int j = 0; j < this.mural[0].length; j++){
                if(this.mural[i][j] == aCambiar){
                    this.mural[i][j] = cambio;
                }
            }
        }
    }
    
    public void restaurar(){
        for(int i = 0; i < this.muralOriginal.length; i++){
            for(int j = 0; j < this.muralOriginal[0].length; j++){
                this.mural[i][j] = this.muralOriginal[i][j];
            }
        }
    }
    
    public boolean validarManual(int fila, int col, Ficha vacia){
        return this.mural[fila][col] == vacia;
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
    
 
    public Ficha[][] obtenerSubMural(int fila0, int col0, int filas, int columnas){
            Ficha[][] subMural = new Ficha[filas][columnas];
            for(int i =0; i < filas; i++){
                for(int j = 0; j < columnas; j++){
                    subMural[i][j] = this.mural[fila0 + i][col0 + j];
                }
            }
            return subMural;
        }
}