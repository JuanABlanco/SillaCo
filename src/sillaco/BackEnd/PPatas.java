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
public class PPatas extends Productor{
    private int AlmacenP[];

    public PPatas(int[] AlmacenP, FabricaFrame fabrica, Semaphore SE, Semaphore SP, Semaphore SC, int K, int In, int Out) {
        super(fabrica, SE, SP, SC, 1, 1, K, In, Out);
        this.AlmacenP = AlmacenP;
    }
    
    //Setters y Getters

    public int[] getAlmacenP() {
        return AlmacenP;
    }

    public void setAlmacenP(int[] AlmacenP) {
        this.AlmacenP = AlmacenP;
    }
    //Metodos
    @Override
    public void run(){
        while(true){
        try {
                SP.acquire(1);
                SE.acquire(1);
                    this.sleep(1000*getJornada());
                    producir();
                SE.release();
                SC.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(PPatas.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }
    public void producir(){
        AlmacenP[In]=1;
        In = (In+1)%50;
        int num = Integer.parseInt(this.fabrica.getLblAPatas().getText())+1;
        this.fabrica.getLblAPatas().setText(Integer.toString(num));
    }
}
