/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import sillaco.FabricaFrame;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sillaco.SillaCo.PP;

/**
 *
 * @author Juan Arturo Blanco
 */
public class PPatas extends Productor{
    private int AlmacenP[];
    volatile boolean ejecutar = true;
    private boolean pausa=false;
    
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
        while(ejecutar){
        try {
                SP.acquire(1);
                SE.acquire(1); 
                    producir();
                SE.release();
                SC.release();
                this.sleep((1000*getJornada())/getK());
                synchronized(this){
                    if (pausa)
                        this.wait();
                        
                }

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
    public void contratar(int cant){
        for(int j =0; j<cant; j++){
            boolean contratado = false;
            for(int i=0; i<10; i++){
                if(PP[i] == null && !contratado){
                    PP[i] = new PPatas(AlmacenP,fabrica,SE,SP,SC,K,In,Out);
                    PP[i].start();
                    contratado=true;
                    int num = Integer.parseInt(this.fabrica.getLblPPatas().getText())+1;
                    this.fabrica.getLblPPatas().setText(Integer.toString(num));
                } else if(contratado){
                    break;
                }
            }
        }
    }
    public void despedir(int cant){
        for(int j =0; j<cant; j++){
            boolean despedido = false;
            for(int i=0; i<10; i++){
                if(PP[i] != null && !despedido){
                    PP[i].ejecutar = false;
                    PP[i] = null;
                    despedido=true;
                    int num = Integer.parseInt(this.fabrica.getLblPPatas().getText())-1;
                    this.fabrica.getLblPPatas().setText(Integer.toString(num));
                } else if(despedido){
                    break;
                }
            }
        }
    }
    public synchronized void pausa(){
        this.pausa=true;
    }
    public synchronized void reanudar(){
        this.pausa=false;
        notify();
    } 
}
