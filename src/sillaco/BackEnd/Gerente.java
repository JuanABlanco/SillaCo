/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco.BackEnd;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan Arturo Blanco
 */
public class Gerente extends Thread{
    private int Contador;
    private int AlmacenS [];
    private int K; 
    private Semaphore SES;
    private Semaphore SPS;
    private Semaphore SEC;
    private int OutS;

    public Gerente(int Contador, int[] AlmacenS, int K, Semaphore SES, Semaphore SPS, Semaphore SEC, int OutS) {
        this.Contador = Contador;
        this.AlmacenS = AlmacenS;
        this.K = K;
        this.SES = SES;
        this.SPS = SPS;
        this.SEC = SEC;
        this.OutS = OutS;
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
        
    }
    
    public void Despachar(){
        
    }
    
    public void Dormir(){
        
    }
    public void Motivar(){
        
    }
}
