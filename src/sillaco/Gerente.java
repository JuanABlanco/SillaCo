/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import sillaco.FabricaFrame;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Arturo Blanco
 */
public class Gerente extends Thread{
    private FabricaFrame fabrica;
    private int AlmacenS [];
    private int K; 
    private Semaphore SES;
    private Semaphore SPS;
    private Semaphore SEC;
    private Cronometrador crono;
    private int OutS;
    private int InS;
    private boolean pausa = false;

    public Gerente(FabricaFrame fabrica,Cronometrador crono, int[] AlmacenS, int K, Semaphore SES, Semaphore SPS, Semaphore SEC, int OutS, int InS) {
        this.crono=crono;
        this.AlmacenS = AlmacenS;
        this.K = K;
        this.SES = SES;
        this.SPS = SPS;
        this.SEC = SEC;
        this.OutS = OutS;
        this.InS = InS;
        this.fabrica = fabrica;
    }

    public Cronometrador getCrono() {
        return crono;
    }

    public void setCrono(Cronometrador crono) {
        this.crono = crono;
    }

    public int getInS() {
        return InS;
    }

    public void setInS(int InS) {
        this.InS = InS;
    }

    public int[] getAlmacenS() {
        return AlmacenS;
    }

    public void setAlmacenS(int[] AlmacenS) {
        this.AlmacenS = AlmacenS;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public Semaphore getSES() {
        return SES;
    }

    public void setSES(Semaphore SES) {
        this.SES = SES;
    }

    public Semaphore getSPS() {
        return SPS;
    }

    public void setSPS(Semaphore SPS) {
        this.SPS = SPS;
    }

    public Semaphore getSEC() {
        return SEC;
    }

    public void setSEC(Semaphore SEC) {
        this.SEC = SEC;
    }

    public int getOutS() {
        return OutS;
    }

    public void setOutS(int OutS) {
        this.OutS = OutS;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                SEC.acquire(1);
                    if(getCrono().getContador()==0){
                        Despachar();
                        getCrono().setContador(50);
                        this.fabrica.getLblContador().setText(Integer.toString(getCrono().getContador()));
                        K=1;
                    }else if(getCrono().getContador()<=20){
                        Motivar();
                    }
                SEC.release(1);
                Dormir();
                synchronized(this){
                    if (pausa)
                        this.wait();
                        
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Despachar(){
        try {
            int cant=0;
            SES.acquire(1);
                for(int i=0; i<100; i++){
                    if(AlmacenS[i]==1){
                        AlmacenS[i] =0;
                        cant ++;
                    }
                }
                fabrica.getLblASillas().setText("0");
                setOutS(0);
                setInS(0);
            SES.release(1);
            SPS.release(cant);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void Dormir(){
        try {
            Random r = new Random();
            this.fabrica.getjLabel13().setText("Durmiendo");
            this.sleep(42*(r.nextInt(18)+7));
            this.fabrica.getjLabel13().setText("Despierto");
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Motivar(){
        this.K=2;
    }
    public synchronized void pausa(){
        this.pausa=true;
    }
    public synchronized void reanudar(){
        this.pausa=false;
        notify();
    } 
}
