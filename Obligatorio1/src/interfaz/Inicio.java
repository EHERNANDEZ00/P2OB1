
package interfaz;
import dominio.*;

public class Inicio {
       public static void main(String[] Args){
            Sistema sis = new Sistema();
            Interfaz inte = new Interfaz(sis);
            inte.menu();
        
    } 
}
