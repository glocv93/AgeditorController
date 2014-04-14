/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ageditorcontroller;
import java.util.*;

import ageditormodel.Map;
import ageditormodel.Tyle;
/**
 *
 * @author alulab11
 */
public class Paintor {
    private int width=7;
    private int height=7;
    private int x=4;
    private int y=4;
    public int getWidth() {
        return width;
    }
    public void setWidth(int widht) {
        this.width = widht;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public void drawMap(Map map){
        this.setWidth(map.getWidth());
        this.setHeight(map.getHeight());
        this.setX((map.getWidth()*2)-1);
        this.setY((map.getHeight()*2)-1);
        Map isomap=new Map();
        isomap.setWidth(x);
        isomap.setHeight(y);
        Tyle isoMtyle[][] = new Tyle[x][y];
        
        //primero lo lleno con 0's
        for(int i=0;i<isomap.getWidth();i++)
            for(int j=0;j<isomap.getHeight();j++){
                isoMtyle[i][j]=new Tyle();
                isoMtyle[i][j].setCharacter('.');
            }
                
        //despues lo lleno con los datos del mapa 
        int a=map.getWidth(),b=map.getHeight();
        int rela=(x-1)/2,relb=y-1;
        char charo;
        
        int pini=rela, pinj=relb;
        
        try {
             for(int i=a-1;i>=0;i--){
                    
                    rela=pini;
                    relb=pinj;
                    pini--;
                    pinj--;
                    for(int j=b-1;j>=0;j--){
                        charo =map.getTyle()[i][j].getCharacter();
                        isoMtyle[rela][relb].setCharacter(charo);      
                        isoMtyle[rela][relb].setX(rela);
                        isoMtyle[rela][relb].setY(relb);
                        rela++;
                        relb--;
                    }
                }
        } catch (Exception e) {
          
        }
               
        //lleno isomap acorde a map
        isomap.setTyle(isoMtyle);
        System.out.println(isomap);
        
    }
}
