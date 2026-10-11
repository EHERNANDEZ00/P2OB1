package dominio;
import java.util.Scanner;
import java.util.ArrayList;

public class Mural {
    private String nombre;
    private Disenador disenador;
    private Ficha[][] mural;
    private Ficha[][] muralOriginal;

    public Mural(String nombre, Disenador disenador, char function, Ficha fichovichA, Ficha fichovichB) {
        this.nombre = nombre;
        this.disenador = disenador;
        switch (function){
            case 'D':
                    this.mural = ordenD(fichovichA,fichovichB);
                    break;
            case 'R':
                    this.mural = ordenR(fichovichA,fichovichB);
                    break;
            case 'F':
                    this.mural = ordenF(fichovichA,fichovichB);
                    break;
            case 'B':
                    this.mural = ordenB(fichovichA,fichovichB);
                    break;
            case 'M':
                    this.mural = ordenM(fichovichA,fichovichB);
                    break;
        }
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
        public Ficha[][] ordenR(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralR = new Ficha[10][12];
        for(int i = 0; i < muralR.length; i++){
            for(int j = 0; j < muralR[0].length; j++){
              muralR[i][j] = j%2 == 0? fichaA : fichaB;
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
        public Ficha[][] ordenM(Ficha fichaA, Ficha fichaB){
        Ficha[][] muralM = new Ficha[10][12];
        String gervasio = "";
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < muralM.length || !gervasio.equals("3"); i++){
            for(int j = 0; j < muralM[0].length || !gervasio.equals("3"); j++){
                System.out.println("Esta en la fila "+i+" y la columa "+j);
                System.out.println("Quiere imprimir la ficha 1 o la ficha 2? En caso de no querer ninguna ingrese 3");
                gervasio = input.nextLine();
                if(gervasio.equals("1")){
                    muralM[i][j] = fichaA;
                }
                if (gervasio.equals("2")) {
                    muralM[i][j] = fichaB;
                }else{
                    while(!gervasio.equals("1")||!gervasio.equals("2")||!gervasio.equals("3")){
                        System.out.println("Esa opcion no es correcta, porfavor ingrese 1, 2 o 3");
                        gervasio = input.nextLine();
                    }
                }
                
            }
        }
        return muralM;
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
}