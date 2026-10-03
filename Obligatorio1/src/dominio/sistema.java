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
    }
    public void agregarDisenador(Disenador unDisenador){
        listaDisenadores.add(unDisenador);
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
