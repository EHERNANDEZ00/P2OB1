
package interfaz;
import java.util.InputMismatchException;
import java.util.Scanner;
import dominio.*;

public class Interfaz {
    
    private Sistema sist;
    
    public Interfaz(Sistema unSis){
        sist = unSis;
    }

    Scanner input = new Scanner(System.in);


    private int pedirNumero(String mensaje, int min, int max){
        int resultado = 0;
        boolean ok = true;
        while(ok){
            try{
                System.out.println(mensaje);
                resultado = input.nextInt();
                if(min <= resultado && max >= resultado ){
                    ok = false;
                    input.nextLine();
                }else{
                    System.out.println("Dato incorrecto, ingrese un valor dentro del parametro indicado.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Debe ingresar un número");
                input.nextLine();
            }
        }
        return resultado;
    }
    
    private String pedirString(String mensaje){
        String resultado = "";
        boolean ok = true;
        while (ok){
                System.out.println(mensaje);
                resultado = input.nextLine();
                if(resultado != null && !resultado.trim().isEmpty()){
                    ok = false;
                } else {
                    System.out.println("Dato incorrecto, debe ingresar algo");
                } 
        }
        return resultado;
    }
    
    public void imprimirMenu(){
            System.out.println("======MENU======");
            System.out.println("0) Terminar");
            System.out.println("1) Informacion de autores del obligatorio");
            System.out.println("2) Registrar diseñador");
            System.out.println("3) Registrar ficha");
            System.out.println("4) Creacion de mural");
            System.out.println("5) Modificar mural");
            System.out.println("6) Visualizar mural");
            System.out.println("7) Listado de diseñadores");
            System.out.println("8) Comparar similitud de murales");
            System.out.println("9) Visualizar todas las fichas");
    }  
    public void menu(){ 
        int opcion = -1;
        while(opcion!= 0){
            imprimirMenu();
            opcion = pedirNumero("Ingrese la opcion del menu que desea",0,9);
            switch(opcion){
                case 1:
                    informacionAutores();
                    break;
                case 2:
                    registrarDisenador();
                    break;
                case 3:
                    registrarFicha();
                    break;
                case 4:
                    crearMural();
                    break;
                case 5:
                    modificarMural();
                    break;
                case 6:
                    verMural();
                    break;
                case 7:
                    listaDisenadores();
                    break;
                case 8:
                    compararMurales();
                    break;
                case 9:
                    verFichas();
                    break;
                case 0:
                    System.out.println("-FIN-");
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentar");
                    break;
            }
        }        
    }
    
    public void informacionAutores(){
        System.out.println("Eduardo Hernandez - 370255");
        System.out.println("Matias Pintos - 379603");
        System.out.println("");
        System.out.println("Ingrese cualquier caracter para continuar");
        input.nextLine();
    }
    
    
    public void registrarDisenador(){
        String nombre = pedirString("Ingrese el nombre del disenador");
        boolean nombreValido = sist.validarNombreDisenador(nombre);
        while(!nombreValido){
            nombre = pedirString("Ese nombre no es valido, elija otro");
            nombreValido = sist.validarNombreDisenador(nombre);
        }
        String email = pedirString("Ingrese el email del disenador");
        String direccion = pedirString("Ingrese la direccion del disenador");
        sist.agregarDisenador(new Disenador(nombre, email, direccion));
    }
public void registrarFicha(){
        String nombre = pedirString("Ingrese el nombre de la ficha: ").toUpperCase();
        boolean nombreOk = sist.validarNombreFicha(nombre);
        while(!nombreOk){
            nombre = pedirString("Una ficha con ese nombre ya existe, ingrese otro");
            nombreOk = sist.validarNombreFicha(nombre);
        }
        String color = pedirString("Ingrese el color de la ficha ingrese: \nR -> Rojo\nA -> Azul\nB -> Blanco\nN -> Negro\nM -> Amarillo\nV -> Verde\nG -> Magenta\nC -> Celeste");
        while(!(color.equals("R")|| color.equals("A")|| color.equals("B")|| color.equals("N")|| color.equals("M")|| color.equals("V")|| color.equals("G")) || color.equals("C")){
            color = pedirString("Color no encontrado, ingrese \nR -> Rojo\nA -> Azul\nB -> Blanco\nN -> Negro\nM -> Amarillo\nV -> Verde\nG -> Magenta\nC -> Celeste");
        }
        char colorChar = color.charAt(0);
        String disenoChico = pedirString("Ingrese el diseno chico de la ficha (Nueve caracteres)");
        while(disenoChico.length() != 9){
            disenoChico = pedirString("Ingrese una ficha del largo correcto, 9");
        }
        String disenoGrande = pedirString("Ingrese el diseno largo (Veinticinco caracteres)");
        while(disenoGrande.length() != 25){
            disenoGrande = pedirString("Ingrese el diseno del largo corrrecto, 25");
        }
        sist.agregarFicha(new Ficha(nombre, disenoChico, disenoGrande, colorChar));

    }
    
    public void crearMural(){
        if(!(sist.getListaDisenadores().isEmpty())){
            
        String nMural = pedirString("Ingrese el nombre del mural");
        Boolean okM = sist.validarNombreMural(nMural);
        while(!okM){
            System.out.println("Ese nombre de mural ya se encuentra en uso");
            nMural = pedirString("Porfavor, ingrese un nuevo nombre para el mural");
            okM = sist.validarNombreMural(nMural);
        }
        
         
        for(int i = 0; i < sist.getListaDisenadores().size();i++){
            System.out.println(i+") "+sist.getListaDisenadores().get(i).getNombre());
        }
        int indice = pedirNumero("¿Cual es el diseñador?",0,sist.getListaDisenadores().size()-1);
        Disenador disenador = sist.getListaDisenadores().get(indice);
        
        
        
        String formato = pedirString("Tipo de formato");
        while(!(formato.equals("D") || formato.equals("R") || formato.equals("F") || formato.equals("B") || formato.equals("M"))){
            System.out.println("Ese formato no existe");
            formato = pedirString("Ingrese nuevamente una opcion entre D,R,F,B,M");
        }
        char formatoChar = formato.charAt(0);
        
        Ficha fichaA = null;
        Ficha fichaB = null;
        int martin = 0;
        while(martin == 0){
        for(int i = 0; i < sist.getListaFichas().size();i++){
            System.out.println(i+") "+sist.getListaFichas().get(i).getNombre());
        }
        int aux = pedirNumero("¿Cual es el diseñador?",0,sist.getListaFichas().size()-1);
        
        fichaA = sist.getListaFichas().get(aux);
        
        for(int i = 0; i < sist.getListaFichas().size();i++){
            if(i != indice){
                System.out.println(i+") "+sist.getListaFichas().get(i).getNombre());
            }
        }
        int aux2 = pedirNumero("¿Cual es el diseñador?",0,sist.getListaFichas().size()-1);
        fichaB = sist.getListaFichas().get(aux2);
        
        martin = aux-aux2;
        if(martin == 0){
            System.out.println("Error, no puede tener un mural de dos fichas iguales");
        }
        }
        
        sist.agregarMural(new Mural(nMural, disenador, formatoChar,fichaA,fichaB));
        }else{
            System.out.println("No hay diseñadores, ingrese un disenador para poder crear un mural");
        }
    }
    
    public void modificarMural(){
        if(sist.getListaMurales().isEmpty()){
            System.out.println("No hay murales para modificar");
        } else {
            int contador = 0;
            for(Mural mur: sist.getListaMurales()){
                System.out.println(contador+ ") " + mur.getNombre() + " desarrollado por: " + mur.getDisenador().getNombre());
            }
            int indexMural = pedirNumero("Seleccione un Mural: ", 0, sist.getListaMurales().size() -1);
            Mural muralAModificar = sist.getListaMurales().get(indexMural);
            boolean modificando = true;
            while (modificando){
                int opcion = pedirNumero(""Ingrese una opcion\n0) Volver\n1) Modificar posicion\n2) Modificar ficha\n3) Restaurar"", 0, 4);
                switch (opcion){
                    case 0:
                        modificando = false;
                        break;
                    case 1:
                        modificarPosicion();
                        break;
                    case 2:
                        ModificarFicha();
                    case 3
                }
            }
        }
    }
    
    public void verMural(){
        
    }
    
    public void listaDisenadores(){
        for(Disenador dis: sist.getListaDisenadores()){
            System.out.println(dis);
        }
    }
    
    public void compararMurales(){
        
    }
    
    public void verFichas(){
        for(Ficha ficha : sist.getListaFichas()){
            System.out.println(ficha);
            
        }
    }
    
}


