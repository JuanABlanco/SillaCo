/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco.BackEnd;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Arturo Blanco
 */
public class PAsientos extends Productor{
    
    private int AlmacenA[]; 
    
    public PAsientos(int AlmacenA[],FabricaFrame fabrica, Semaphore SE, Semaphore SP, Semaphore SC, int K, int In, int Out) {
        super(fabrica, SE, SP, SC, 3, 1, K, In, Out);
        this.AlmacenA = AlmacenA;
    }
    //Getters y Setters
    public int[] getAlmacenA() {
        return AlmacenA;
    }

    public void setAlmacenA(int[] AlmacenA) {
        this.AlmacenA = AlmacenA;
    }
    //Metodos
    @Override
    public void run(){
        while(true){
            try {
                SP.acquire(1);
                SE.acquire(1);
                    this.sleep((1000*getJornada())/getK());
                    producir();
                SE.release();
                SC.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(PAsientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void producir(){
        AlmacenA[In]=1;
        In = (In+1)%40;
        int num = Integer.parseInt(this.fabrica.getLblAAsientos().getText())+1;
        this.fabrica.getLblAAsientos().setText(Integer.toString(num));
    }
    
    
}
