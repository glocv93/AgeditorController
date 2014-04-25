
package ageditorcontroller;

import ageditormodel.Map;
import ageditormodel.Person;
import ageditormodel.Resource;
import ageditormodel.Structure;
import java.util.*;

public class Editor {    
    Comando comando=new Comando();    
    
    
    public Editor(){
       
        Scanner buffer = new Scanner(System.in);
        Intro intro=new Intro();
        
        String opcion;
        int op;
        
        intro.Inicio();
        opcion = buffer.nextLine();
        op = (Integer.parseInt(opcion));
        if (op == 1) {
            
            intro.Historia();
            opcion = buffer.nextLine();
            op = (Integer.parseInt(opcion));
            if (op == 1){
                createMap();
            }else if (op == 2) {
                System.exit(0);
            }else {
                System.out.println("No es una opción válida");
            }
            
        } else if (op == 2) {
            System.exit(0);
        }else {
            System.out.println("No es una opción válida");
        }
        
    }
    
    public void createMap(){
        int dimension1,dimension2;
        while (true) {
            System.out.println("Ingrese la dimension vertical del mapa");
            Scanner scanner = new Scanner(System.in);
            dimension1 = scanner.nextInt();
            System.out.println("Ingrese las dimension horizontal del mapa");
            dimension2 = scanner.nextInt();
            if ((dimension1 >= 4)&&(dimension2 >= 4)) break;
        }
        
        Map map= new Map(dimension1,dimension2);
        System.out.print("Mapa generado es de:");
        System.out.print(dimension1);
        System.out.print("x");
        System.out.print(dimension2);
        System.out.println();
        Paintor OnlyPainter=new Paintor();
        OnlyPainter.drawMap(map);
        while(true)
            Start(map);
        
    }
   
    //Nuevo
    
