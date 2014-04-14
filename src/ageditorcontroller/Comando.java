package ageditorcontroller;

/**
 *
 * @author GG
 */
import java.util.*;

public class Comando {
    
    Scanner buffer = new Scanner(System.in);
    
    public void MenuPrincipal() {
        System.out.println();
        System.out.println("1) Change Ground Tyle: CTT");
        System.out.println("2) Agregar Elementos : AE");
        System.out.println("3) Quitar Elementos : QE");
        System.out.println("4) Agregar Personajes : AP");
        System.out.println("5) Quitar Personajes : QP");
        System.out.println("6) Mover Elementos : ME");
        System.out.println("7) Mover Personajes : MP");
        System.out.println("8) Salir del Juego: GG");
        System.out.println();
    }
    
    public void MenuTerrenos() {
        System.out.println();
        System.out.println("1) Pasto : PASTO");
        System.out.println("2) Arena : ARENA");
        System.out.println("3) Hiele : HIELO");
        System.out.println("4) Regresar: BACK");
        System.out.println();
    }
    
    public void MenuElementos() {
        System.out.println();
        System.out.println("1) Estructuras : EST");
        System.out.println("2) Recursos : REC");
        System.out.println("3) Regresar: BACK");
        System.out.println();
    }
    
    public void MenuPersonajes() {
        System.out.println();
        System.out.println("1) Guerrero : GUE");
        System.out.println("2) Chaman : CHA");
        System.out.println("3) Inca: INC");
        System.out.println("4) Regresar: BACK");
        System.out.println();
    }
    
    public int Interpretar(String comando) {
        
        if (comando.compareTo("GG") == 0) {
            System.out.println("Eligio salir del juego.");
            System.exit(0);
        } else if (comando.compareTo("CTT") == 0) {
            return 1;
        } else if (comando.compareTo("AE") == 0) {
            return 2;
        } else if (comando.compareTo("QE") == 0) {
            return 3;
        } else if (comando.compareTo("AP") == 0) {
            return 4;
        } else if (comando.compareTo("QP") == 0) {
            return 5;
        } else if (comando.compareTo("ME") == 0) {
            return 6;
        } else if (comando.compareTo("MP") == 0) {
            return 7;
        }
        return -1;
    }
    
    public int InterpretarTerreno(String comando) {
        
        if (comando.compareTo("BACK") == 0) {
            return 4;
        } else if (comando.compareTo("PASTO") == 0) {
            return 1;
        } else if (comando.compareTo("ARENA") == 0) {
            return 2;
        } else if (comando.compareTo("HIELO") == 0) {
            return 3;
        } 
        return -1;
    }
    
    public int InterpretarElementos(String comando) {
        
        if (comando.compareTo("BACK") == 0) {
            return 4;
        } else if (comando.compareTo("EST") == 0) {
            return 1;
        } else if (comando.compareTo("REC") == 0) {
            return 2;
        } 
        return -1;
    }
    
    public int InterpretaPersonajes(String comando) {
        
        if (comando.compareTo("BACK") == 0) {
            return 4;
        } else if (comando.compareTo("GUE") == 0) {
            return 1;
        } else if (comando.compareTo("CHA") == 0) {
            return 2;
        }  else if (comando.compareTo("INC") == 0) {
            return 3;
        } 
        return -1;
    }
}