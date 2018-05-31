/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sillaco.SillaCo.Ensam;

/**
 *
 * @author Juan Arturo Blanco
 */
public class Ensamblador extends Thread{
    private Semaphore SES;
    private Semaphore SPS;
    private Semaphore SCS;
    private int InS;
    private int OutS;
    
    private Semaphore SEP;
    private Semaphore SPP;
    private Semaphore SCP;
    private int InP;
    private int OutP;
    
    private Semaphore SEA;
    private Semaphore SPA;
    private Semaphore SCA;
    private int InA;
    private int OutA;
    
    private int K;
    private FabricaFrame fabrica;
    
    private int AlmacenP[];
    private int AlmacenA[];
    private int AlmacenS[];
    
    volatile boolean ejecutar = true;
    private boolean pausa=false;

    public Ensamblador(Semaphore SES, Semaphore SPS, Semaphore SCS, int InS, int OutS, Semaphore SEP, Semaphore SPP, Semaphore SCP, int InP, int OutP, Semaphore SEA, Semaphore SPA, Semaphore SCA, int InA, int OutA, int K, FabricaFrame fabrica, int[] AlmacenP, int[] AlmacenA, int[] AlmacenS) {
        this.SES = SES;
        this.SPS = SPS;
        this.SCS = SCS;
        this.InS = InS;
        this.OutS = OutS;
        this.SEP = SEP;
        this.SPP = SPP;
        this.SCP = SCP;
        this.InP = InP;
        this.OutP = OutP;
        this.SEA = SEA;
        this.SPA = SPA;
        this.SCA = SCA;
        this.InA = InA;
        this.OutA = OutA;
        this.K = K;
        this.fabrica = fabrica;
        this.AlmacenP = AlmacenP;
        this.AlmacenA = AlmacenA;
        this.AlmacenS = AlmacenS;
    }

    
    //Metodos
    @Override
    public void run(){
        while(ejecutar){
            try {
                
                
                SCA.acquire(1);
                SEA.acquire(1);
                    consumirA();
                SEA.release();
                SPA.release();

                SCP.acquire(4);
                SEP.acquire(1);
                    consumirP();
                SEP.release();
                SPP.release(4);

                this.sleep(2000/K);

                SPS.acquire(1);
                SES.acquire(1);
                    ensamblar();
                SES.release();
                SCS.release();
                synchronized(this){
                    if (pausa)
                        this.wait();
                        
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void ensamblar(){
        AlmacenS[InS]=1;
        InS=(InS+1)%100;
        int num = Integer.parseInt(this.fabrica.getLblASillas().getText())+1;
        this.fabrica.getLblASillas().setText(Integer.toString(num));
    }
    public void consumirP (){
        
        AlmacenP[OutP]=0;
        AlmacenP[(OutP+1)%50]=0;
        AlmacenP[(OutP+2)%50]=0;
        AlmacenP[(OutP+3)%50]=0;
        OutP = (OutP+4)%50;

        int num = Integer.parseInt(this.fabrica.getLblAPatas().getText())-4;
        this.fabrica.getLblAPatas().setText(Integer.toString(num));
    }
    public void consumirA (){
        //for(int i=0; i<4; i++){
            AlmacenA[OutA]=0;
            OutA = (OutA+1)%40;
        //}
        
        int num = Integer.parseInt(this.fabrica.getLblAAsientos().getText())-1;
        this.fabrica.getLblAAsientos().setText(Integer.toString(num));
    }
    public void contratar(int cant){
        for(int j =0; j<cant; j++){
            boolean contratado = false;
            for(int i=0; i<5; i++){
                if(Ensam[i] == null && !contratado){  
                    Ensam[i] = new Ensamblador(SES,SPS,SCS,InS,OutS,SEP,SPP,SCP,InP,OutP,SEA,SPA,SCA,InA,OutA,K, fabrica,AlmacenP,AlmacenA,AlmacenS);
                    Ensam[i].start();
                    contratado = true;
                    int num = Integer.parseInt(this.fabrica.getLblEnsambladores().getText())+1;
                    this.fabrica.getLblEnsambladores().setText(Integer.toString(num));
                } else if(contratado){
                    break;
                }
            }
        }
    }
    public void despedir(int cant){
        for(int j =0; j<cant; j++){
            boolean contratado = false;
            for(int i=0; i<10; i++){
                if(Ensam[i] != null && !contratado){ 
                    Ensam[i].ejecutar = false;
                    Ensam[i] = null;
                    contratado = true;
                    int num = Integer.parseInt(this.fabrica.getLblEnsambladores().getText())-1;
                    this.fabrica.getLblEnsambladores().setText(Integer.toString(num));
                } else if(contratado){
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
