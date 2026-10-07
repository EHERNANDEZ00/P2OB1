
package interfaz;
import dominio.*;

public class Inicio {
       public static void main(String[] Args){
           System.out.println("yeaaaa");
            Sistema sis = new Sistema();
            Interfaz inte = new Interfaz(sis);
            System.out.println("yaaa");
            for(Ficha ficha: sis.getListaFichas()){
                System.out.println(ficha.imprimir(true));
            }
        
    } 
}
