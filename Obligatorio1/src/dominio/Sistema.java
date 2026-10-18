package dominio;
import java.util.ArrayList;

public class Sistema {
    ArrayList<Ficha> listaFichas;
    ArrayList<Mural> listaMurales;
    ArrayList<Disenador> listaDisenadores;

    public Sistema() {
        listaFichas = new ArrayList<>();
        listaMurales = new ArrayList<>();
        listaDisenadores = new ArrayList<>();
        precargar();
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }

    public ArrayList<Disenador> getListaDisenadores() {
        return listaDisenadores;
    }
    
    public void agregarFicha(Ficha unaFicha){
        listaFichas.add(unaFicha);
    }
    public void agregarMural(Mural unMural){
        listaMurales.add(unMural);
        for(Ficha ficha: unMural.fichasContenidas()){
            unMural.getDisenador().agregarDatosFicha(ficha);
        }
        unMural.getDisenador().sumarMural();
    }
    public void agregarDisenador(Disenador unDisenador){
        listaDisenadores.add(unDisenador);
        this.listaDisenadores.sort((d1,d2) -> d1.getNombre().compareTo(d2.getNombre()));
    }
    
    public boolean validarNombreFicha(String nombre){
        boolean esValido = true;
        if(!listaFichas.isEmpty()){
            for(Ficha ficha: listaFichas){
                if(ficha.getNombre().equals(nombre)){
                    esValido = false;
                }
            }
        }
        return esValido;
    }
    
    public boolean validarNombreMural(String nombre){
        boolean esValido = true;
        if(!listaMurales.isEmpty()){
            for(Mural mural: listaMurales){
                if(mural.getNombre().equals(nombre)){
                    esValido = false;
                }
            }
        }
        return esValido;
    }
    
    public boolean validarNombreDisenador(String nombre){
        boolean esValido = true;
        if(!listaDisenadores.isEmpty()){
            for(Disenador disenador: listaDisenadores){
                if(disenador.getNombre().equals(nombre)){
                    esValido = false;
                }
            }
        }
        return esValido;
    }
    
    public ArrayList<Mural> muralesDelDisenador(Disenador dis){
        ArrayList<Mural> murales = new ArrayList<>();
        for(Mural mur: this.getListaMurales()){
            if(mur.getDisenador() == dis){
                murales.add(mur);
            }
        }
        return murales;
    }
    
    private void precargar(){
        Ficha SOL = new Ficha("SOL", "\\|/-*-/|\\", "..|...\\|/.--*--./|\\...|..", 'M');
        Ficha CUADRADO = new Ficha("CUADRADO", "+-+|.|+-+", "+---+|...||...||...|+---+", 'N');
        Ficha CORAZON = new Ficha("CORAZON", "*.****.*.", "**.************.***...*..", 'R');
        Ficha COPA = new Ficha("COPA", "\\./.|./_\\", "\\.../.\\./...|....|.../_\\.", 'C');
        Ficha ARBOL = new Ficha("ARBOL", ".^.^^^.|.", "..^...^^^.^^^^^..|.../.\\.", 'V');
        Ficha GATO = new Ficha("GATO", "^.^o.o=^=", "/\\_/\\(o.o).>^<../|\\../.\\.", 'A');
        Ficha DIAMANTE = new Ficha("DIAMANTE", ".*.*.*.*.", "..*...*.*.*...*.*.*...*..", 'G');
        Ficha VACIA = new Ficha("VACIA", ".........", ".........................", 'B');
        
        agregarFicha(SOL);
        agregarFicha(CUADRADO);
        agregarFicha(CORAZON);
        agregarFicha(COPA);
        agregarFicha(ARBOL);
        agregarFicha(GATO);
        agregarFicha(DIAMANTE);
        agregarFicha(VACIA);
    }
    
    public ArrayList<Mural> compararSimilitud(Ficha[][] subMural, Mural original){
        ArrayList<Mural> aRetornar = new ArrayList<>();
        for(Mural mur: this.listaMurales){
            if(mur != original){
                boolean buscando = true;
                int filas = subMural.length;
                int columnas = subMural[0].length;
                for(int f = 0; f + filas <= 10 && buscando; f++){
                    for(int c = 0; c + columnas <= 12 && buscando; c++){
                        boolean todosIguales = true;
                        for(int i = 0; i < filas && todosIguales; i++){
                            for(int j = 0; j < columnas && todosIguales; j++){
                                boolean iguales = subMural[i][j] == mur.getMural()[f + i][c + j];
                                if(!iguales){todosIguales = false;}
                            }
                        }
                        if(todosIguales){
                            buscando = false;
                        }
                    }
                }
                if(!buscando){
                    aRetornar.add(mur);
                }
            }
        }
        return aRetornar;
    }
}
