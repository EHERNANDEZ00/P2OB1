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
    
    private void agregarFicha(Ficha unaFicha){
        listaFichas.add(unaFicha);
    }
    
    private void precargar(){
        Ficha SOL = new Ficha("SOL", "\\|/-*-/|\\", "..|...\\|/.--*--./|\\...|..", 'M');
        Ficha CUADRADO = new Ficha("CUADRADO", "+-+|.|+-+", "+---+|...||...||...|+---+", 'N');
        Ficha CORAZON = new Ficha("CORAZON", "*.****.*.", "**.************.***...*..", 'C');
        Ficha COPA = new Ficha("COPA", "\\./.|./_\\", "\\.../.\\./...|....|.../_\\.", 'C');
        Ficha ARBOL = new Ficha("ARBOL", ".^.^^^.|.", "..^...^^^.^^^^^..|.../.\\.", 'V');
        Ficha GATO = new Ficha("GATO", "^.^o.o=^=", "/\\_/\\(o.o).>^<../|\\../.\\.", 'A');
        Ficha DIAMANTE = new Ficha("DIAMANTE", ".*.*.*.*.", "..*...*.*.*...*.*.*...*..", 'M');
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
    
}
