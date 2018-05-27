/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco.BackEnd;

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
    private int Contador;
    private int AlmacenS [];
    private int K; 
    private Semaphore SES;
    private Semaphore SPS;
    private Semaphore SEC;
    private int OutS;
    private int InS;

    public Gerente(FabricaFrame fabrica,int Contador, int[] AlmacenS, int K, Semaphore SES, Semaphore SPS, Semaphore SEC, int OutS, int InS) {
        this.Contador = Contador;
        this.AlmacenS = AlmacenS;
        this.K = K;
        this.SES = SES;
        this.SPS = SPS;
        this.SEC = SEC;
        this.OutS = OutS;
        this.InS = InS;
        this.fabrica = fabrica;
    }

    public int getInS() {
        return InS;
    }

    public void setInS(int InS) {
        this.InS = InS;
    }

    public int getContador() {
        return Contador;
    }

    public void setContador(int Contador) {
        this.Contador = Contador;
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
    
    public void VerCro(){
        try {
            SEC.acquire(1);
                if(Contador==0){
                    Despachar();
                }else if(Contador==30){
                    Motivar();
                }else{
                    Dormir();
                }
            SEC.release(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
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
            this.sleep(1000*(r.nextInt(18)+7));
            this.fabrica.getjLabel13().setText("Despierto");
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Motivar(){
        this.K=2;
    }
}
