/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import sillaco.FabricaFrame;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan Arturo Blanco
 */
public abstract class Productor extends Thread{
    protected Semaphore SE;
    protected Semaphore SP;
    protected Semaphore SC;
    protected int jornada;
    protected int produc;
    protected int K;
    protected int In;
    protected int Out;
    protected FabricaFrame fabrica;

    public Productor(FabricaFrame fabrica, Semaphore SE, Semaphore SP, Semaphore SC, int jornada, int produc, int K, int In, int Out) {
        this.SE = SE;
        this.SP = SP;
        this.SC = SC;
        this.jornada = jornada;
        this.produc = produc;
        this.K = K;
        this.In = In;
        this.Out = Out;
        this.fabrica = fabrica;
    }

    public Semaphore getSE() {
        return SE;
    }

    public void setSE(Semaphore SE) {
        this.SE = SE;
    }

    public Semaphore getSP() {
        return SP;
    }

    public void setSP(Semaphore SP) {
        this.SP = SP;
    }

    public Semaphore getSC() {
        return SC;
    }

    public void setSC(Semaphore SC) {
        this.SC = SC;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getProduc() {
        return produc;
    }

    public void setProduc(int produc) {
        this.produc = produc;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public int getIn() {
        return In;
    }

    public void setIn(int In) {
        this.In = In;
    }

    public int getOut() {
        return Out;
    }

    public void setOut(int Out) {
        this.Out = Out;
    }

    public FabricaFrame getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaFrame fabrica) {
        this.fabrica = fabrica;
    }
   
}
