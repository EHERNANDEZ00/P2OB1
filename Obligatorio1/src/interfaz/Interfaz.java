
package interfaz;
import java.util.InputMismatchException;
import java.util.Scanner;
import dominio.Sistema;

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
                if(min >= resultado && max <= resultado ){
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
}
