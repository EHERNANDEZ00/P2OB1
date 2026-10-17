
package interfaz;
import dominio.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Inicio {
    
       public static void main(String[] Args) throws Exception{
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            Sistema sis = new Sistema();
            Interfaz inte = new Interfaz(sis);
            inte.menu();
        
    } 
}
