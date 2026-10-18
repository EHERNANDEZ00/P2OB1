
package interfaz;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import dominio.*;

public class Interfaz {
    
    private Sistema sist;
    
    public Interfaz(Sistema unSis){
        sist = unSis;
    }

    Scanner input = new Scanner(System.in);


    
    
    public void imprimirMenu(){
            System.out.println("======MENÚ======");
            System.out.println("0) Terminar");
            System.out.println("1) Información de autores del obligatorio");
            System.out.println("2) Registrar diseñador");
            System.out.println("3) Registrar ficha");
            System.out.println("4) Creación de mural");
            System.out.println("5) Modificar mural");
            System.out.println("6) Visualizar mural");
            System.out.println("7) Listado de diseñadores");
            System.out.println("8) Comparar similitud de murales");
            System.out.println("9) Visualizar todas las fichas");
    }  
    
    //Menu
    
    public void menu(){ 
        int opcion = -1;
        while(opcion!= 0){
            limpiar();
            imprimirMenu();
            opcion = pedirNumero("Ingrese la opción del menú que desea",0,9);
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
                    System.out.println("Opción incorrecta, vuelva a intentar");
                    break;
            }
        }        
    }
    
    //Metodos del menu
    
    public void informacionAutores(){
        limpiar();
        System.out.println("Eduardo Hernández - 370255");
        System.out.println("Matias Pintos - 379603");
        System.out.println("");
        System.out.println("Ingrese cualquier carácter para continuar");
        input.nextLine();
    }
    
    
    public void registrarDisenador(){
        limpiar();
        String nombre = pedirString("Ingrese el nombre del diseñador");
        boolean nombreValido = sist.validarNombreDisenador(nombre);
        while(!nombreValido){
            limpiar();
            nombre = pedirString("Ese nombre no es válido, elija otro");
            nombreValido = sist.validarNombreDisenador(nombre);
        }
        String email = pedirString("Ingrese el email del diseñador");
        String direccion = pedirString("Ingrese la dirección del diseñador");
        sist.agregarDisenador(new Disenador(nombre, email, direccion));
    }
    public void registrarFicha(){
            limpiar();
            String nombre = pedirString("Ingrese el nombre de la ficha: ").toUpperCase();
            boolean nombreOk = sist.validarNombreFicha(nombre);
            while(!nombreOk){
                nombre = pedirString("Una ficha con ese nombre ya existe, ingrese otro");
                nombreOk = sist.validarNombreFicha(nombre);
            }
            String color = pedirString("Ingrese el color de la ficha ingrese: \nR -> Rojo\nA -> Azul\nB -> Blanco\nN -> Negro\nM -> Amarillo\nV -> Verde\nG -> Magenta\nC -> Celeste");
            while(!(color.equals("R")|| color.equals("A")|| color.equals("B")|| color.equals("N")|| color.equals("M")|| color.equals("V")|| color.equals("G")) || color.equals("C")){
                limpiar();
                color = pedirString("Color no encontrado, ingrese \nR -> Rojo\nA -> Azul\nB -> Blanco\nN -> Negro\nM -> Amarillo\nV -> Verde\nG -> Magenta\nC -> Celeste");
            }
            char colorChar = color.charAt(0);
            String disenoChico = pedirString("Ingrese el diseño chico de la ficha (Nueve caracteres)");
            while(disenoChico.length() != 9){
                limpiar();
                disenoChico = pedirString("Ingrese una ficha del largo correcto, 9");
            }
            String disenoGrande = pedirString("Ingrese el diseño largo (Veinticinco caracteres)");
            while(disenoGrande.length() != 25){
                limpiar();
                disenoGrande = pedirString("Ingrese el diseño del largo correcto, 25");
            }
            sist.agregarFicha(new Ficha(nombre, disenoChico, disenoGrande, colorChar));

        }
    
    public void crearMural() {
        limpiar();
        if (!(sist.getListaDisenadores().isEmpty())) {
            String nMural = pedirString("Ingrese el nombre del mural");
            Boolean okM = sist.validarNombreMural(nMural);
            while (!okM) {
                limpiar();
                System.out.println("Ese nombre de mural ya se encuentra en uso");
                nMural = pedirString("Por favor, ingrese un nuevo nombre para el mural");
                okM = sist.validarNombreMural(nMural);
            }
            limpiar();
            for (int i = 0; i < sist.getListaDisenadores().size(); i++) {
                System.out.println(i + ") " + sist.getListaDisenadores().get(i).getNombre());
            }
            int indice = pedirNumero("Cuál es el diseñador?", 0, sist.getListaDisenadores().size() - 1);
            Disenador disenador = sist.getListaDisenadores().get(indice);
            limpiar();
            String formato = pedirString("Seleccione el tipo de formato\nD) Damero\nR) Random\nF) Alternando por filas\nB) Borde exterior\nM) Manual").toUpperCase();
            while (!(formato.equals("D") || formato.equals("R") || formato.equals("F") || formato.equals("B") || formato.equals("M"))) {
                limpiar();
                System.out.println("Ese formato no existe");
                formato = pedirString("Ingrese nuevamente una opción entre D,R,F,B,M");
            }
            char formatoChar = formato.charAt(0);
            Ficha fichaA = null;
            Ficha fichaB = null;
            int martin = 0;
            while (martin == 0) {
                limpiar();
                for (int i = 0; i < sist.getListaFichas().size(); i++) {
                    System.out.println(i + ") " + sist.getListaFichas().get(i).getNombre());
                }
                int aux = pedirNumero("Cuál ficha desea primero?", 0, sist.getListaFichas().size() - 1);

                fichaA = sist.getListaFichas().get(aux);
                limpiar();
                for (int i = 0; i < sist.getListaFichas().size(); i++) {
                    if (i != aux) {
                        System.out.println(i + ") " + sist.getListaFichas().get(i).getNombre());
                    }
                }
                int aux2 = pedirNumero("Cuál es la segunda ficha que desea?", 0, sist.getListaFichas().size() - 1);
                fichaB = sist.getListaFichas().get(aux2);

                martin = aux - aux2;
                if (martin == 0) {
                    System.out.println("Error, no puede tener un mural de dos fichas iguales");
                }
            }
            
            if(formatoChar != 'M'){
                sist.agregarMural(new Mural(nMural, disenador, formatoChar, fichaA, fichaB));
                
            } else {
                sist.agregarMural(new Mural(nMural, disenador, 'D', sist.getListaFichas().get(7), sist.getListaFichas().get(7)));
                boolean seguir = true;
                while(seguir){
                    limpiar();
                    int fila = pedirNumero("Ingrese la fila en la que se encuentra la posición que quiere cambiar (1 - 10)", 1, 10) -1;
                    int columna = pedirNumero("Ingrese la columna en la que se encuentra la posición que quiere cambiar (1 - 12)", 1, 12) -1;
                    if(sist.getListaMurales().get(sist.getListaMurales().size() -1).validarManual(fila, columna, sist.getListaFichas().get(7))){
                        limpiar();
                        System.out.println("0) " + fichaA.getNombre());
                        System.out.println("1) " + fichaB.getNombre());
                        int opcion = pedirNumero("Qué ficha desea agregar en este lugar?", 0, 1);
                        Ficha fichaAColocar = opcion == 0? fichaA : fichaB;
                        sist.getListaMurales().get(sist.getListaMurales().size() -1).cambiarPosicion(fila, columna, fichaAColocar);
                        int aSeguir = pedirNumero("Desea seguir haciendo cambios?\n0) No\n1) Sí", 0, 1);
                        if(aSeguir == 0){seguir = false;}
                    } else {
                        System.out.println("Ese espacio ya fue ocupado");
                        esperar();
                    }
                }
                for (Ficha[] linea : sist.getListaMurales().get(sist.getListaMurales().size()-1).getMural()) {
                    for (Ficha ficha : linea) {
                        disenador.agregarDatosFicha(ficha);
                    }
                }
            }
            imprimirMuralGrande(sist.getListaMurales().get(sist.getListaMurales().size()-1));
            imprimirMuralChico(sist.getListaMurales().get(sist.getListaMurales().size()-1)); 
        } else {
            System.out.println("No hay diseñadores, ingrese un diseñador para poder crear un mural");      
        } 
        esperar();
    }

    

    
    
    public void modificarMural(){
        limpiar();
        if(sist.getListaMurales().isEmpty()){
            System.out.println("No hay murales para modificar");
            esperar();
        } else {
            int contador = 0;
            for(Mural mur: sist.getListaMurales()){
                System.out.println(contador+ ") " + mur.getNombre() + " desarrollado por: " + mur.getDisenador().getNombre());
            }
            int indexMural = pedirNumero("Seleccione un Mural: ", 0, sist.getListaMurales().size() -1);
            Mural muralAModificar = sist.getListaMurales().get(indexMural);
            boolean modificando = true;
            while (modificando){
                int opcion = pedirNumero("Ingrese una opción\n0) Volver\n1) Modificar posición\n2) Modificar ficha\n3) Restaurar", 0, 4);
                switch (opcion){
                    case 0:
                        modificando = false;
                        break;
                    case 1:
                        modificarPosicion(muralAModificar);
                        break;
                    case 2:
                        modificarFicha(muralAModificar);
                        break;
                    case 3:
                        muralAModificar.restaurar();
                        break;
                }
                for(Ficha[] linea: muralAModificar.getMural()){
                    for(Ficha ficha: linea){
                        muralAModificar.getDisenador().agregarDatosFicha(ficha);
                    }
                }
                limpiar();
                imprimirMuralChico(muralAModificar);
                imprimirMuralGrande(muralAModificar);
            }
        }
    }
    
    public void verMural(){
        limpiar();
        for(int i = 0; i < sist.getListaDisenadores().size(); i++){
            System.out.println(i + ") " + sist.getListaDisenadores().get(i).getNombre());
        }
        int indexDisenador = pedirNumero("Seleccione un diseñador (0 - " + (sist.getListaDisenadores().size() -1), 0, sist.getListaDisenadores().size() -1);
        Disenador dis = sist.getListaDisenadores().get(indexDisenador);
        ArrayList<Mural> murales = sist.muralesDelDisenador(dis);
        if(murales.isEmpty()){
            System.out.println("Este diseñador aun no tiene murales para mostrar");
            esperar();
        } else {
            int contador = 0;
            for(Mural mur : murales){
                System.out.println(contador + ") " + mur.getNombre());
                contador ++;
            }
            int indexMural = pedirNumero("Seleccione un mural: ", 0, murales.size() -1);
            Mural muralAMostrar = murales.get(indexMural);
            String opcion = pedirString("Desea visualizarlo en formato chico o grande?\nC) Chico\nG) Grande").toUpperCase();
            while(!opcion.equals("C") && !opcion.equals("G")){
                opcion = pedirString("Opción invalida, ingrese C o G").toUpperCase();
            }
            boolean mostrandoG = opcion.equals("G");
            while (!opcion.equals("S")){
                if(mostrandoG){
                    limpiar();
                   imprimirMuralGrande(muralAMostrar);
                } else {
                    limpiar();
                    imprimirMuralChico(muralAMostrar);
                }
                mostrandoG = !mostrandoG;
                System.out.println("Presione enter para alternar entre tamaños de mural, presione S para salir");
                opcion = input.nextLine();
            }
        }
        
    }
    
    public void listaDisenadores(){
        limpiar();
        for(Disenador dis: sist.getListaDisenadores()){
            System.out.println(dis.getNombre());
            System.out.println("Cantidad de murales: " + dis.getCantidadMurales());
            System.out.println("Email: " + dis.getEmail());
            System.out.println("Dirección: " + dis.getDireccion());
            System.out.println("Cantidad de fichas usadas: " + dis.getNumeroFichas());
            System.out.println("Cantidad de colores usados: " + dis.getNumeroColores());
        }
        esperar();
    }
    
  public void compararMurales(){
        if (sist.getListaMurales().size()>1){
            
      
            for(int i = 0; i < sist.getListaMurales().size();i++){
                System.out.println(i + ") " + sist.getListaMurales().get(i).getNombre());
            }
            int indexMural = pedirNumero("Seleccione el mural del cual buscar patrones similares en otros", 0, sist.getListaMurales().size() -1);
            Mural muralAComparar = sist.getListaMurales().get(indexMural);
            int opcion = pedirNumero("Desea buscar en la representación grande o chica?\n 0) Grande\n1) chica", 0, 1);
            boolean grande = opcion == 0;
            if(grande){imprimirMuralGrande(muralAComparar);} else {imprimirMuralChico(muralAComparar);}
            int filaInicio = pedirNumero("Seleccione la fila de inicio para comparar",1,10);
            int columnaInicio = pedirNumero("Seleccione la columna de inicio para comparar",1,12);
            int filaFinal = pedirNumero("Cuantas filas a partir de la seleccionada quiere comparar",1,10);
            while(filaInicio+filaFinal > 10){
                System.out.println("Esta cantidad de filas ingresadas excede la cantidad de filas del mural");
            }
            int columnaFinal = pedirNumero("Cuantas columnas a partir de la seleccionada quiere comparar",1,12);
            while(columnaInicio+columnaFinal > 10){
                System.out.println("Esta cantidad de columnas ingresadas excede la cantidad de columnas del mural");
            }
            Ficha[][] subMural = muralAComparar.obtenerSubMural(filaInicio,columnaInicio, filaFinal, columnaFinal);
            ArrayList<Mural> listaMurales = sist.compararSimilitud(subMural, muralAComparar);
            if (listaMurales.isEmpty()) {
                System.out.println("No hay coincidencias");
            }else{
                for(Mural mur : listaMurales){
                    System.out.println(mur.getNombre());
                }
            }
        }else{
            System.out.println("No hay sufientes mutales para comparar");
            esperar();
        }
    }

    public void verFichas(){
        limpiar();
        for(Ficha ficha : sist.getListaFichas()){
            System.out.println("Ficha: " + ficha.getNombre());
            System.out.println("Color: " + ficha.getColor());
            System.out.println("Tamaño chico: ");
            imprimirFicha(ficha, false);
            System.out.println("Tamaño grande: ");
            imprimirFicha(ficha, true);
        }
        esperar();
    }
    
    
    public Ficha pedirFicha(){
        for(int i = 0; i < sist.getListaFichas().size(); i++){
            System.out.println((i + 1) + ") " + sist.getListaFichas().get(i).getNombre());
        }
        int indexFicha = pedirNumero("Seleccione la ficha (1 -" + sist.getListaFichas().size() + "): ", 1, sist.getListaFichas().size())-1;
        return sist.getListaFichas().get(indexFicha);
    }
    
    
    //Metodos para pedir datos
    public void esperar(){
        System.out.println("Presione cualquier tecla para continuar");
        input.nextLine();
    }
    
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
    
    //Helpers para modificar mural
    
    public void modificarPosicion(Mural mur){
        int fila = pedirNumero("Ingrese la fila de la ficha a modificar (1 - 10): ", 1, 10) - 1;
        int columna = pedirNumero("Ingrese la columna de la ficha a modificar (1 - 12): ",1, 12) -1;
        Ficha ficha = pedirFicha();
        mur.cambiarPosicion(fila, columna, ficha);
    }
    public void modificarFicha(Mural mur){
        int contador = 1;
        for(Ficha ficha : mur.fichasContenidas()){
            System.out.println(contador + ") " + ficha.getNombre());
            contador++;  
        }
        int indexFicha = pedirNumero("Seleccione la ficha que desea cambiar del mural: ", 1, mur.fichasContenidas().size()) -1;
        Ficha fichaACambiar = mur.fichasContenidas().get(indexFicha);
        System.out.println("Elija la nueva ficha");
        Ficha fichaNueva = pedirFicha();
        mur.cambiarFicha(fichaACambiar, fichaNueva);
    }
    //Metodos para imprimir
    
    public void imprimirFicha(Ficha ficha, boolean grande){
        int cantPorLinea = 3;
        int cantMax = 9;
        String delQueImprimir = ficha.getRepChica();
        if(grande){
            cantPorLinea = 5;
            cantMax = 25;
            delQueImprimir = ficha.getRepGrande();
        }
        for(int i = 0; i < cantMax; i++){
            char aImprimir = delQueImprimir.charAt(i);
            if (aImprimir == '.'){
                aImprimir = ' ';
            }
            if( i != 0 && i % cantPorLinea == 0){
                System.out.println("");
                System.out.print(darColor(ficha.getColor()) + aImprimir);
            } else {
                 System.out.print(darColor(ficha.getColor()) + aImprimir);
            }
        }
        System.out.println("\u001B[0m");  
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
                retorno += "\u001B[36m";
                break;
                
        }
        return retorno;
    }
    
    public void imprimirMuralGrande(Mural mur){
        for(Ficha[] linea: mur.getMural()){
            for(int i = 0; i < 25; i += 5){
                String lineaAImprimir = "";
                for(Ficha ficha: linea){
                    lineaAImprimir += darColor(ficha.getColor());
                    String lineaAVerificar = ficha.getRepGrande().substring(i, i + 5);
                    for(int l = 0; l < 5; l++){
                        lineaAImprimir += lineaAVerificar.charAt(l) == '.' ? " " : lineaAVerificar.charAt(l);
                    }
                }
                System.out.println(lineaAImprimir);
            }
        }
        System.out.println("\u001B[0m");  
    }
    public void imprimirMuralChico(Mural mur){
        for(Ficha[] linea: mur.getMural()){
            for(int i = 0; i < 9; i += 3){
                String lineaAImprimir = "";
                for(Ficha ficha: linea){
                    lineaAImprimir += darColor(ficha.getColor());
                    String lineaAVerificar = ficha.getRepChica().substring(i, i + 3);
                    for(int l = 0; l < 3; l++){
                        lineaAImprimir += lineaAVerificar.charAt(l) == '.' ? " " : lineaAVerificar.charAt(l);
                    }
                }
                System.out.println(lineaAImprimir);
            }
        }
        System.out.println("\u001B[0m");  
    }
    
    public void limpiar(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
    }
}