    public void Start(Map mapa){
        
        Scanner buffer = new Scanner(System.in);
        String nombre, opcion, opcionSub;
        
        int op, opSub, posx, posy, valor; 
        int nposx,nposy;
        
        comando.MenuPrincipal();
        opcion = buffer.nextLine();
        op=comando.Interpretar(opcion);
        
        
        if(op ==1){ //Agregar Terreno
            
            while(true){
                System.out.println("Ingrese posiciones x e y donde agregar terreno:");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if(valor == 1 ) break;
            }
            
            comando.MenuTerrenos();
            while(true){
                opcionSub = buffer.nextLine();
                if(opcionSub.length()!=0) break;
            }
                opSub = comando.InterpretarTerreno(opcionSub);
            if (opSub == 1){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('P'); //P de pasto
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                mapa.toString();
            }
            else  if (opSub == 2){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('A'); //A de arena
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                mapa.toString();
            }
            else if(opSub ==3){
                mapa.getTyle()[posx-1][posy-1].setCharacter('H'); //H de Hielo
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
            }
            else if(opSub==4) comando.MenuPrincipal();
            System.out.println("");
            
            
        }
        
        
        else if(op ==2){  //opcion ingresar elemento
            while(true){
                System.out.println("Ingrese posiciones x e y donde agregar el elemento:");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if(valor == 1 ) break;
            }
            
            comando.MenuElementos();
            while(true){
                opcionSub = buffer.nextLine();
                if(opcionSub.length()!=0) break;
            }
            opSub = comando.InterpretarElementos(opcionSub);
            if (opSub == 1){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('E'); //E de estructura 
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                //anadir objetos al mapa
                
                //crear una por default:
                Structure structure = new Structure();
                
                //crear una con parametros
                Structure structure2=new Structure();
                structure2.setAttackCapacity(1);
                structure2.setResistanceCapacity(5);
                structure2.setStorageCapacity(4);
                structure2.setX(posx);
                structure2.setY(posy);
                
                mapa.getObjects().add(structure2);
                
                mapa.toString();
            }
            else  if (opSub == 2){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('R'); //R de Recurso 
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                
                 Resource resource= new Resource();
                 resource.setAlimento(8);
                 resource.setMadera(9);
                 resource.setOro(20);
                 resource.setPiedra(15);
                 resource.setX(posx);
                 resource.setY(posy);
                 mapa.getObjects().add(resource);
                mapa.toString();
            }
            else if(opSub ==3) comando.MenuPrincipal();
            
            System.out.println("");
        }
        
        else if(op == 3){ //opcion quitar elemento
            
             while(true){
                System.out.println("Ingrese posiciones x e y donde quitar el elemento:");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if(valor == 1 ) break;
                else System.out.println("Usuario, no hay ningun elemento en esa posicion");
            }
            
             mapa.getTyle()[posx-1][posy-1].setCharacter('.');
             Paintor OnlyPainter=new Paintor();
             OnlyPainter.drawMap(mapa);
            
             
             
        }
        
        else if(op == 4){ //opcion agregar personaje
            
             while(true){
                System.out.println("Ingrese posiciones x e y donde agregar el elemento:");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if(valor == 1 ) break;
                else System.out.println("Usuario, esta posicion esta ocupada");
            }
            
            comando.MenuPersonajes();
            while(true){
                opcionSub = buffer.nextLine();
                if(opcionSub.length()!=0) break;
            }
            opSub = comando.InterpretaPersonajes(opcionSub);
            if (opSub == 1){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('G'); //G de guerrero
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                Person person = new Person();
                person.setAttackCapacity(5);
                person.setAttackRange(5);
                person.setResistanceCapacity(10);
                person.setX(posx);
                person.setY(posy);
                mapa.getObjects().add(person);
                
                
                mapa.toString();
            }
            else  if (opSub == 2){
                
                mapa.getTyle()[posx-1][posy-1].setCharacter('C'); //C de chaman 
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
                mapa.toString();
            }
            else if(opSub ==3){
                mapa.getTyle()[posx-1][posy-1].setCharacter('I'); //I de Inca
                Paintor OnlyPainter=new Paintor();
                OnlyPainter.drawMap(mapa);
            }
            else if(opSub==4) comando.MenuPrincipal();
            System.out.println("");
            
            
        }
        
        
        else if(op == 5){ //opcion quitar personaje
            
             while(true){
                System.out.println("Ingrese posiciones x e y donde quitar el personaje:");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if(valor == 1 ) break;
                else System.out.println("Usuario, no hay ningun personaje en esa posicion");
            }
            
             mapa.getTyle()[posx-1][posy-1].setCharacter('.');
             Paintor OnlyPainter=new Paintor();
             OnlyPainter.drawMap(mapa);
            
            
        }
        
        else if(op == 6) {
            
            while(true){
                System.out.println("Ingrese posiciones x e y del elemento a mover");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if (valor == 1) break;
                else System.out.println("Usuario, no hay ningun elemento en esa posicion");
            }
            
            while(true){
                System.out.println("Ingrese nuevas posiciones \"x\" e \"y\" para el elemento a mover");
                nposx= buffer.nextInt();
                nposy = buffer.nextInt();

                valor = verificarMov(mapa,op,nposx,nposy);
                if (valor == 1) break;
                else System.out.println("Usuario, posicion inaccesible");
            }
            int posObj=0;
            for(int i=0;i<mapa.getObjects().size();i++)
                if(mapa.getObjects().get(i).getX()==posx && mapa.getObjects().get(i).getY()==posy){
                    posObj=i;break;
                }
            mapa.getObjects().get(posObj).setX(nposx);
            mapa.getObjects().get(posObj).setY(nposy);
            mapa.getTyle()[nposx-1][nposy-1].setCharacter(mapa.getTyle()[posx-1][posy-1].getCharacter());
            mapa.getTyle()[posx-1][posy-1].setCharacter('.');
            
             Paintor OnlyPainter=new Paintor();
             OnlyPainter.drawMap(mapa);
                   
        }
        
       if(op==7){
           
           while(true){
                System.out.println("Ingrese posiciones x e y del personaje a mover");
                posx= buffer.nextInt();
                posy = buffer.nextInt();

                valor = verificarPos(mapa,op,posx,posy);
                if (valor == 1) break;
                else System.out.println("Usuario, no hay ningun personaje en esa posicion");
            }
            
            while(true){
                System.out.println("Ingrese nuevas posiciones \"x\" e \"y\" para el personaje a mover");
                nposx= buffer.nextInt();
                nposy = buffer.nextInt();

                valor = verificarMov(mapa,op,nposx,nposy);
                if (valor == 1) break;
                else System.out.println("Usuario, posicion inaccesible");
            }
            int posObj=0;
            for(int i=0;i<mapa.getObjects().size();i++)
                if(mapa.getObjects().get(i).getX()==posx && mapa.getObjects().get(i).getY()==posy){
                    posObj=i;break;
                }
            mapa.getObjects().get(posObj).setX(nposx);
            mapa.getObjects().get(posObj).setY(nposy);
            mapa.getTyle()[nposx-1][nposy-1].setCharacter(mapa.getTyle()[posx-1][posy-1].getCharacter());
            mapa.getTyle()[posx-1][posy-1].setCharacter('.');
            
             Paintor OnlyPainter=new Paintor();
             OnlyPainter.drawMap(mapa);
             
           
       }
       
        
        
    }
    
    private int verificarMov(Map mapa, int op, int posx, int posy){
        
        
         
        if ((mapa.getTyle()[posx-1][posy-1].getCharacter() == '.')) {
            return 1;
        }
        else return 0;

            
        
        
    }
    
    private int verificarPos(Map mapa, int op, int posx, int posy) {
        
        if((posx<=mapa.getWidth() && posx >= 0 ) && (posy<=mapa.getHeight()&&posy>=0)){
            if(op==1 || op ==2 || op ==4){
                if(mapa.getTyle()[posx-1][posy-1].getCharacter()=='.'){
                    return 1;
                }
                else return 0;
            }
            else if(op ==3  || op == 5){

                if(mapa.getTyle()[posx-1][posy-1].getCharacter()!='.'){
                    return 1;                
                }
                else return 0;
            }
            else if(op == 6){
                if ((mapa.getTyle()[posx-1][posy-1].getCharacter() == 'E') || (mapa.getTyle()[posx-1][posy-1].getCharacter() == 'R') ){
                    return 1;
                }
                else return 0;
            }
            else if(op == 7){
                if (mapa.getTyle()[posx-1][posy-1].getCharacter() == 'G'||mapa.getTyle()[posx-1][posy-1].getCharacter() == 'C'||
                        mapa.getTyle()[posx-1][posy-1].getCharacter() == 'I'){
                    return 1;
                }
                else return 0;
            }
            else return 0; 
        }
        else return 0;
        
    }
    
    
}
