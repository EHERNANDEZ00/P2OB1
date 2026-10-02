
package interfaz;
import dominio.Sistema;

public class Inicio {
    public static void main(String[] Args){
        Sistema sis = new Sistema();
        System.out.println(sis.getListaFichas().get(3));
    }
}
